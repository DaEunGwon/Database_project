package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SellerMyProduct extends JPanel implements ActionListener {
	
	private JLabel productL;
	private JLabel stoppedL;
	
	private JTextArea productA;
	private JTextArea stoppedA;
	
	private JScrollPane productP;
	private JScrollPane stoppedP;
	
	private JButton acceptB;
	
	public SellerMyProduct() {
		productL = new JLabel("My Product");
		stoppedL = new JLabel("Suspension of sale");
		
		productL.setBounds(30,30,100,100);
		stoppedL.setBounds(30,230,200,100);
		
		add(productL);
		add(stoppedL);
		
		productA = new JTextArea();
		stoppedA = new JTextArea();
	
		
		productP = new JScrollPane(productA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		stoppedP = new JScrollPane(stoppedA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		productP.setBounds(30,100,500,100);
		stoppedP.setBounds(30,300,500,100);
		
		add(productP);
		add(stoppedP);
		
		acceptB = new JButton("Accept");
		acceptB.setBounds(450,450,100,50);
		acceptB.addActionListener(this);
		add(acceptB);
		
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			MainFrame f = new MainFrame();
			
			if(e.getActionCommand() == "Accept") {
				
				f.changePanel("Accept");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
