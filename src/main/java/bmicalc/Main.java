package bmicalc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BMICalcAdapter c = new BMICalcAdapter();
		if (c.tieneObesidadAbdominal('f', 90) == true) {
			System.out.println("The patient has abdominal obesity");
		}else {
			System.out.println("The patient does not have abdominal obesity");

		}
		
		System.out.println(c.imc(1.7, 90));
	}

}
