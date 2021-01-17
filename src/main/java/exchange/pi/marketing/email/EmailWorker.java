package exchange.pi.marketing.email;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import exchange.pi.marketing.entity.Customer;
import exchange.pi.marketing.entity.Email;
import exchange.pi.marketing.util.CustomerUtils;
import exchange.pi.marketing.util.EmailTemplateUtils;
import exchange.pi.marketing.util.FileUtils;

public class EmailWorker {
	
	private static Gson gson = new Gson(); 
	
	private static String TITLE_REGEX 		= "\\{\\{TITLE\\}\\}"; 
	private static String FIRST_NAME_REGEX 	= "\\{\\{FIRST_NAME\\}\\}"; 
	private static String LAST_NAME_REGEX 	= "\\{\\{LAST_NAME\\}\\}"; 
	private static String TODAY_REGEX 		= "\\{\\{TODAY\\}\\}"; 
	
	public static void generateEmailContent(String emailTempFile, String customerFile, String outputDir, String errorFile) throws JsonIOException, IOException {
		
		// error handling --> make sure input file names are correct. 
		if (!FileUtils.isFileNameValid(emailTempFile) || !FileUtils.isFileNameValid(customerFile)
				|| !FileUtils.isFileNameValid(outputDir) || !FileUtils.isFileNameValid(errorFile)) {
			throw new RuntimeException("Please make sure input file name is correct. ");  
		}
		
		// read email template file and do verify 
		String emailTempStr = FileUtils.readEmailTemplateFile(emailTempFile);
		// convert to Entity
        Email emailTemplate = new Gson().fromJson(emailTempStr, Email.class);
        // verify the entity
        if (!EmailTemplateUtils.isEmailTemplateValide(emailTemplate)) {
        	throw new RuntimeException("Please make sure Email Template is valide. All attributes are required. ");  
        }
        
        // read customers file and do verify
        List<String> customerStr = FileUtils.readCustomerFile(customerFile); 
        if (customerStr == null || customerStr.size() <= 1) {
        	throw new RuntimeException("There is no customer in the file : " + customerFile);  
        }
        
        // remove the title line 
        customerStr.remove(0); 
        
        // get all valid customers
        List<Customer> customers = new ArrayList<>(); 
        // get all invalid customers
        List<String> errorCustomers = new ArrayList<>();
        Customer customer = null;
        
        for (String s : customerStr) {
        	customer = CustomerUtils.toCustomer(s); 
        	if (customer == null) {
        		errorCustomers.add(s);
        	} else {
        		customers.add(customer); 
        	}
        }
        
        // format email template based on customers
        LocalDate locaDate = LocalDate.now();
        String today = locaDate.format(DateTimeFormatter.ofPattern("d MMM uuuu "));
        
        // List<Email> emails = EmailWorker.format(customers, emailTemplate, today); 
        List<Email> emails = EmailWorker.format(customers, emailTempStr, today); 
        
        // write output file
        Writer writer = null; 
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create(); 
        
        if ('/' != outputDir.charAt(outputDir.length() - 1)) {
        	outputDir = outputDir + '/'; 
        } 
        
        for (Email email : emails) {
	        writer = new FileWriter(outputDir + email.getTo() + ".json"); 
	        gson.toJson(email, writer); 
	        writer.close(); 
        }
        
		// has any error customer; write error file
        if (errorCustomers.size() > 0) {
        	writer = new FileWriter(errorFile); 
        	for(String str: errorCustomers) {
        	  writer.write(str + System.lineSeparator());
        	}
        	writer.close();
        }
	}
	
	public static Email format(Customer customer, final String emailTemplateStr, String today) {
		String content = emailTemplateStr;   
		content = content.replaceAll(TITLE_REGEX, customer.getTitle()); 
		content = content.replaceAll(FIRST_NAME_REGEX, customer.getFirstName()); 
		content = content.replaceAll(LAST_NAME_REGEX, customer.getLastName()); 
		content = content.replaceAll(TODAY_REGEX, today); 
		
		Email email = gson.fromJson(content, Email.class);
		email.setTo(customer.getEmail());
		return email; 
	}
	
	public static List<Email> format(List<Customer> customers, String emailTemplateStr, String today) {
		List<Email> emails = new ArrayList<>();
		customers.stream().forEach(customer -> emails.add(EmailWorker.format(customer, emailTemplateStr, today)));
		return emails;
	}
}
