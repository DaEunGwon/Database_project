package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SellerRegLaptop extends JPanel implements ActionListener {

	
	private JLabel manufacL;
	private JLabel ramL;
	private JLabel storageL;
	private JLabel colorL;
	private JLabel weightL;
	
	private JTextField manufacT;
	private JTextField ramT;
	private JTextField storageT;
	private JTextField colorT;
	private JTextField weightT;
	
	private JButton regB;
	
	public SellerRegLaptop() {
		manufacL = new JLabel("Manufacturer");
		ramL = new JLabel("RAM");
		storageL = new JLabel("Storage");
		colorL = new JLabel("Color");
		weightL = new JLabel("Weight");
		
		manufacL.setBounds(150,100,100,100);
		ramL.setBounds(150,200,100,100);
		storageL.setBounds(150,300,100,100);
		colorL.setBounds(150,400,100,100);
		weightL.setBounds(150,500,100,100);
		
		add(manufacL);
		add(ramL);
		add(storageL);
		add(colorL);
		add(weightL);
		
		manufacT = new JTextField();
		ramT = new JTextField();
		storageT = new JTextField();
		colorT = new JTextField();
		weightT = new JTextField();
		
		manufacT.setBounds(250,100,200,80);
		ramT.setBounds(250,200,200,80);
		storageT.setBounds(250,300,200,80);
		colorT.setBounds(250,400,200,80);
		weightT.setBounds(250,500,200,80);
		
		add(manufacT);
		add(ramT);
		add(storageT);
		add(colorT);
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
