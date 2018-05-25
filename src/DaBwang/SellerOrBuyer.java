package DaBwang;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SellerOrBuyer extends JPanel implements ActionListener{

	private JButton seller;
	private JButton buyer; 
	
	private int W = 600;
	private int H = 900;
	
	public SellerOrBuyer() {
		seller = new JButton("Seller");
		buyer = new JButton("Buyer");
		
		seller.setBounds(250,200,100,80);
		buyer.setBounds(250,350,100,80);
		
		seller.addActionListener(this);
		buyer.addActionListener(this);
		
		add(seller);
		add(buyer);
		
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
			if(e.getActionCommand() == "Seller")
				f.changePanel("Seller");
			else if(e.getActionCommand() == "Buyer")
				f.changePanel("Buyer");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}
