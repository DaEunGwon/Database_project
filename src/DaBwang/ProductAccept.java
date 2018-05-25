package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProductAccept extends JPanel implements ActionListener{

	private JLabel waitL;
	private JLabel acceptL;
	
	private JTextArea waitA;
	private JTextArea acceptA;
	
	private JScrollPane waitP;
	private JScrollPane acceptP;
	
	private JButton acceptB;
	
	private JTextField acceptT;
	
	public ProductAccept() {
		waitL = new JLabel("Waiting for Approval");
		acceptL = new JLabel("Approved");
		
		waitL.setBounds(30,30,200,100);
		acceptL.setBounds(30,330,200,100);
		
		add(waitL);
		add(acceptL);
		
		waitA = new JTextArea();
		acceptA = new JTextArea();
	
		
		waitP = new JScrollPane(waitA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		acceptP = new JScrollPane(acceptA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		waitP.setBounds(30,100,500,100);
		acceptP.setBounds(30,400,500,100);
		
		add(waitP);
		add(acceptP);
		
		acceptB = new JButton("Accept");
		acceptB.setBounds(200,230,100,50);
		add(acceptB);
		
		acceptT = new JTextField();
		acceptT.setBounds(30,230,150,50);
		add(acceptT);
		
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
