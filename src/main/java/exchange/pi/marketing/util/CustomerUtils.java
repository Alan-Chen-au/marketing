package exchange.pi.marketing.util;

import exchange.pi.marketing.entity.Customer;

public class CustomerUtils {

	public static Customer toCustomer(String line) {
		
		if (StringUtils.isEmpty(line)) {
			return null; 
		}
		
		String[] ss = line.split(","); 
		
		if (ss.length != 4 ) {
			return null; 
		}
		
		for (String s : ss) {
			if (StringUtils.isEmpty(s)) {
				return null; 
			}
		}
		
		// check the email format is valid : ss[3]
		if (!EmailAddressUtils.isValid(ss[3]) ) {
			return null;
		}
		
		return new Customer(ss[0].trim(), ss[1].trim(), ss[2].trim(), ss[3].trim());
	}
}
