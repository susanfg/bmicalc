package bmicalc;

import java.util.Scanner;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Singleton pattern
		 */
		try {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			BMICalcImpl singleton = BMICalcImpl.getInstance();
			
			System.out.println("Introduce your weight: ");
			String weights = sc.nextLine().replace(',', '.');
			double weight = Double.parseDouble(weights);
			
			System.out.println("Introduce your height: ");
			String heights = sc.nextLine().replace(',', '.');
			double height = Double.parseDouble(heights);
			
			System.out.println("Introduce your gender (F/M): ");
			char gender = sc.nextLine().charAt(0);
			
			System.out.println("Introduce your waist circumference: ");
			String wcs = sc.nextLine().replace(',', '.');
			double wc = Double.parseDouble(wcs);
			
			double sbmi = singleton.bmi(weight, height);
			String scat = singleton.category(sbmi);
			boolean sabdO = singleton.abdominalObesity(wc, gender);
			String abdominalOb = sabdO? "" : "do not ";
			
			System.out.println("Testing Singleton Pattern");
			
			System.out.println("Your BMI is: " + sbmi + ", your category is " + scat + " and you " + abdominalOb + "have abdominal obesity.");

			
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
		
//		
//		BMICalcAdapter c = new BMICalcAdapter();
//		if (c.tieneObesidadAbdominal('f', 90) == true) {
//			System.out.println("The patient has abdominal obesity");
//		}else {
//			System.out.println("The patient does not have abdominal obesity");
//
//		}
//		
//		System.out.println(c.imc(1.7, 90));
//		BMICalcProxy calc = new BMICalcProxy();
//		System.out.print(calc.imc(0, 0));
	}
	

}
