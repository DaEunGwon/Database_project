package DaBwang;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener {
	
	
	private int W = 600;
	private int H = 900;

	public static JTextField id = new JTextField(10);
	public static JTextField pw = new JTextField(10);
	
	private JLabel idL = new JLabel("ID");
	private JLabel pwL = new JLabel("PW");
	
	private JButton login = new JButton("Login");
	private JButton register = new JButton("Register");
	private JButton seller = new JButton("SellerMyPage");
	ResultSet rs = null;
    Statement s = null;
	
	
	public LoginPanel() throws SQLException {
		
		s = MainApp.con.createStatement();
		
		id.setBounds(250,240,100,40);
		pw.setBounds(250,300,100,40);
		
		
		
		idL.setBounds(220,250,20,20);
		pwL.setBounds(220,310,20,20);
		
		login.setBounds(350, 240, 100, 100);
		login.addActionListener(this);
		register.setBounds(270, 360, 65, 40);
		register.addActionListener(this);
		
		
		seller.setBounds(400,500,200,50);
		seller.addActionListener(this);
		add(seller);
		
		add(id);
		add(pw);
		add(idL);
		add(pwL);
		add(login);
		add(register);
		
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
			if(e.getActionCommand() == "Register")
				f.changePanel("Register");
			else if(e.getActionCommand() == "Login")
				f.changePanel("Login");
			else if(e.getActionCommand() == "SellerMyPage")
				f.changePanel("Temp");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
