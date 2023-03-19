package bmicalc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.AbstractListModel;

public class View1 extends JFrame {

	private JPanel contentPane;
	private JTextField textWaistC;
	private JTextField textWeight;
	private JTextField textHeight;
	private JLabel lblRes;
	private JList list;
	private JButton btnBMI;
	private JButton btnCategory;
	private JButton btnAbdO;
	private JButton btnClean;

	/**
	 * Create the frame.
	 */
	public View1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		lblRes = new JLabel(
				"Enter weight and height for BMI and Category. Waist circumference and gender for abdominal obesity.");
		lblRes.setForeground(UIManager.getColor("Button.select"));
		lblRes.setFont(new Font("Menlo", Font.BOLD, 15));
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

		JPanel panel_3 = new JPanel();
		panelLSup.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(UIManager.getColor("Button.light"));
		lblWeight.setFont(new Font("Menlo", Font.PLAIN, 12));
		panel_3.add(lblWeight, BorderLayout.NORTH);

		textWeight = new JTextField();
		textWeight.setFont(new Font("Menlo", Font.PLAIN, 12));
		panel_3.add(textWeight, BorderLayout.CENTER);
		textWeight.setColumns(10);

		JLabel lblKg = new JLabel(" Kg");
		lblKg.setFont(new Font("Menlo", Font.PLAIN, 12));
		panel_3.add(lblKg, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		panelLSup.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setForeground(UIManager.getColor("Button.light"));
		lblHeight.setFont(new Font("Menlo", Font.PLAIN, 12));
		panel_2.add(lblHeight, BorderLayout.NORTH);

		JLabel lblMetre = new JLabel(" m");
		lblMetre.setFont(new Font("Menlo", Font.PLAIN, 12));
		panel_2.add(lblMetre, BorderLayout.EAST);

		textHeight = new JTextField();
		textHeight.setFont(new Font("Menlo", Font.PLAIN, 12));
		panel_2.add(textHeight, BorderLayout.CENTER);
		textHeight.setColumns(10);

		JPanel panelLInf = new JPanel();
		panelL.add(panelLInf);
		panelLInf.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panelAbdC = new JPanel();
		panelLInf.add(panelAbdC);
		panelAbdC.setLayout(new BorderLayout(0, 0));

		JLabel lblAbdC = new JLabel("Waist Circumference");
		lblAbdC.setForeground(UIManager.getColor("Button.light"));
		lblAbdC.setFont(new Font("Menlo", Font.PLAIN, 12));
		panelAbdC.add(lblAbdC, BorderLayout.NORTH);

		textWaistC = new JTextField();
		textWaistC.setFont(new Font("Menlo", Font.PLAIN, 12));
		panelAbdC.add(textWaistC, BorderLayout.CENTER);
		textWaistC.setColumns(10);

		JLabel lblcm = new JLabel("cm");
		lblcm.setFont(new Font("Menlo", Font.PLAIN, 12));
		panelAbdC.add(lblcm, BorderLayout.EAST);

		JPanel panelGender = new JPanel();
		panelLInf.add(panelGender);
		panelGender.setLayout(new BorderLayout(0, 0));

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(UIManager.getColor("Button.light"));
		lblGender.setFont(new Font("Menlo", Font.PLAIN, 12));
		panelGender.add(lblGender, BorderLayout.NORTH);

		 list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Female", "Male" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Menlo", Font.PLAIN, 12));
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

		JPanel panel_5 = new JPanel();
		panelRSup.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		btnBMI = new JButton("");
		btnBMI.setBounds(30, 90, 90, 60);
		btnBMI.setIcon(setIconT("/Images/bmi.jpeg", btnBMI));
		panel_5.add(btnBMI, BorderLayout.WEST);

		JPanel panel_6 = new JPanel();
		panelRSup.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		btnCategory = new JButton("");
		btnCategory.setBounds(30, 90, 90, 60);
		btnCategory.setIcon(setIconT("/Images/category.jpeg", btnCategory));
		panel_6.add(btnCategory, BorderLayout.WEST);

		JPanel panelRCategory = new JPanel();
		panelRSup.add(panelRCategory);
		panelRCategory.setLayout(new BorderLayout(0, 0));

		JPanel panelRInf = new JPanel();
		panelR.add(panelRInf);
		panelRInf.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel = new JPanel();
		panelRInf.add(panel);

		JPanel panel_1 = new JPanel();
		panelRInf.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		btnAbdO = new JButton("");
		btnAbdO.setBounds(30, 90, 90, 60);
		btnAbdO.setIcon(setIconT("/Images/AbdO.jpeg", btnAbdO));
		panel_1.add(btnAbdO, BorderLayout.WEST);
		
		btnClean = new JButton("Clean data");
		btnClean.setFont(new Font("Menlo", Font.PLAIN, 12));
		panel_1.add(btnClean, BorderLayout.EAST);

		JPanel panel_4 = new JPanel();
		panelRInf.add(panel_4);
		pack();
		setVisible(true);
	}

	// adjust image to a button
	public Icon setIconT(String path, JButton button) {
		ImageIcon icon = new ImageIcon(getClass().getResource(path));
		int width = button.getWidth();
		int height = button.getHeight();
		ImageIcon iconT = new ImageIcon(icon.getImage().getScaledInstance(width, height, height));
		return iconT;
	}

	public double getWeight() {
		try {
			return Double.parseDouble(textWeight.getText());
		} catch (NumberFormatException e) {

			lblRes.setText("Please, enter a valid value");
			return -1;
		}
	}

	public double getHeightU() {
		try {
			return Double.parseDouble(textHeight.getText());
		} catch (NumberFormatException e) {
			lblRes.setText("Please, enter a valid value");
			return -1;
		}
	}

	public double getWaistC() {
		try {
			return Double.parseDouble(textWaistC.getText());
		} catch (NumberFormatException e) {
			lblRes.setText("Please, enter a valid value");
			return -1;
		}
		
	}
	public char getGender() {
		try {
			return (list.getSelectedValue().toString()).charAt(0);
		}catch(NullPointerException e){
			return 'e';
		}
	}
	public void setResBMI(double res) {
		if(res == 0) {
			lblRes.setText("Please, enter a valid value");
		}else {
			lblRes.setText("Your BMI is " + res);

		}
	}
	public void setResCategory(String res) {
		if(res.equals("")) {
			lblRes.setText("Please, enter a valid value");
		}else {
			lblRes.setText("You are in " + res + " category");

		}
	}
	public void setResAbdO(String bool) {
		if(bool.equals("error")) {
			lblRes.setText("Please, enter a valid value");

		}else {
			boolean b = Boolean.valueOf(bool);
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
