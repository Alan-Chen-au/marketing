package exchange.pi.marketing.gson;

import static org.junit.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import exchange.pi.marketing.entity.Email;
import exchange.pi.marketing.util.FileUtils;

public class GsonTest {
	
	private static List<Email> emails = new ArrayList<>();
	private static Email email1; 
	private static Email email2; 
	
	@BeforeClass
	public static void init() {
		email1 = new Email("ab<c@gmail.com", "John@gmail.com", "Hi John, has new product. ", "text/plain" ,"welcome back 111 !!!"); 
		email2 = new Email("kk<k@gmail.com", "Mick@gmail.com", "Hi Mick, has new product. ", "text/plain" ,"welcome back 222 !!!"); 
		emails.add(email1);
		emails.add(email2);
	}
	
	@Test 
	public void gsonDisableHtmlEscapingTest() throws IOException {
		 // write output file
		String fileName = "gsonDisableHtmlEscapingTest.json"; 
		Writer writer = new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"); 
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        gson.toJson(emails, writer); 
        writer.close(); 
        
        String json = FileUtils.readEmailTemplateFile(fileName); 
        assertTrue(json.contains(email1.getFrom())); 
        assertTrue(json.contains(email2.getFrom())); 
	}

}
