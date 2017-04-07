package ro.itschool;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MainFunction {

	private static final String FILENAME = "/home/cristian/text.txt";
	public static HashMap map = new HashMap();
	public static ArrayList al = new ArrayList();
	public static ArrayList al2 = new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFunction win = new MainFunction();

		BufferedReader br = null;
		FileReader fr = null;

		al2.add("Euro-to-USD");
		al2.add("Euro-to-JPY");
		al2.add("Euro-to-GBP");
		al2.add("Euro-to-RON");
		al2.add("USD-to-EURO");
		al2.add("USD-to-JPY");
		al2.add("USD-to-GBP");
		al2.add("USD-to-RON");
		al2.add("JPY-to-USD");
		al2.add("JPY-to-EURO");
		al2.add("JPY-to-GBP");
		al2.add("JPY-to-RON");
		al2.add("GBP-to-USD");
		al2.add("GBP-to-EURO");
		al2.add("GBP-to-JPY");
		al2.add("GBP-to-RON");
		al2.add("RON-to-USD");
		al2.add("RON-to-EURO");
		al2.add("RON-to-JPY");
		al2.add("RON-to-GBP");
		al2.add("");

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				al.add(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				win.createGUI();
			}
		});
	}

	protected void createGUI() {
		JFrame frame = new JFrame("Convertor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));

		GridLayout mygrid = new GridLayout(1, 2);
		panel1.setLayout(mygrid);

		GridLayout myfinalgrid = new GridLayout(4, 1);
		panel3.setLayout(myfinalgrid);

		JTextField textfield = new JTextField(20);

		textfield.setText("0");
		panel1.add(textfield);

		JButton btn = new JButton("CONVERT");

		panel1.add(btn);

		String[] messageString1 = { "United State dollar (USD)", "Euro (EU)", "Japanese yen (JPY)",
				"Pound sterling (GBP)", "Romanian lei (RON)" };
		JComboBox cmbMessageList1 = new JComboBox(messageString1);

		String[] messageString2 = { "United State dollar (USD)", "Euro (EU)", "Japanese yen (JPY)",
				"Pound sterling (GBP)", "Romanian lei (RON)" };
		JComboBox cmbMessageList2 = new JComboBox(messageString2);

		panel2.add(cmbMessageList1);
		panel2.add(cmbMessageList2);

		JLabel label = new JLabel();

		panel3.add(panel1);
		panel3.add(panel2);
		panel3.add(label);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object obi = cmbMessageList1.getSelectedItem();
				Object obj = cmbMessageList2.getSelectedItem();
				System.out.println("Contents of al: " + al);
				System.out.println("Contents of al: " + al2);
				for (int i = 0; i <= al.size() - 1; i++) {
					map.put(al2.get(i), al.get(i));

				}
				System.out.println(map);

				Float sum = Float.parseFloat(textfield.getText());
				if (sum != 0.0) {
					if (obi.toString() == "Euro (EU)" && obj.toString() == "United State dollar (USD)") {
						String value = (String) map.get("Euro-to-USD");
						Float result = Float.parseFloat(value);

						Float c = sum * result;

						System.out.println(c);
						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Euro (EU)" && obj.toString() == "Japanese yen (JPY)") {
						String value = (String) map.get("Euro-to-JPY");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Euro (EU)" && obj.toString() == "Pound sterling (GBP)") {
						String value = (String) map.get("Euro-to-GBP");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Euro (EU)" && obj.toString() == "Romanian lei (RON)") {
						String value = (String) map.get("Euro-to-RON");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "United State dollar (USD)" && obj.toString() == "Euro (EU)") {
						String value = (String) map.get("USD-to-EURO");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "United State dollar (USD)"
							&& obj.toString() == "Japanese yen (JPY)") {
						String value = (String) map.get("USD-to-JPY");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "United State dollar (USD)"
							&& obj.toString() == "Pound sterling (GBP)") {
						String value = (String) map.get("USD-to-GBP");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "United State dollar (USD)"
							&& obj.toString() == "Pound sterling (GBP)") {
						String value = (String) map.get("USD-to-GBP");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "United State dollar (USD)"
							&& obj.toString() == "Romanian lei (RON)") {
						String value = (String) map.get("USD-to-RON");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Japanese yen (JPY)"
							&& obj.toString() == "United State dollar (USD)") {
						String value = (String) map.get("JPY-to-USD");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Japanese yen (JPY)" && obj.toString() == "Euro (EU)") {
						String value = (String) map.get("JPY-to-EURO");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Japanese yen (JPY)" && obj.toString() == "Pound sterling (GBP)") {
						String value = (String) map.get("JPY-to-GBP");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Japanese yen (JPY)" && obj.toString() == "Romanian lei (RON)") {
						String value = (String) map.get("JPY-to-RON");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Pound sterling (GBP)"
							&& obj.toString() == "United State dollar (USD)") {
						String value = (String) map.get("GBP-to-USD");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Pound sterling (GBP)" && obj.toString() == "Euro (EU)") {
						String value = (String) map.get("GBP-to-EURO");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Pound sterling (GBP)" && obj.toString() == "Japanese yen (JPY)") {
						String value = (String) map.get("GBP-to-JPY");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Pound sterling (GBP)" && obj.toString() == "Romanian lei (RON)") {
						String value = (String) map.get("GBP-to-RON");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Romanian lei (RON)"
							&& obj.toString() == "United State dollar (USD)") {
						String value = (String) map.get("RON-to-USD");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Romanian lei (RON)" && obj.toString() == "Euro (EU)") {
						String value = (String) map.get("RON-to-EURO");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Romanian lei (RON)" && obj.toString() == "Japanese yen (JPY)") {
						String value = (String) map.get("RON-to-JPY");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else if (obi.toString() == "Romanian lei (RON)" && obj.toString() == "Japanese yen (JPY)") {
						String value = (String) map.get("RON-to-GBP");
						Float result = Float.parseFloat(value);

						Float c = sum * result;
						System.out.println(c);

						String mytext = c.toString();
						label.setForeground(Color.BLACK);
						label.setText(mytext);
					} else {
						System.out.println("Something went wrong! Please try again");
						label.setForeground(Color.RED);
						label.setText("Something went wrong! Please try again");
					}
				} else {
					label.setForeground(Color.RED);
					label.setText("Add a number in the text field!");
				}
			}
		});

		frame.setContentPane(panel3);
		frame.pack();
		frame.setVisible(true);

	}

}
