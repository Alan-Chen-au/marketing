package exchange.pi.marketing;

import org.apache.log4j.Logger;

import exchange.pi.marketing.email.EmailWorker;

/**
 * generate email content based on email template and customer details 
 *
 */
public class App {
	
	private static final Logger log = Logger.getLogger(App.class);
	
    public static void main( String[] args ) {
        if (args == null || args.length != 4) {
        	log.error("4 Files (Input parameter) are required.");
        	log.info("Please follow the command as below : ");
        	log.info("java -jar marketing-0.1-jar-with-dependencies.jar /path/to/email_template.json " + 
        			"/path/to/customers.csv /path/to/output_emails/ /path/to/errors.csv");
        	
        	System.exit(1);
        } else {
    		log.info("Email Template : " + args[0]);
    		log.info("Customers File : " + args[1]);
    		log.info("Output Dir : " + args[2]);
    		log.info("Error File : " + args[3]);
        }
        
        // generate the email content 
        try {
			EmailWorker.generateEmailContent(args[0], args[1], args[2], args[3]);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			System.exit(1);
		}
        
        log.info("Output files have been generated successfully. " + args[2]);
    }
}
