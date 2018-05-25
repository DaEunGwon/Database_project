package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SellerRegKeyboard extends JPanel implements ActionListener {

	
	private JLabel manufacL;
	private JLabel connectionL;
	private JLabel typeL;
	private JLabel batteryL;
	private JLabel weightL;
	
	private JTextField manufacT;
	private JTextField connectionT;
	private JTextField typeT;
	private JTextField batteryT;
	private JTextField weightT;
	
	private JButton regB;
	
	public SellerRegKeyboard() {
		manufacL = new JLabel("Manufacturer");
		connectionL = new JLabel("Connection");
		typeL = new JLabel("Type");
		batteryL = new JLabel("Battery");
		weightL = new JLabel("Weight");
		
		manufacL.setBounds(150,100,100,100);
		connectionL.setBounds(150,200,100,100);
		typeL.setBounds(150,300,100,100);
		batteryL.setBounds(150,400,100,100);
		weightL.setBounds(150,500,100,100);
		
		add(manufacL);
		add(connectionL);
		add(typeL);
		add(batteryL);
		add(weightL);
		
		manufacT = new JTextField();
		connectionT = new JTextField();
		typeT = new JTextField();
		batteryT = new JTextField();
		weightT = new JTextField();
		
		manufacT.setBounds(250,100,200,80);
		connectionT.setBounds(250,200,200,80);
		typeT.setBounds(250,300,200,80);
		batteryT.setBounds(250,400,200,80);
		weightT.setBounds(250,500,200,80);
		
		add(manufacT);
		add(connectionT);
		add(typeT);
		add(batteryT);
		add(weightT);
		
		regB = new JButton("Registration");
		regB.setBounds(450,500,100,50);
		add(regB);
		
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			MainFrame f = new MainFrame();
			
			//if(e.getActionCommand() == "Registration")//DB랑 연동시켜서 처리하
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}
