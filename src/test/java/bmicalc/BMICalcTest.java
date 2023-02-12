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
	/**
	 * Determine whether a person has abdominal obesity.
	 * A woman has abdominal obesity if her waist circumference is greater than 80 cm.
	 * A man has abdominal obesity if his waist circumference is greater than 90 cm.
	 * 
	 * @param waistCircumference	Waist circumference.
	 * @param gender				Male ('M') or Female ('F').
	 * @return						True if the person has abdominal obesity, false otherwise.
	 */
	// abdominalObesity()
	@Test
	@DisplayName("Negative waist circumference male")
	// If the waist circumference is a negative value, it has to return an error message
	public void negativeMale(){
		assertEquals("Invalid waist circumference value", c.abdominalObesity(-1, 'M'));
		}
	@Test
	@DisplayName("Negative waist circumference female")
	// If the waist circumference is a negative value, it has to return an error message
	public void negativeFemale(){
		assertEquals("Invalid waist circumference value", c.abdominalObesity(-1, 'F'));
		}
	@Test
	@DisplayName("waist circumference = 0, male")
	// If the waist circumference is zero, it has to return an error message
	public void ZeroMale(){
		assertEquals("Invalid waist circumference value", c.abdominalObesity(0, 'M'));
		}
	@Test
	@DisplayName("waist circumference = 0, female")
	// If the waist circumference is zero, it has to return an error message
	public void ZeroFemale(){
		assertEquals("Invalid waist circumference value", c.abdominalObesity(0, 'M'));
		}
	@Test
	@DisplayName("Invalid gender character")
	// If the gender is not an "m" or "f" (without discriminating lowercase and uppercase), it has to return an error message
	public void invalidCharacter(){
		assertEquals("Invalid gender character", c.abdominalObesity(90, 'g'));
		}
	@Test
	@DisplayName("Lowercase Male")
	// If the gender is a lowercase "m", it has to return the correct result for men. In this case it has to return TRUE
	public void lowercaseMale(){
		assertEquals("Invalid gender character", c.abdominalObesity(170, 'm'));
		}
	@Test
	@DisplayName("Lowercase Female")
	// If the gender is a lowercase "f", it has to return the correct result for female. In this case it has to return FALSE
	public void lowercaseFemale(){
		assertEquals("Invalid gender character", c.abdominalObesity(60, 'f'));
		}
	@Test
	@DisplayName("Female with abdominal obesity")
	// If the waist circumference value is greater than 80 cm, and the gender is 'F', it has to return TRUE
	public void abdObesityF() {
		assertEquals(true, c.abdominalObesity(90, 'F'));
	}
	@Test
	@DisplayName("Female without abdominal obesity, on the limit")
	// If the waist circumference value is 80 cm, and the gender is 'F', it has to return FALSE
	public void boundaryF() {
		assertEquals(false, c.abdominalObesity(80, 'F'));
	}
	@Test
	@DisplayName("Female without abdominal obesity")
	// If the waist circumference value is 80 cm or less, and the gender is 'F', it has to return FALSE
	public void noAbdObesityF() {
		assertEquals(false, c.abdominalObesity(70, 'F'));
	}
	
	
	
	@Test
	@DisplayName("Male with abdominal obesity")
	// If the waist circumference value is greater than 90 cm, and the gender is 'M', it has to return TRUE
	public void abdObesityM() {
		assertEquals(true, c.abdominalObesity(100, 'M'));
	}
	@Test
	@DisplayName("Male without abdominal obesity, on the limit")
	// If the waist circumference value is 90 cm, and the gender is 'M', it has to return FALSE
	public void boundaryM() {
		assertEquals(false, c.abdominalObesity(90, 'F'));
	}
	@Test
	@DisplayName("Male without abdominal obesity")
	// If the waist circumference value is 90 cm or less, and the gender is 'F', it has to return FALSE
	public void noAbdObesityM() {
		assertEquals(false, c.abdominalObesity(76, 'F'));
	}
	
}
