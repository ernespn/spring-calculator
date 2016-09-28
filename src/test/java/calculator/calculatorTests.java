package calculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import calculator.models.Result;

public class calculatorTests {
	@Test
	public void AddTwoNumbers(){
		Result calculation = new Result(3,5);
		int actual = calculation.getResult();
		String from = calculation.getFrom();
		assertEquals(8, actual);
		assertEquals("Java Spring service", from);
	}
	
}
