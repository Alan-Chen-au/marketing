package exchange.pi.marketing.util;

import exchange.pi.marketing.entity.Email;

public class EmailTemplateUtils {

	public static boolean isEmailTemplateValide(Email emailTemplate) {
		if (StringUtils.isValid(emailTemplate.getFrom()) && StringUtils.isValid(emailTemplate.getSubject()) 
				&& StringUtils.isValid(emailTemplate.getMimeType()) && StringUtils.isValid(emailTemplate.getBody())) {
			return true;
		}
		
		return false;
	}
}
