package exchange.pi.marketing.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmailAddressUtilsTest {

	@Test
	public void isValidTest() {
		assertTrue(EmailAddressUtils.isValid("Jack.chen@gmail.com")); 
		assertTrue(EmailAddressUtils.isValid("w*@gmail.com")); 
		assertTrue(EmailAddressUtils.isValid("w*12@gmail.com")); 
		assertFalse(EmailAddressUtils.isValid("w<@gmail.com")); 
		assertFalse(EmailAddressUtils.isValid("w<>o@gmail.com")); 
		assertFalse(EmailAddressUtils.isValid("@gmail.com")); 
		assertFalse(EmailAddressUtils.isValid(" @gmail.com")); 
		assertFalse(EmailAddressUtils.isValid("w @gmail.com")); 
		assertFalse(EmailAddressUtils.isValid("w w@gmail.com")); 
		assertFalse(EmailAddressUtils.isValid("w*@gmail")); 
		assertFalse(EmailAddressUtils.isValid("w*.gmail.com")); 
	}
}
