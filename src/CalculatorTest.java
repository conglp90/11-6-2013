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
////	//
	@Test
	public void testWithOneValue() {
		assertTrue(Calculator.add("1") == 1);
		assertTrue(Calculator.add("111") == 111);
	}
}
