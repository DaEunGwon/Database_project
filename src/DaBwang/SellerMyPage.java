package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SellerMyPage extends JPanel implements ActionListener {
	
	private JButton modifi;
	private JButton productReg;
	private JButton productStop;
	private JButton productList;
	
	
	public SellerMyPage() {
		
		modifi = new JButton("Modification");
		productReg = new JButton("Product Registration");
		productStop = new JButton("My Product");
	//	productList = new JButton("Product List");
		
		modifi.setBounds(250,50,150,100);
		productReg.setBounds(250,150,150,100);
		productStop.setBounds(250,250,150,100);
//		productList.setBounds(250,350,150,100);
		
		add(modifi);
		add(productReg);
		add(productStop);
	//	add(productList);
		
		modifi.addActionListener(this);
		productReg.addActionListener(this);
		productStop.addActionListener(this);
	//	productList.addActionListener(this);
		
		
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
				f.changePanel("SellerModification"); //추후에 seller, consumer case 나눠서 다시 코딩하기 
			else if (e.getActionCommand() == "Product Registration")
				f.changePanel("Product Registration");
			else if (e.getActionCommand() == "My Product")
				f.changePanel("MyProduct");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
	}
}
