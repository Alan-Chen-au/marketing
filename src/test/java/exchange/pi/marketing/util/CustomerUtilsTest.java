package exchange.pi.marketing.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import exchange.pi.marketing.entity.Customer;

public class CustomerUtilsTest {

	@Test
	public void toCustomerTest() {
		String line = "Mr,John , Smith,john.smith@example.com"; 
		Customer customer = CustomerUtils.toCustomer(line); 
		assertNotNull(customer);
		
		line = "Mr,John,Smith,john.smith@example"; 
		customer = CustomerUtils.toCustomer(line); 
		assertNull(customer);
		
		line = "John,Smith,john.smith@example.com"; 
		customer = CustomerUtils.toCustomer(line); 
		assertNull(customer);
		
		line = "Mr,,Smith,john.smith@example.com"; 
		customer = CustomerUtils.toCustomer(line); 
		assertNull(customer);
		
		line = "Mr,  ,Smith,john.smith@example.com"; 
		customer = CustomerUtils.toCustomer(line); 
		assertNull(customer);
		
		line = " "; 
		customer = CustomerUtils.toCustomer(line); 
		assertNull(customer);
		
		line = null; 
		customer = CustomerUtils.toCustomer(line); 
		assertNull(customer);
		
		line = "Mr,John,Smith,john.smith@example, 2"; 
		customer = CustomerUtils.toCustomer(line); 
		assertNull(customer);
	}
}
