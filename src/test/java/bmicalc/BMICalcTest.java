package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BMICalcTest {

	private final BMICalc c = new BMICalcImpl();
	
	@Test
	public void bmi() {
		assertEquals(28.44, c.bmi(64, 1.5));
		assertEquals(0, c.bmi(0, 0));
	}
	
	@Test
	public void bmi2() {
		assertEquals(true, true);
	}
}
