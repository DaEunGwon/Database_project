package DaBwang;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BuyerSelectProduct extends JPanel implements ActionListener{
	
	private int W = 600;
	private int H = 900;
	
	private JButton laptop;
	private JButton monitor;
	private JButton mouse;
	private JButton keyboard;
	private JButton myPage;
	public BuyerSelectProduct() {
		 laptop = new JButton("Laptop");
		 mouse = new JButton("Mouse");
		 monitor = new JButton("Monitor");
		 keyboard = new JButton("Keyboard");
		 myPage = new JButton("My Page");
		 
		 laptop.addActionListener(this);
		 mouse.addActionListener(this);
		 monitor.addActionListener(this);
		 keyboard.addActionListener(this);
		 myPage.addActionListener(this);
		 
		 laptop.setBounds(170,100,100,100);
		 mouse.setBounds(330,100,100,100);
		 monitor.setBounds(170,300,100,100);
		 keyboard.setBounds(330,300,100,100);
		 myPage.setBounds(500,500,70,70);
		 
		 add(laptop);
		 add(mouse);
		 add(monitor);
		 add(keyboard);
		 add(myPage);
		 
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
			if(e.getActionCommand() == "Laptop")
				f.changePanel("laptop");
			else if(e.getActionCommand() == "Mouse")
				f.changePanel("mouse");
			else if(e.getActionCommand() == "Monitor")
				f.changePanel("monitor");
			else if (e.getActionCommand() == "Keyboard")
				f.changePanel("Keyboard");
			else if(e.getActionCommand() == "My Page")
				f.changePanel("MyPage");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}
