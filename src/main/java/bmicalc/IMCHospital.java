package bmicalc;

import java.util.Map;

public interface IMCHospital {
	public Map<Double, String> imc(double altura, double peso);
	boolean tieneObesidadAbdominal(char genero, double circunferencia);
}
