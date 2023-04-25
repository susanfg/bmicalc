package bmicalc;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Map;

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
			sc.close();
			
			System.out.println("Testing Singleton Pattern");
			System.out.println("Your BMI is: " + sbmi + ", your category is " + scat + " and you " + abdominalOb + "have abdominal obesity.");

			/**
			 * Adapter pattern
			 */
			BMICalcAdapter adapter = new BMICalcAdapter();
			Map<Double, String> imc = adapter.imc(height, weight);
			boolean abdaO = adapter.tieneObesidadAbdominal(gender, wc);
			String abdominalaOb = abdaO? "" : "do not ";
			
			System.out.println();
			System.out.println("Testing Adapter Pattern");
			System.out.println("Your BMI and category are: " + imc + " and you " + abdominalaOb + "have abdominal obesity.");
			
			/**
			 * Proxy pattern
			 */
			BMICalcProxy proxy = new BMICalcProxy();
			// We are adding patients here in order to test the means computing
			proxy.imc(1.8, 79);
			proxy.imc(1.54, 63);
			proxy.imc(1.67, 56);
			proxy.imc(1.78, 92);

			Map<Double, String> imcp = proxy.imc(height, weight);
			boolean abdOp = proxy.tieneObesidadAbdominal(gender, wc);
			String abdominalObp = abdOp? "" : "do not ";
			double meanH = proxy.alturaMedia();
			double meanW = proxy.pesoMedio();
			double meanIMC = proxy.imcMedio();
			int numP = proxy.numPacientes();
			
			System.out.println();
			System.out.println("Testing Proxy Pattern");
			System.out.println("Your BMI and category are: " + imcp + " and you " + abdominalObp + "have abdominal obesity");
			System.out.println("The mean height is : " + meanH);
			System.out.println("The mean weight is : " + meanW);
			System.out.println("The mean IMC is : " + meanIMC);
			System.out.println("The number of patients that have used the calculator is : " + numP);
			
			/*
			 * Decorator pattern
			 */
			
			System.out.println();
			System.out.println("Testing Decorator Pattern");
			System.out.println("Calculadora europea");
			BMICalcEuropean europe = new BMICalcEuropean(proxy);
			europe.imc(height, weight);
			europe.tieneObesidadAbdominal(gender, wc);
			// we can check if using the decorator increments the number of patients and updates the mean values
			System.out.println("Numero de pacientes: " + proxy.numPacientes());
			System.out.println("Altura media: " + proxy.alturaMedia());
			System.out.println("Peso medio: " + proxy.pesoMedio());
			System.out.println("IMC medio: " + proxy.imcMedio());

			System.out.println();
			System.out.println("American Calculator");
			BMICalcAmerican american = new BMICalcAmerican(proxy);
			// converting to lb, feet and inches so we can test the conversion to kg, m and cm
			double heightAm = height * 3.28084;
			double weightAm = weight * 2.20462;
			double wcAm = wc / 2.54;
			american.imc(heightAm, weightAm);
			american.tieneObesidadAbdominal(gender, wcAm);
			System.out.println("Number of patients: " + proxy.numPacientes());
			System.out.println("Mean height: " + proxy.alturaMedia());
			System.out.println("Mean weight: " + proxy.pesoMedio());
			System.out.println("Mean BMI: " + proxy.imcMedio());

		}catch(RuntimeException e)   {
			System.out.println(e.getMessage());
		}
		
		
		

	}
	

}
