package bmicalc.gui;

import java.awt.EventQueue;

import bmicalc.BMICalcImpl;



public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalcImpl model = new BMICalcImpl();
					View1 view = new View1();
					Controller controller = new Controller	(model	, view);
					view.registerController	(controller);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
