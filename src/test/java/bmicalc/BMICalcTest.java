package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BMICalcTest {

	private BMICalcImpl c = new BMICalcImpl();;
	private final double epsilon = 0.000001;

	// calculateBodyMassIndex() tests
	@Test
	@DisplayName("Negative Weight")
	// If the weight is a negative value, it has to throw an error
	 void bmiNegativeWeight() {
		assertThrows(RuntimeException.class, () -> c.calculateBodyMassIndex(-1, 160));
	}

	@Test
	@DisplayName("Weight = 0")
	// If the weight is equal to zero, it has to throw an error
	 void bmiZeroWeight() {
		assertThrows(RuntimeException.class, () -> c.calculateBodyMassIndex(0, 160));
	}

	@Test
	@DisplayName("Negative Height")
	// If the height is a negative value, it has to throw an error
	 void bmiNegativeHeight() {
		assertThrows(RuntimeException.class, () -> c.calculateBodyMassIndex(70, -1));
	}

	@Test
	@DisplayName("Height = 0")
	// If the height is equal to zero, it has to throw an error
	 void bmiZeroHeight() {
		assertThrows(RuntimeException.class, () -> c.calculateBodyMassIndex(70, 0));
	}

	@Test
	@DisplayName("Valid values")
	// If the weight is 65 kg and the height is 1.6 m, it has to return 25.390625
	// The third parameter is delta, we accept a difference of 0.000001 between the
	// expected value and the real value
	 void bmiBothCorrect() {
		assertEquals(25.390625, c.calculateBodyMassIndex(65, 1.6), epsilon);
	}

	@Test
	@DisplayName("Valid values 2")
	// If the weight is 70 kg and the height is 1.85 m, it has to return 20.45288532
	// We accept a difference of 0.000001 between the expected value and the real
	// value
	 void bmiBothCorrectBis() {
		assertEquals(20.4528853, c.calculateBodyMassIndex(70, 1.85), epsilon);
	}

	@Test
	@DisplayName("Weight > 800 kg")
	// If the weight is greater than 8000 kg, it is considered invalid and the
	// method throws an error
	 void weightGreater() {
		assertThrows(RuntimeException.class, () -> c.calculateBodyMassIndex(900, 1.89));
	}

	@Test
	@DisplayName("Height > 3 m")
	// If the height is greater than 3 m, it is considered invalid and the method
	// throws an error
	 void heightGreater() {
		assertThrows(RuntimeException.class, () -> c.calculateBodyMassIndex(70, 3.3));
	}

	// category() tests

	@Test
	@DisplayName("Negative bmi")
	// If the bmi is a negative value, it has to return an error message
	 void negativeBmi() {
		assertEquals(null, c.getObesityCategory(-1));
	}

	@Test
	@DisplayName("bmi = 0")
	// If the bmi is equal to zero, it has to return an error message
	 void ZeroBmi() {
		assertEquals(null, c.getObesityCategory(0));
	}

	@Test
	@DisplayName("Return UNDERWEIGHT")
	// If the bmi is below 18.5, it has to return UNERWEIGHT
	 void underweightCheck() {
		assertEquals(ObesityCategory.UNDERWEIGHT, c.getObesityCategory(15.87));
	}

	@Test
	@DisplayName("Return UNDERWEIGHT (boundary case)")
	// If the bmi is below 18.5, it has to return UNERWEIGHT, we try with a bmi =
	// 18.49
	 void underweightBoundCheck() {
		assertEquals(ObesityCategory.UNDERWEIGHT, c.getObesityCategory(18.49));
	}

	@Test
	@DisplayName("Return NORMAL")
	// If the bmi is between 18.5 and 24.9, it has to return NORMAL
	 void normalCheck() {
		assertEquals(ObesityCategory.NORMAL, c.getObesityCategory(20.64));
	}

	@Test
	@DisplayName("Return NORMAL (lower bound case)")
	// If the bmi is 18.5, it has to return NORMAL
	 void normalLBoundCheck() {
		assertEquals(ObesityCategory.NORMAL, c.getObesityCategory(18.5));
	}

	@Test
	@DisplayName("Return NORMAL (upper bound case)")
	// If the bmi is 24.9, it has to return NORMAL
	 void normalUBoundCheck() {
		assertEquals(ObesityCategory.NORMAL, c.getObesityCategory(24.9));
	}

	@Test
	@DisplayName("Return OVERWEIGHT")
	// If the bmi is between 25 and 29.9, it has to return OVERWEIGHT
	 void overweightCheck() {
		assertEquals(ObesityCategory.OVERWEIGHT, c.getObesityCategory(27.34));
	}

	@Test
	@DisplayName("Return OVERWEIGHT (lower bound case)")
	// If the bmi is 25, it has to return OVERWEIGHT
	 void overweightLBoundCheck() {
		assertEquals(ObesityCategory.OVERWEIGHT, c.getObesityCategory(25));
	}

	@Test
	@DisplayName("Return OVERWEIGHT (upper bound case)")
	// If the bmi is 29.9, it has to return OVERWEIGHT
	 void overweightUBoundCheck() {
		assertEquals(ObesityCategory.OVERWEIGHT, c.getObesityCategory(29.9));
	}

	@Test
	@DisplayName("Return OBESE")
	// If the bmi is above or equal 30.0, it has to return OBESE
	 void OBESECheck() {
		assertEquals(ObesityCategory.OBESE, c.getObesityCategory(45.98));
	}

	@Test
	@DisplayName("Return OBESE (boundary case)")
	// If the bmi is 30.0, it has to return OBESE
	 void obeseBoundCheck() {
		assertEquals(ObesityCategory.OBESE, c.getObesityCategory(30.0));
	}

	// abdominalObesity()
	@Test
	@DisplayName("Negative waist circumference male")
	// If the waist circumference is a negative value, it has to throw an error
	 void negativeMale() {
		assertThrows(RuntimeException.class, () -> c.abdominalObesity(-1, Gender.MALE));
	}

	@Test
	@DisplayName("Negative waist circumference female")
	// If the waist circumference is a negative value, it has to throw an error
	 void negativeFemale() {
		assertThrows(RuntimeException.class, () -> c.abdominalObesity(-1, Gender.FEMALE));
	}

	@Test
	@DisplayName("waist circumference = 0, male")
	// If the waist circumference is zero, it has to throw an error
	 void ZeroMale() {
		assertThrows(RuntimeException.class, () -> c.abdominalObesity(0, Gender.MALE));
	}

	@Test
	@DisplayName("waist circumference = 0, female")
	// If the waist circumference is zero, it has to throw an error
	 void ZeroFemale() {
		assertThrows(RuntimeException.class, () -> c.abdominalObesity(0, Gender.MALE));
	}

	@Test
	@DisplayName("waist circumference > 1000, female")
	// If the waist circumference is greater than 1000 cm, it has to throw an error
	 void wcGreaterFemale() {
		assertThrows(RuntimeException.class, () -> c.abdominalObesity(1200, Gender.FEMALE));
	}

	@Test
	@DisplayName("waist circumference > 0, male")
	// If the waist circumference is greater than 1000 cm, it has to throw an error
	 void wcGreaterMale() {
		assertThrows(RuntimeException.class, () -> c.abdominalObesity(1200, Gender.MALE));
	}

//	@Test
//	@DisplayName("Invalid gender character")
//	// If the gender is not an "m" or "f" (without discriminating lowercase and uppercase), it has to throw an error
//	 void invalidCharacter(){
//		assertThrows(RuntimeException.class, ()->c.abdominalObesity(170, 'g'));
//
//		}
//	@Test
//	@DisplayName("Lowercase Male")
//	// If the gender is a lowercase "m", it has to return the correct result for men. In this case it has to return TRUE
//	 void lowercaseMale(){
//		assertEquals(true, c.abdominalObesity(170, 'm'));
//		}
//	@Test
//	@DisplayName("Lowercase Female")
//	// If the gender is a lowercase "f", it has to return the correct result for female. In this case it has to return FALSE
//	 void lowercaseFemale(){
//		assertEquals(false, c.abdominalObesity(60, 'f'));
//		}
	@Test
	@DisplayName("Female with abdominal obesity")
	// If the waist circumference value is greater than 80 cm, and the gender is
	// 'F', it has to return TRUE
	 void abdObesityF() {
		assertEquals(true, c.abdominalObesity(90, Gender.FEMALE));
	}

	@Test
	@DisplayName("Female without abdominal obesity, on the limit")
	// If the waist circumference value is 80 cm, and the gender is 'F', it has to
	// return FALSE
	 void boundaryF() {
		assertEquals(false, c.abdominalObesity(80, Gender.FEMALE));
	}

	@Test
	@DisplayName("Female without abdominal obesity")
	// If the waist circumference value is 80 cm or less, and the gender is 'F', it
	// has to return FALSE
	 void noAbdObesityF() {
		assertEquals(false, c.abdominalObesity(70, Gender.FEMALE));
	}

	@Test
	@DisplayName("Male with abdominal obesity")
	// If the waist circumference value is greater than 90 cm, and the gender is
	// 'M', it has to return TRUE
	 void abdObesityM() {
		assertEquals(true, c.abdominalObesity(100, Gender.FEMALE));
	}

	@Test
	@DisplayName("Male without abdominal obesity, on the limit")
	// If the waist circumference value is 90 cm, and the gender is 'M', it has to
	// return FALSE
	 void boundaryM() {
		assertEquals(false, c.abdominalObesity(90, Gender.MALE));
	}

	@Test
	@DisplayName("Male without abdominal obesity")
	// If the waist circumference value is 90 cm or less, and the gender is 'F', it
	// has to return FALSE
	 void noAbdObesityM() {
		assertEquals(false, c.abdominalObesity(76, Gender.MALE));
	}

}
