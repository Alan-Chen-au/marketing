package exchange.pi.marketing.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
	
	public static String readEmailTemplateFile(String fileName) throws IOException {
	    return new String ( Files.readAllBytes( Paths.get( fileName ) ) );
	}
	
	public static List<String> readCustomerFile(String filename) throws IOException {
		return Files.readAllLines(Paths.get(filename));
	}
	
	public static boolean isFileNameValid(String fileName) {
		return StringUtils.isValid(fileName); 
	}
}
