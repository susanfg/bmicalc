package bmicalc;

import java.util.Iterator;
import java.util.Map;

public class BMICalcEuropean extends BaseDecorator {
	public BMICalcEuropean(IMCHospital c) {
		super(c);
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		Map<Double, String> bmi = c.imc(altura, peso);

		Iterator<Double> it = bmi.keySet().iterator();
		if (it.hasNext()) {
			Double clave = it.next();

			String valor = bmi.get(clave);
			if (valor.equals("OBESE")) {
				valor = "OBESA";
			} else if (valor.equals("OVERWEIGHT")) {
				valor = "SOBREPESO";
			} else if (valor.equals("UNDERWEIGHT")) {
				valor = "BAJO PESO";
			}

			System.out.println("La persona con altura " + altura + " metros y " + peso + " kilos de peso "
					+ "tiene un IMC de " + clave + " y es de la categoría " + valor);
		}

		return bmi;
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		try {
			boolean abdO = c.tieneObesidadAbdominal(genero, circunferencia);
			String gen;
			if (genero == ('f') || genero == 'F') {
				gen = "femenino";
			} else { // en otro caso sera m o M porque no se ha lanzado excepcion
				gen = "masculino";
			}
			String abdominalOb = abdO ? "" : "no ";

			System.out.println("La persona de género " + gen + " " + abdominalOb + "tiene obesidad abdominal");
			return abdO;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}
}
