package exchange.pi.marketing.util;

public class StringUtils {

	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0; 
	}
	
	public static boolean isValid(String s) {
		return !StringUtils.isEmpty(s);  
	}
}
