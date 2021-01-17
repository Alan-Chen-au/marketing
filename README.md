# marketing


****************************************************************

1) JDK 8 is required for compiling and running this project. 

2) Based on the doc - PI.EXCHANGE_Software Engineer Case Study_20201021.pdf, 
   the subject value in the email template is "A new product is being launched soon...";  
   however the value in the sample email template is "{{FIRST_NAME}}, a new product is being launched soon...". 
   So the email template is dynamic; but I assume that both subject and body may have the placeholder;  
   other attributes do no have any placeholder. PLEASE LET ME KNOW IF THIS ASSUMPTION IS NOT CORRECT. 
   
*****************************************************************************

1, Get the source code from github : 

   URL : https://github.com/Alan-Chen-au/marketing.git
   
2, Get jar file from : target/marketing-0.1-jar-with-dependencies.jar 

3, Run from jar (assume JDK 8 has been installed in your local host); COMMAND is shown below : 

   java -jar marketing-0.1-jar-with-dependencies.jar /path/to/email_template.json /path/to/customers.csv /path/to/output_emails/ /path/to/errors.csv
   
   
   