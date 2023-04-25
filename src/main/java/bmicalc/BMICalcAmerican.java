package bmicalc;

import java.util.Iterator;
import java.util.Map;

public class BMICalcAmerican extends BaseDecorator {

	public BMICalcAmerican(IMCHospital c) {
		super(c);
	}

	// 1m = 3,28084 feet, 1 kg = 2,20462 pound
	@Override
	public Map<Double, String> imc(double altura, double peso) {
		altura = altura / 3.28084;
		peso = peso / 2.20462;
		
		Map<Double, String> bmi = c.imc(altura, peso);

		Iterator<Double> it = bmi.keySet().iterator();
		if (it.hasNext()) {
			Double clave = it.next();

			String valor = bmi.get(clave);

			System.out.println("The " + altura + " feet tall person and " + peso + " pound weight " + "has a BMI of "
					+ clave + " and is in category " + valor);
		}

		return bmi;
	}

	// receives circumference in inches, 1 in = 2.54 cm
	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		circunferencia = circunferencia * 2.54;
		try {
			boolean abdO = c.tieneObesidadAbdominal(genero, circunferencia);
			String gen;
			if (genero == ('f') || genero == 'F') {
				gen = "femenine";
			} else { // en otro caso sera m o M porque no se ha lanzado excepcion
				gen = "masculine";
			}
			String abdominalOb = abdO ? "" : " does not";

			System.out.println("The " + gen + " person with an abdominal circumference of " + circunferencia + " inches"
					+ abdominalOb + " have abdominal obesity");
			return abdO;
		} catch (RuntimeException e) {

		}

		return false;
	}
}
