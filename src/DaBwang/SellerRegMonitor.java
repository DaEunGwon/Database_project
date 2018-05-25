package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SellerRegMonitor extends JPanel implements ActionListener {

	
	private JLabel manufacL;
	private JLabel sizeL;
	private JLabel resolutionL;
	private JLabel panelL;
	private JLabel terminalL;
	private JLabel rateL;
	
	private JTextField manufacT;
	private JTextField sizeT;
	private JTextField resolutionT;
	private JTextField panelT;
	private JTextField terminalT;
	private JTextField rateT;
	
	private JButton regB;
	
	public SellerRegMonitor() {
		manufacL = new JLabel("Manufacturer");
		sizeL = new JLabel("Size");
		resolutionL = new JLabel("Resolution");
		panelL = new JLabel("Panel");
		terminalL = new JLabel("Terminal");
		rateL = new JLabel("Rate");
		
		manufacL.setBounds(150,0,100,100);
		sizeL.setBounds(150,100,100,100);
		resolutionL.setBounds(150,200,100,100);
		panelL.setBounds(150,300,100,100);
		terminalL.setBounds(150,400,100,100);
		rateL.setBounds(150,500,100,100);
		
		add(manufacL);
		add(sizeL);
		add(resolutionL);
		add(panelL);
		add(terminalL);
		add(rateL);
		
		manufacT = new JTextField();
		sizeT = new JTextField();
		resolutionT = new JTextField();
		panelT = new JTextField();
		terminalT = new JTextField();
		rateT = new JTextField();
		
		manufacT.setBounds(250,0,200,80);
		sizeT.setBounds(250,100,200,80);
		resolutionT.setBounds(250,200,200,80);
		panelT.setBounds(250,300,200,80);
		terminalT.setBounds(250,400,200,80);
		rateT.setBounds(250,500,200,80);
		
		add(manufacT);
		add(sizeT);
		add(resolutionT);
		add(panelT);
		add(terminalT);
		add(rateT);
		
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
