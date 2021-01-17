package exchange.pi.marketing.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void isEmptyTest() {
		assertTrue(StringUtils.isEmpty(""));
		assertTrue(StringUtils.isEmpty("  "));
		assertTrue(StringUtils.isEmpty(null));
		assertFalse(StringUtils.isEmpty("."));
	}
	
	@Test
	public void isValidTest() {
		assertFalse(StringUtils.isValid(""));
		assertFalse(StringUtils.isValid("  "));
		assertFalse(StringUtils.isValid(null));
		assertTrue(StringUtils.isValid("."));
	}
}
