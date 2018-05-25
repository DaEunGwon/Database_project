package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ProductRegistration extends JPanel implements ActionListener{

	private JButton laptop;
	private JButton monitor;
	private JButton mouse;
	private JButton keyboard;
	
	public ProductRegistration() {
		 laptop = new JButton("Laptop");
		 mouse = new JButton("Mouse");
		 monitor = new JButton("Monitor");
		 keyboard = new JButton("Keyboard");
		 
		 
		 laptop.addActionListener(this);
		 mouse.addActionListener(this);
		 monitor.addActionListener(this);
		 keyboard.addActionListener(this);
		 
		 
		 laptop.setBounds(170,100,100,100);
		 mouse.setBounds(330,100,100,100);
		 monitor.setBounds(170,300,100,100);
		 keyboard.setBounds(330,300,100,100);
		
		 
		 add(laptop);
		 add(mouse);
		 add(monitor);
		 add(keyboard);
		
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
				f.changePanel("Sellerlaptop");
			else if(e.getActionCommand() == "Mouse")
				f.changePanel("SellerMouse");
			else if(e.getActionCommand() == "Monitor")
				f.changePanel("SellerMonitor");
			else if(e.getActionCommand() == "Keyboard")
				f.changePanel("SellerKeyboard");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

}
