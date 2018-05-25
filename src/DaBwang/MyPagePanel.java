package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPagePanel extends JPanel implements ActionListener {
	
	private JButton modifi;
	private JButton orderList;
	private JButton comment;
	
	
	public MyPagePanel() {
		
		modifi = new JButton("Modification");
		orderList = new JButton("Order List");
		comment = new JButton("Comment");
		
		modifi.setBounds(250,100,150,150);
		orderList.setBounds(250,250,150,150);
		comment.setBounds(250,400,150,150);
		
		add(modifi);
		add(orderList);
		add(comment);
		
		modifi.addActionListener(this);
		orderList.addActionListener(this);
		comment.addActionListener(this);
		
		
		
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
				f.changePanel("Modification"); //추후에 seller, consumer case 나눠서 다시 코딩하기 
			else if (e.getActionCommand() == "Order List")
				f.changePanel("OrderInfo");
			else if (e.getActionCommand() == "Comment")
				f.changePanel("Comment");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
	}
}
