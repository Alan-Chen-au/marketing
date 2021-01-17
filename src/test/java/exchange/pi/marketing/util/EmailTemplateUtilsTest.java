package exchange.pi.marketing.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exchange.pi.marketing.entity.Email;

public class EmailTemplateUtilsTest {

	@Test
	public void emailTemplateValideTest() {
		Email emailTemplate = new Email(); 
		assertFalse(EmailTemplateUtils.isEmailTemplateValide(emailTemplate));
		
		emailTemplate.setFrom("kk<>@gmail.com");
		assertFalse(EmailTemplateUtils.isEmailTemplateValide(emailTemplate));
		
		emailTemplate.setSubject("New product is avaiable");
		assertFalse(EmailTemplateUtils.isEmailTemplateValide(emailTemplate));
		
		emailTemplate.setMimeType("text/plain");
		assertFalse(EmailTemplateUtils.isEmailTemplateValide(emailTemplate));
		
		emailTemplate.setBody("This is content");
		assertTrue(EmailTemplateUtils.isEmailTemplateValide(emailTemplate));
	}
}
