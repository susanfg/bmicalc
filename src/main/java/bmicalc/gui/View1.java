package bmicalc.gui;
import bmicalc.ObesityCategory;
import bmicalc.Gender;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.AbstractListModel;

public class View1 extends JFrame {

	private JPanel contentPane;
	private JTextField textWaistC;
	private JTextField textWeight;
	private JTextField textHeight;
	private JLabel lblRes;
	private JList<String> list;
	private JButton btnBMI;
	private JButton btnCategory;
	private JButton btnAbdO;
	private JButton btnClean;
	private final String font = "Menlo";
	private final String blight="Button.light";
	private final String errorM = "Please, enter a valid value.";
	/**
	 * Create the frame.
	 */
	public View1() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		lblRes = new JLabel(
				"Enter weight and height for BMI and Category. Waist circumference and gender for abdominal obesity.");
		lblRes.setForeground(UIManager.getColor("Button.select"));
		lblRes.setFont(new Font(font, Font.BOLD, 15));
		contentPane.add(lblRes, BorderLayout.SOUTH);

		JLabel lblTitle = new JLabel("Welcome to the Health Calculator. What do you want to compute?");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle, BorderLayout.NORTH);

		JPanel panelG = new JPanel();
		contentPane.add(panelG, BorderLayout.CENTER);
		panelG.setLayout(new GridLayout(1, 2, 10, 10));
		JPanel panelL = new JPanel();
		panelG.add(panelL);
		panelL.setLayout(new GridLayout(2, 1, 0, 40));

		JPanel panelLSup = new JPanel();
		panelL.add(panelLSup);
		panelLSup.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel3 = new JPanel();
		panelLSup.add(panel3);
		panel3.setLayout(new BorderLayout(0, 0));

		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(UIManager.getColor(blight));
		lblWeight.setFont(new Font(font, Font.PLAIN, 12));
		panel3.add(lblWeight, BorderLayout.NORTH);

		textWeight = new JTextField();
		textWeight.setFont(new Font(font, Font.PLAIN, 12));
		panel3.add(textWeight, BorderLayout.CENTER);
		textWeight.setColumns(10);

		JLabel lblKg = new JLabel(" Kg");
		lblKg.setFont(new Font(font, Font.PLAIN, 12));
		panel3.add(lblKg, BorderLayout.EAST);

		JPanel panel2 = new JPanel();
		panelLSup.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setForeground(UIManager.getColor(blight));
		lblHeight.setFont(new Font(font, Font.PLAIN, 12));
		panel2.add(lblHeight, BorderLayout.NORTH);

		JLabel lblMetre = new JLabel(" m");
		lblMetre.setFont(new Font(font, Font.PLAIN, 12));
		panel2.add(lblMetre, BorderLayout.EAST);

		textHeight = new JTextField();
		textHeight.setFont(new Font(font, Font.PLAIN, 12));
		panel2.add(textHeight, BorderLayout.CENTER);
		textHeight.setColumns(10);

		JPanel panelLInf = new JPanel();
		panelL.add(panelLInf);
		panelLInf.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panelAbdC = new JPanel();
		panelLInf.add(panelAbdC);
		panelAbdC.setLayout(new BorderLayout(0, 0));

		JLabel lblAbdC = new JLabel("Waist Circumference");
		lblAbdC.setForeground(UIManager.getColor(blight));
		lblAbdC.setFont(new Font(font, Font.PLAIN, 12));
		panelAbdC.add(lblAbdC, BorderLayout.NORTH);

		textWaistC = new JTextField();
		textWaistC.setFont(new Font(font, Font.PLAIN, 12));
		panelAbdC.add(textWaistC, BorderLayout.CENTER);
		textWaistC.setColumns(10);

		JLabel lblcm = new JLabel("cm");
		lblcm.setFont(new Font(font, Font.PLAIN, 12));
		panelAbdC.add(lblcm, BorderLayout.EAST);

		JPanel panelGender = new JPanel();
		panelLInf.add(panelGender);
		panelGender.setLayout(new BorderLayout(0, 0));

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(UIManager.getColor(blight));
		lblGender.setFont(new Font(font, Font.PLAIN, 12));
		panelGender.add(lblGender, BorderLayout.NORTH);

		 list = new JList<String>();
		list.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4376065402015850666L;
			String[] values = new String[] { "FEMALE", "MALE" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font(font, Font.PLAIN, 12));
		panelGender.add(list, BorderLayout.CENTER);
		JPanel panelR = new JPanel();
		panelG.add(panelR);
		panelR.setLayout(new GridLayout(2, 1, 0, 40));

		JPanel panelRSup = new JPanel();
		panelR.add(panelRSup);
		panelRSup.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panelRbmi = new JPanel();
		panelRSup.add(panelRbmi);
		panelRbmi.setLayout(new BorderLayout(0, 0));

		JPanel panel5 = new JPanel();
		panelRSup.add(panel5);
		panel5.setLayout(new BorderLayout(0, 0));

		btnBMI = new JButton("");
		btnBMI.setBounds(30, 90, 90, 60);
		btnBMI.setIcon(setIconT("/Images/bmi.jpeg", btnBMI));
		panel5.add(btnBMI, BorderLayout.WEST);

		JPanel panel6 = new JPanel();
		panelRSup.add(panel6);
		panel6.setLayout(new BorderLayout(0, 0));

		btnCategory = new JButton("");
		btnCategory.setBounds(30, 90, 90, 60);
		btnCategory.setIcon(setIconT("/Images/category.jpeg", btnCategory));
		panel6.add(btnCategory, BorderLayout.WEST);

		JPanel panelRCategory = new JPanel();
		panelRSup.add(panelRCategory);
		panelRCategory.setLayout(new BorderLayout(0, 0));

		JPanel panelRInf = new JPanel();
		panelR.add(panelRInf);
		panelRInf.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel = new JPanel();
		panelRInf.add(panel);

		JPanel panel1 = new JPanel();
		panelRInf.add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));

		btnAbdO = new JButton("");
		btnAbdO.setBounds(30, 90, 90, 60);
		btnAbdO.setIcon(setIconT("/Images/AbdO.jpeg", btnAbdO));
		panel1.add(btnAbdO, BorderLayout.WEST);
		
		btnClean = new JButton("Clean data");
		btnClean.setFont(new Font(font, Font.PLAIN, 12));
		panel1.add(btnClean, BorderLayout.EAST);

		JPanel panel4 = new JPanel();
		panelRInf.add(panel4);
		pack();
		setVisible(true);
	}

	// adjust image to a button
	public Icon setIconT(String path, JButton button) {
		ImageIcon icon = new ImageIcon(getClass().getResource(path));
		int width = button.getWidth();
		int height = button.getHeight();
		return new ImageIcon(icon.getImage().getScaledInstance(width, height, height));
	}

	public double getWeight() {
		try {
			return Double.parseDouble(textWeight.getText().replace(',','.'));
		} catch (NumberFormatException e) {

			lblRes.setText(errorM);
			return -1;
		}
	}

	public double getHeightU() {
		try {
			return Double.parseDouble(textHeight.getText().replace(',','.'));
		} catch (NumberFormatException e) {
			lblRes.setText(errorM);
			return -1;
		}
	}

	public double getWaistC() {
		try {
			return Double.parseDouble(textWaistC.getText().replace(',','.'));
		} catch (NumberFormatException e) {
			lblRes.setText(errorM);
			return -1;
		}
		
	}
	public Gender getGender() {
		try {
			return Gender.valueOf(list.getSelectedValue().toString());
		}catch(NullPointerException e){
			return null;
		}
	}
	public void setResBMI(double res) {
		if(res == 0) {
			lblRes.setText(errorM);
		}else {
			lblRes.setText("Your BMI is " + res);

		}
	}
	public void setResCategory(ObesityCategory result) {
		if(result == null) {
			lblRes.setText(errorM);
		}else {
			lblRes.setText("You are in " + result + " category");

		}
	}
	public void setResAbdO(String bool) {
		if(bool.equals("error")) {
			lblRes.setText(errorM);

		}else {
			boolean b = Boolean.parseBoolean(bool);

			if(b) {
				lblRes.setText("You have abdominal obesity");
			}else {
				lblRes.setText("You do not have abdominal obesity");
			}
		}

	}
	public void registerController(ActionListener ctrl) {
		btnBMI.addActionListener(ctrl);
		btnBMI.setActionCommand("ComputeBMI");
		btnCategory.addActionListener(ctrl);
		btnCategory.setActionCommand("DetermineCategory");
		btnAbdO.addActionListener(ctrl);
		btnAbdO.setActionCommand("DetermineAbdO");
		btnClean.addActionListener(ctrl);
		btnClean.setActionCommand("Clean");
	}
	public void setInit() {
		textWeight.setText("");
		textHeight.setText("");
		textWaistC.setText("");
		list.clearSelection();;
		lblRes.setText("Enter weight and height for BMI and Category. Waist circumference and gender for abdominal obesity.");
	}

}
