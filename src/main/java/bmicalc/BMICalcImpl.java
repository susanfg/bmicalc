package bmicalc;

public class BMICalcImpl implements BMICalc {

	public double bmi(double mass, double height) {
		return mass / (height * height);
	}

	public String category(double bmi) {
		String result;
		if (bmi < 18.5) result = "UNDERWEIGHT";
		else if (bmi < 25.0) result = "NORMAL";
		else if (bmi < 30.0) result = "OVERWEIGHT";
		else result = "OBESE";
		return result;
	}

	public boolean abdominalObesity(double waistCircumference, char gender) {
		return (gender == 'M' && waistCircumference > 90.0) || 
			   (gender == 'F' && waistCircumference > 80.0);
	}

}
