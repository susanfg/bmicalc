package bmicalc;
import java.util.HashMap;
import java.util.Map;

public class BMICalcAdapter implements IMCHospital {
	private BMICalcImpl c;
	public BMICalcAdapter() {
		this.c = BMICalcImpl.getInstance();
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		double bmi = c.bmi(peso, altura);
		String cat = c.category(bmi);
		Map<Double, String> res = new HashMap<>();
		res.put(bmi, cat);
		return res;
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		boolean abdOb = c.abdominalObesity(circunferencia, genero);
		return abdOb;
	}

}
