package bmicalc;


public class BMICalcImpl implements BMICalc {

	/**
	 * Calculate the Body Mass Index (BMI) of a person.
	 * BMI = mass (kg) / height^2 (m)
	 * 
	 * @param mass 	 Weight of the person.
	 * @param height Height of the person.
	 * @return 		 The Body Mass Index (BMI) value.
	 */
	public double bmi(double mass, double height) {
		
		if(mass <= 0 || height <=0) {
			return  -1;
		}
		
		double bmi = mass / Math.pow(height, 2);
		//DecimalFormat f = new DecimalFormat("#.0000");
		//bmi = Double.parseDouble(f.format(bmi));
		return bmi;
	}

	public String category(double bmi) {
		return "";
	}

	public boolean abdominalObesity(double waistCircumference, char gender) {
		return false;
	}

}
