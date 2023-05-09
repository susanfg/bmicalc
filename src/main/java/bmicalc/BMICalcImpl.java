package bmicalc;

public class BMICalcImpl implements CardiovascularMetrics, MetabolicMetrics {

	public double calculateBodyMassIndex(double mass, double height) {

		if (mass <= 0 || mass > 800) {
			throw new RuntimeException("Invalid mass value");
		} else if (height <= 0 || height > 3) {
			throw new RuntimeException("Invalid height value");
		}


		return mass / Math.pow(height, 2);
	}

	public ObesityCategory getObesityCategory(double bmi) {
		ObesityCategory res;
		if (bmi <= 0) {
			res = null;
			System.out.println("Invalid bmi value");
		} else if (bmi > 0 && bmi < 18.5) {
			res = ObesityCategory.UNDERWEIGHT;

		} else if (bmi >= 18.5 && bmi < 25) {
			res = ObesityCategory.NORMAL;

		} else if (bmi >= 25 && bmi < 30) {
			res = ObesityCategory.OVERWEIGHT;

		} else {
			res = ObesityCategory.OBESE;
		}
		return res;
	}

	public boolean abdominalObesity(double waistCircumference, Gender gender) {
		boolean res;
		if (waistCircumference <= 0 || waistCircumference > 1000) {
			throw new RuntimeException("Invalid waist circumference value");
		} else if (gender == Gender.MALE) {
			if (waistCircumference <= 90) {
				res = false;
			} else {
				res = true;
			}
		} else {
			if (waistCircumference <= 80) {
				res = false;
			} else {
				res = true;
			}
		}
		return res;
	}

}
