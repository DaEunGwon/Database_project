package DaBwang;
import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyInfo extends JPanel implements ActionListener{
	
	private int W = 600;
	private int H = 600;
	
	private JLabel modifiInfo;
	
	private JButton modification;
	private JButton id_check;
	
	private JTextField id;
	private JTextField pw;
	private JTextField name;
	private JTextField phone_Num;
	private JTextField address;
	private JTextField email;
	
	private JLabel idL;
	private JLabel pwL;
	private JLabel nameL;
	private JLabel phone_NumL;
	private JLabel addressL;
	private JLabel emailL;
	
//	Connection con = null;
    Statement s;
    ResultSet rs;
	
	public ModifyInfo() throws SQLException {
		
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
		
		modifiInfo = new JLabel("Modification");
		modifiInfo.setBounds(250,0,100,100);
		add(modifiInfo);
		
		modification = new JButton("Modification");
		id_check = new JButton("ID Check");
		modification.setBounds(450,500,100,60);
		id_check.setBounds(350,200,100,40);
		
		modification.addActionListener(this);
		id_check.addActionListener(this);
		
		add(modification);
		add(id_check);
		
		setSize(W,H);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			MainFrame f = new MainFrame();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if(e.getActionCommand() == "Modification") {
						try {
				System.out.println("µî·Ï");
				s.executeUpdate("UPDATE Consumer SET consumer_id = '"+id.getText()+"' WHERE consumer_id = '"+LoginPanel.id.getText()+"'" );
				s.executeUpdate("UPDATE Consumer SET consumer_name = '"+name.getText()+"' WHERE consumer_name == BuyerRegisterPanel.name.getText()" );
				s.executeUpdate("UPDATE Consumer SET consumer_password = 'pw.getText()' WHERE consumer_password == 'BuyerRegisterPanel.pw.getText()");
				s.executeUpdate("UPDATE Consumer SET consumer_address = 'address.getText()' WHERE consumer_address == 'BuyerRegisterPanel.address.getText()");
				s.executeUpdate("UPDATE Consumer SET consumer_password = 'phone_Num.getText()' WHERE consumer_address == 'BuyerRegisterPanel.address.getText()");
				s.executeUpdate("UPDATE Consumer SET consumer_email = 'email.getText()' WHERE consumer_password == 'BuyerRegisterPanel.email.getText()");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				s.close();
			//	con2.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}

}
