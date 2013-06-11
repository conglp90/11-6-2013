import static org.junit.Assert.*;

import org.junit.Test;
public class CalculatorTest {
	@Test
	public void testNull() {
		assertTrue(Calculator.add(null) == 0);
	}

	@Test
	public void testBlankValue() {
		assertTrue(Calculator.add("") == 0);
	}

	@Test
	public void testWithOneValue() {
		assertTrue(Calculator.add("1") == 1);
		assertTrue(Calculator.add("111") == 111);
	}
	
	@Test
	public void testWithTwoValue() {
		assertTrue(Calculator.add("1,2") == 3);
		assertTrue(Calculator.add("20,124") == 144);
	}
	
	@Test
	public void testUnknownNumberOfValue() {
		assertTrue(Calculator.add("1,2,3,4") == 10);
		assertTrue(Calculator.add("1,2,3,4,5") == 15);
	}

	@Test
	public void testWithNewLine() {
		assertTrue(Calculator.add("1\n2,3,4") == 10);
		assertTrue(Calculator.add("1\n2,3\n4") == 10);
	}

	@Test
	public void testWithOneCharDelimiter() {
		assertTrue(Calculator.add("//;\n1\n2;3,4") == 10);
	}
	
	@Test
	public void testWithNegativeNumber() {
		Exception e = null;
		// ////////////////////////////
		try {
			Calculator.add("-100,-2000,-3,-7");
		} catch (Exception e1) {
			// 
			e = e1;
			System.out.println(e.getMessage());
		}
		assertTrue(e.getMessage().equals("negatives not allowed: -100, -2000, -3, -7"));
	}
	
	@Test
	public void testWithNumberLagerThan1000() {
		assertTrue(Calculator.add("1,2,3,1004") == 6);
	}
	
	@Test
	public void testWithMultiCharDelimiter() {
		assertTrue(Calculator.add("//[a$^5&%a]\n1a$^5&%a2a$^5&%a3a$^5&%a4") == 10);
	}
}
