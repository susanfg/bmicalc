package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BMICalcTest {
	
	private BMICalcImpl c = new BMICalcImpl();;
	
	@Test
	@DisplayName("Negative Weight")
	// If the weight is a negative value, it has to return an error message
	public void bmiNegativeWeight() {
		assertEquals("Invalid weight", c.bmi(-1, 160));
	}
	@Test
	@DisplayName("Weight = 0")
	// If the weight is equal to zero, it has to return an error message
	public void bmiZeroWeight() {
		assertEquals("Invalid weight", c.bmi(0, 160));
	}
	@Test
	@DisplayName("Negative Height")
	// If the height is a negative value, it has to return an error message
	public void bmiNegativeHeight() {
		assertEquals("Invalid height", c.bmi(70, -1));
	}
	@Test
	@DisplayName("Height = 0")
	// If the height is equal to zero, it has to return an error message
	public void bmiZeroHeight() {
		assertEquals("Invalid height", c.bmi(70, 0));
	}
	@Test
	@DisplayName("Valid values")
	// If the weight is 100 kg and the height is 190 cm, it has to return 0.002770083102
	public void bmiBothCorrect() {
		assertEquals(0.002770083102, c.bmi(-1, 160));
	}
}
