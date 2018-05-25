package DaBwang;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BuyerRegisterPanel extends JPanel implements ActionListener{
	
	private int W = 600;
	private int H = 600;
	
	private JLabel buyer;
	
	private JButton register;
	private JButton id_check;
	
	public static JTextField id;
	public static JTextField pw;
	public static JTextField name;
	public static JTextField phone_Num;
	public static JTextField address;
	public static JTextField email;
	
	private JLabel idL;
	private JLabel pwL;
	private JLabel nameL;
	private JLabel phone_NumL;
	private JLabel addressL;
	private JLabel emailL;
	
 	ResultSet rs = null;
    Statement s = null;
	
	public BuyerRegisterPanel() throws SQLException {
		
		s = MainApp.con.createStatement();
		
		id = new JTextField();
		pw = new JTextField();
		name = new JTextField();
		phone_Num = new JTextField();
		address = new JTextField();
		email = new JTextField();
		
		id.setBounds(250,200,100,40);
		pw.setBounds(250,250,100,40);
		name.setBounds(250,300,100,40);
		phone_Num.setBounds(250,350,100,40);
		address.setBounds(250,400,100,40);
		email.setBounds(250,450,200,40);
		
		add(id);
		add(pw);
		add(name);
		add(phone_Num);
		add(address);
		add(email);
		
		idL = new JLabel("ID");
		pwL = new JLabel("PW");
		nameL = new JLabel("Name");
		phone_NumL = new JLabel("Phone Num");
		addressL = new JLabel("Address");
		emailL = new JLabel("E-Mail");
		
		idL.setBounds(200,200,100,40);
		pwL.setBounds(200,250,100,40);
		nameL.setBounds(180,300,100,40);
		phone_NumL.setBounds(170,350,100,40);
		addressL.setBounds(180,400,100,40);
		emailL.setBounds(170,450,100,40);
		
		add(idL);
		add(pwL);
		add(nameL);
		add(phone_NumL);
		add(addressL);
		add(emailL);
		
		buyer = new JLabel("Buyer");
		buyer.setBounds(250,0,100,100);
		add(buyer);
		
		register = new JButton("Registration");
		id_check = new JButton("ID Check");
		register.setBounds(450,500,100,60);
		id_check.setBounds(350,200,100,40);
		
		add(register);
		add(id_check);
		
		setSize(W,H);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
