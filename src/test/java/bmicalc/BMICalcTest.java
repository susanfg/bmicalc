package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

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
	// If the weight is 65 kg and the height is 160 cm, it has to return 0.0025390625
	public void bmiBothCorrect() {
		assertEquals(0.0025390625, c.bmi(65, 160));
	}
	@Test
	@DisplayName("Valid values 2")
	// If the weight is 100 kg and the height is 160 cm, it has to return 0.0027700831
	public void bmiBothCorrectBis() {
		DecimalFormat f = new DecimalFormat("#0.00000000000");
		assertEquals("0,00248015873", f.format(c.bmi(70, 168)));
	}
}
