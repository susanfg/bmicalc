package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BMICalcTest {
	
	private BMICalcImpl c = new BMICalcImpl();;
	
	// bmi() tests
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
	// If the weight is 65 kg and the height is 1.6 m, it has to return 25.390625
	public void bmiBothCorrect() {
		assertEquals("25,390625", c.bmi(65, 1.6));
	}
	@Test
	@DisplayName("Valid values 2")
	// If the weight is 70 kg and the height is 1.85 m, it has to return 20.45288532
	public void bmiBothCorrectBis() {
		DecimalFormat f = new DecimalFormat("#0.0000000");
		assertEquals( "20,4528853", f.format(c.bmi(70, 1.85)));
	}
	
	// category() tests
	
	@Test
	@DisplayName("Negative bmi")
	// If the bmi is a negative value, it has to return an error message
	public void negativeBmi() {
		assertEquals("Invalid bmi value", c.category(-1));
	}
	@Test
	@DisplayName("bmi = 0")
	// If the bmi is equal to zero, it has to return an error message
	public void ZeroBmi() {
		assertEquals("Invalid bmi value", c.category(0));
	}
	
	@Test
	@DisplayName("Return UNDERWEIGHT")
	// If the bmi is below 18.5, it has to return UNERWEIGHT
	public void underweightCheck() {
		assertEquals("UNDERWEIGHT", c.category(15.87));
	}
	@Test
	@DisplayName("Return UNDERWEIGHT (boundary case)")
	// If the bmi is below 18.5, it has to return UNERWEIGHT, we try with a bmi = 18.49
	public void underweightBoundCheck() {
		assertEquals("UNDERWEIGHT", c.category(18.49));
	}
	@Test
	@DisplayName("Return NORMAL")
	// If the bmi is between 18.5 and 24.9, it has to return NORMAL
	public void normalCheck() {
		assertEquals("NORMAL", c.category(20.64));
	}
	@Test
	@DisplayName("Return NORMAL (lower bound case)")
	// If the bmi is 18.5, it has to return NORMAL
	public void normalLBoundCheck() {
		assertEquals("NORMAL", c.category(18.5));
	}
	@Test
	@DisplayName("Return NORMAL (upper bound case)")
	// If the bmi is 24.9, it has to return NORMAL
	public void normalUBoundCheck() {
		assertEquals("NORMAL", c.category(24.9));
	}
	@Test
	@DisplayName("Return OVERWEIGHT")
	// If the bmi is between 25 and 29.9, it has to return OVERWEIGHT
	public void overweightCheck() {
		assertEquals("OVERWEIGHT", c.category(27.34));
	}
	@Test
	@DisplayName("Return OVERWEIGHT (lower bound case)")
	// If the bmi is 25, it has to return OVERWEIGHT
	public void overweightLBoundCheck() {
		assertEquals("OVERWEIGHT", c.category(25));
	}
	@Test
	@DisplayName("Return OVERWEIGHT (upper bound case)")
	// If the bmi is 29.9, it has to return OVERWEIGHT
	public void overweightUBoundCheck() {
		assertEquals("OVERWEIGHT", c.category(29.9));
	}
	@Test
	@DisplayName("Return OBESE")
	// If the bmi is above or equal 30.0, it has to return OBESE
	public void OBESECheck() {
		assertEquals("OBESE", c.category(45.98));
	}
	@Test
	@DisplayName("Return OBESE (boundary case)")
	// If the bmi is 30.0, it has to return OBESE
	public void obeseBoundCheck() {
		assertEquals("OBESE", c.category(30.0));
	}
	
}
