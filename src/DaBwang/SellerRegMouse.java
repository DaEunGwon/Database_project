package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SellerRegMouse extends JPanel implements ActionListener {

	
	private JLabel manufacL;
	private JLabel sensingL;
	private JLabel connectionL;
	private JLabel dpiL;
	private JLabel accelL;
	private JLabel weightL;
	
	private JTextField manufacT;
	private JTextField sensingT;
	private JTextField connectionT;
	private JTextField dpiT;
	private JTextField accelT;
	private JTextField weightT;
	
	private JButton regB;
	
	public SellerRegMouse() {
		manufacL = new JLabel("Manufacturer");
		sensingL = new JLabel("Sensing");
		connectionL = new JLabel("Connection");
		dpiL = new JLabel("DPI");
		accelL = new JLabel("Acceleration");
		weightL = new JLabel("Weight");
		
		manufacL.setBounds(150,0,100,100);
		sensingL.setBounds(150,100,100,100);
		connectionL.setBounds(150,200,100,100);
		dpiL.setBounds(150,300,100,100);
		accelL.setBounds(150,400,100,100);
		weightL.setBounds(150,500,100,100);
		
		add(manufacL);
		add(sensingL);
		add(connectionL);
		add(dpiL);
		add(accelL);
		add(weightL);
		
		manufacT = new JTextField();
		sensingT = new JTextField();
		connectionT = new JTextField();
		dpiT = new JTextField();
		accelT = new JTextField();
		weightT = new JTextField();
		
		manufacT.setBounds(250,0,200,80);
		sensingT.setBounds(250,100,200,80);
		connectionT.setBounds(250,200,200,80);
		dpiT.setBounds(250,300,200,80);
		accelT.setBounds(250,400,200,80);
		weightT.setBounds(250,500,200,80);
		
		add(manufacT);
		add(sensingT);
		add(connectionT);
		add(dpiT);
		add(accelT);
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
