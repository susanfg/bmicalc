package bmicalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bmicalc.BMICalcImpl;

public class Controller implements ActionListener {
	private BMICalcImpl model;
	private View1 view;

	public Controller(BMICalcImpl model, View1 view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("ComputeBMI")) {
			double weight = view.getWeight();
			double height = view.getHeightU();
			double result = 0;
			try {
				result = model.calculateBodyMassIndex(weight, height);

			} catch (RuntimeException error) {
			}
			view.setResBMI(result);

		} else if (command.equals("DetermineCategory")) {
			double weight = view.getWeight();
			double height = view.getHeightU();
			String result = "";
			try {
				result = model.getObesityCategory(model.calculateBodyMassIndex(weight, height));

			} catch (RuntimeException error) {
			}
			view.setResCategory(result);
		} else if (command.equals("DetermineAbdO")) {
			double waistC = view.getWaistC();
			char gender = view.getGender();
			boolean result;
			try {
				result = model.abdominalObesity(waistC, gender);
				String resTwo = String.valueOf(result);
				view.setResAbdO(resTwo);
			} catch (RuntimeException error) {
				view.setResAbdO("error");
			}

		}else if(command.equals("Clean")) {
			view.setInit();
		}

	}

}
