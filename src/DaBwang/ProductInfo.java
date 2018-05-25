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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProductInfo extends JPanel implements ActionListener{

	
	private JTextField productName;
	private JTextField seller;
	private JTextField numOfsales;
	
	private JLabel nameL;
	private JLabel sellerL;
	private JLabel numL;
	

	private JScrollPane review;
	private JScrollPane info;
	
	private JTextArea commentText;
	private JTextArea reviewText;
	private JTextArea infoText;
	private JButton buy;
	private JButton reviewB;
	private JButton commentB;
	
	ResultSet rs = null;
    Statement s = null;
	
	
	public ProductInfo() throws SQLException {
		
		s = MainApp.con.createStatement();
		
		reviewB = new JButton("Review");
		commentB = new JButton("Comment");
		
		reviewB.setBounds(100,350,150,150);
		commentB.setBounds(300,350,150,150);
		
		reviewB.addActionListener(this);
		commentB.addActionListener(this);
		
		add(reviewB);
		add(commentB);
	
		
		infoText = new JTextArea();
		info = new JScrollPane(infoText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		info.setBounds(350,30,200,250);
		add(info);
		
		productName = new JTextField();
		seller = new JTextField();
		numOfsales = new JTextField();
		
		productName.setBounds(150,20,150,50);
		seller.setBounds(150,100,100,50);
		numOfsales.setBounds(150,180,100,50);
		
		productName.setEditable(false);
		seller.setEditable(false);
		numOfsales.setEditable(false);
		
		add(productName);
		add(seller);
		add(numOfsales);
		
		nameL = new JLabel("Product Name");
		sellerL = new JLabel("Seller");
		numL = new JLabel("Number of Sales");
		
		nameL.setBounds(20,20,150,50);
		sellerL.setBounds(70,100,150,50);
		numL.setBounds(20,180,150,50);
		
		add(nameL);
		add(sellerL);
		add(numL);
		
		buy = new JButton("BUY");
		buy.setBounds(100,250,70,40);
		buy.addActionListener(this);
		add(buy);
	
		setBackground(Color.WHITE);
		setLayout(null);
	   	setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame f;
		try {
			f = new MainFrame();
			if(e.getActionCommand() == "BUY")
				f.changePanel("buy");
			else if(e.getActionCommand() == "Comment")
				f.changePanel("BuyerComment");
			else if(e.getActionCommand() == "Review")
				f.changePanel("BuyerReview");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

}
