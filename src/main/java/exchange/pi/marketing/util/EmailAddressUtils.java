package exchange.pi.marketing.util;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailAddressUtils {
	
	public static final EmailValidator emailValidator = EmailValidator.getInstance();
	
	public static boolean isValid(String emailAddr) {
		return emailValidator.isValid(emailAddr);
	}
}
