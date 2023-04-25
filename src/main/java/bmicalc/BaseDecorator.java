package bmicalc;

import java.util.Map;

public class BaseDecorator implements IMCHospital {
	protected IMCHospital c;
	
	public BaseDecorator(IMCHospital c) {
		this.c = c;
	}
	@Override
	public Map<Double, String> imc(double altura, double peso) {
		// TODO Auto-generated method stub
		return c.imc(altura, peso);
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		// TODO Auto-generated method stub
		return c.tieneObesidadAbdominal(genero, circunferencia);
	}

}
