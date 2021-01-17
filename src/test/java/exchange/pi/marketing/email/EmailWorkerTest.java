package exchange.pi.marketing.email;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import exchange.pi.marketing.entity.Customer;
import exchange.pi.marketing.entity.Email;

public class EmailWorkerTest {
	
	private static Customer john;
	private static Customer max;
	
	private static Email emailTemplate; 
	private static String emailTemplateStr = "{\n" + 
			"    \"from\": \"The Marketing Team<marketing@example.com\",\n" + 
			"    \"subject\": \"{{TODAY}}, {{FIRST_NAME}} A new product is being launched soon...\",\n" + 
			"    \"mimeType\": \"text/plain\",\n" + 
			"    \"body\": \"Hi {{TITLE}} {{FIRST_NAME}} {{LAST_NAME}},\\nToday, {{TODAY}}, we would like to tell you that... Sincerely,\\nThe Marketing Team\"\n" + 
			"}"; 
	
	private static String date = "31 Dec 2020";
	
	@BeforeClass
	public static void init() {
		john = new Customer("Mr", "John", "Smith", "John.Smith@gmail.com");
		max = new Customer("Mr", "Max", "Wash", "Max.Wash@gmail.com");
		
		emailTemplate = new Email(); 
        emailTemplate.setFrom("The Marketing Team<marketing@example.com"); 
        emailTemplate.setSubject("A new product is being launched soon..."); 
        emailTemplate.setMimeType("text/plain"); 
        emailTemplate.setBody("Hi {{TITLE}} {{FIRST_NAME}} {{LAST_NAME}},\nToday, {{TODAY}}, we would like to tell you that... Sincerely,\nThe Marketing Team");

	}
	
	@Test
	public void format1Test() {
        Email email = EmailWorker.format(john, emailTemplateStr, date); 
        // skip from & mimeType; we should not find any placeholder in these two attributes. 
        
        // check subject 
        assertEquals( "31 Dec 2020, John A new product is being launched soon...", email.getSubject()); 
        // check body 
        assertEquals( "Hi Mr John Smith,\nToday, 31 Dec 2020, we would like to tell you that... Sincerely,\nThe Marketing Team", email.getBody());
	}
	
	@Test
	public void format2Test() {
        List<Customer> customers = new ArrayList<>(); 
        customers.add(john);
        customers.add(max);
        List<Email> emails = EmailWorker.format(customers, emailTemplateStr, date); 
        assertEquals(2, emails.size());
	}
}
