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

public class SellerModifi extends JPanel implements ActionListener{
	
	private int W = 600;
	private int H = 600;
	
	private JLabel seller;
	
	private JButton register;
	private JButton id_check;
	
	private JTextField id;
	private JTextField pw;
	private JTextField name;
	private JTextField company;
	private JTextField phone_Num;
	private JTextField address;
	private JTextField corporate_regNum;
	
	private JLabel idL;
	private JLabel pwL;
	private JLabel nameL;
	private JLabel companyL;
	private JLabel phone_NumL;
	private JLabel addressL;
	private JLabel corporate_regNumL;
	
	ResultSet rs = null;
    Statement s = null;
	
	
	public SellerModifi() throws SQLException {
		
		s = MainApp.con.createStatement();
		
		id = new JTextField();
		pw = new JTextField();
		name = new JTextField();
		company = new JTextField();
		phone_Num = new JTextField();
		address = new JTextField();
		corporate_regNum = new JTextField();
		
		id.setBounds(250,200,100,40);
		pw.setBounds(250,250,100,40);
		name.setBounds(250,300,100,40);
		company.setBounds(250,350,100,40);
		phone_Num.setBounds(250,400,100,40);
		address.setBounds(250,450,100,40);
		corporate_regNum.setBounds(250,500,100,40);
		
		add(id);
		add(pw);
		add(name);
		add(company);
		add(phone_Num);
		add(address);
		add(corporate_regNum);
		
		idL = new JLabel("ID");
		pwL = new JLabel("PW");
		nameL = new JLabel("Name");
		companyL = new JLabel("Company");
		phone_NumL = new JLabel("Phone Num");
		addressL = new JLabel("Address");
		corporate_regNumL = new JLabel("Regist.Num");
		
		idL.setBounds(200,200,100,40);
		pwL.setBounds(200,250,100,40);
		nameL.setBounds(180,300,100,40);
		companyL.setBounds(170,350,100,40);
		phone_NumL.setBounds(170,400,100,40);
		addressL.setBounds(180,450,100,40);
		corporate_regNumL.setBounds(170,500,100,40);
		
		add(idL);
		add(pwL);
		add(nameL);
		add(companyL);
		add(phone_NumL);
		add(addressL);
		add(corporate_regNumL);
		
		seller = new JLabel("Seller");
		seller.setBounds(250,0,100,100);
		add(seller);
		
		register = new JButton("Registration");
		id_check = new JButton("ID Check");
		register.addActionListener(this);
		id_check.addActionListener(this);
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
		MainFrame f;
		try {
			f = new MainFrame();
			if(e.getActionCommand() == "Modification")
				f.changePanel("comlete_reg");
			else if(e.getSource() == id_check)
				System.out.println("누름 ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
