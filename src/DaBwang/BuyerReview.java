package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BuyerReview extends JPanel implements ActionListener{
	
	private JScrollPane reviewP;
	private JTextField text;
	private JButton upload;
	private JTextArea textA;
	
	public BuyerReview() {
		textA = new JTextArea();
		reviewP = new JScrollPane(textA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		reviewP.setBounds(30,30,500,250);
		add(reviewP);
		
		text = new JTextField();
		text.setBounds(30,350,400,100);
		add(text);
		
		upload = new JButton("Upload");
		upload.setBounds(450,350,100,50);
		add(upload);
		upload.addActionListener(this);
		
		setBackground(Color.WHITE);
		setLayout(null);
	   	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
