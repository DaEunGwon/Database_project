package DaBwang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SellerProductStop extends JPanel implements ActionListener{//판매하는 제품 판매 중지 상태로 바꾸는 것. 
	
	private JScrollPane list; 
	private JTextArea listarea; 
	private JTextField search;
	private JButton searchButton;
	
	public SellerProductStop() {
		listarea = new JTextArea();
		search =new JTextField();
		list = new JScrollPane(listarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		searchButton = new JButton("Search");
		
		searchButton.setBounds(250,450,80,80);
		search.setBounds(50,450,100,100);
		list.setBounds(30,100,500,200);
		
		add(searchButton);
		add(search);
		add(list);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
