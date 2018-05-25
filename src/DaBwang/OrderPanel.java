package DaBwang;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderPanel extends JPanel implements ActionListener{

	private JLabel buyer;
	private JLabel address;
	private JLabel receiver;
	
	private JTextField buyerF;
	private JTextField addressF;
	private JTextField receiverF;
	
	private JButton complete;
	
	ResultSet rs = null;
    Statement s = null;
	
	
	public OrderPanel() throws SQLException {
		
		s = MainApp.con.createStatement();
		
		buyer = new JLabel("Buyer");
		address = new JLabel("Address");
		receiver = new JLabel("Receiver");
		
		buyer.setBounds(150,50,100,50);
		address.setBounds(150,200,100,50);
		receiver.setBounds(140,350,100,50);
		
		add(buyer);
		add(address);
		add(receiver);
		
		buyerF = new JTextField();
		addressF = new JTextField();
		receiverF = new JTextField();
		
		buyerF.setBounds(200,50,150,50);
		addressF.setBounds(200,200,150,50);
		receiverF.setBounds(200,350,150,50);
		
		add(buyerF);
		add(addressF);
		add(receiverF);
		
		complete = new JButton("Complete");
		complete.setBounds(250,450,100,100);
		complete.addActionListener(this);
		
		add(complete);
		
		setBackground(Color.WHITE);
		setLayout(null);
	   	setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainFrame f;
		try {
			f = new MainFrame();
			if(e.getActionCommand() == "Complete") {
				f.changePanel("MyPage");
				//dialog 작성
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
	}
}
