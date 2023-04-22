package bmicalc;

import java.util.Map;

public class BMICalcProxy implements IMCStats, IMCHospital {
	private BMICalcAdapter c;
	private static double cntAltura;
	private static double cntPeso;
	private static double cntIMC;
	private static int cntPacientes;

	public BMICalcProxy() {
		this.c = new BMICalcAdapter();
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		try {
			Map<Double, String> imc = c.imc(altura, peso);
			cntAltura += altura;
			cntPeso += peso;
			cntPacientes += 1;
			return imc;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		try {
			boolean abd = c.tieneObesidadAbdominal(genero, circunferencia);
			return abd;

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		return false; // default boolean value for an exception
	}

	@Override
	public double alturaMedia() {

		return cntAltura / cntPacientes;
	}

	@Override
	public double pesoMedio() {
		return cntPeso / cntPacientes;
	}

	@Override
	public double imcMedio() {
		return cntIMC / cntPacientes;
	}

	@Override
	public int numPacientes() {
		return cntPacientes;
	}

}
