package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BMICalcTest {
	
	private BMICalcImpl c = new BMICalcImpl();;
	
	@Test
	@DisplayName("Negative Weight")
	// If the weight is a negative value, it has to return -1
	public void bmiNegativeWeight() {
		assertEquals(-1, c.bmi(-1, 160));
	}
	@Test
	@DisplayName("Weight = 0")
	// If the weight is equal to zero, it has to return -1
	public void bmiZeroWeight() {
		assertEquals(-1, c.bmi(0, 160));
	}
	@Test
	@DisplayName("Negative Height")
	// If the height is a negative value, it has to return -1
	public void bmiNegativeHeight() {
		assertEquals(-1, c.bmi(70, -1));
	}
	@Test
	@DisplayName("Height = 0")
	// If the height is equal to zero, it has to return -1
	public void bmiZeroHeight() {
		assertEquals(-1, c.bmi(70, 0));
	}
	@Test
	@DisplayName("Valid values")
	// If the weight is 100 kg and the height is 190 cm, it has to return 0.002770083102
	public void bmiBothCorrect() {
		assertEquals(0.0025390625, c.bmi(65, 160));
	}
}
