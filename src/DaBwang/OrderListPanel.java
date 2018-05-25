package DaBwang;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OrderListPanel extends JPanel implements ActionListener{

	private JLabel payment;
	private JLabel orderInfo;
	
	private JComboBox term;
	
	private JTextArea payArea;
	private JTextArea orderArea;
	
	private String invoice;
	private String product_ID;
	private String company;
	
	private JScrollPane payScroll;
	private JScrollPane orderScroll;
	
	private String time[] = {"---","1month","3month","6month","1year"};
	
	private JButton search;
	
//	Connection con = null;
    Statement s;
    ResultSet rs;
    String content ="";
    String year;
    String mon;
	public OrderListPanel() throws SQLException {
		
		s = MainApp.con.createStatement();
		
		 payArea = new JTextArea();
		 orderArea = new JTextArea();
		
		payScroll = new JScrollPane(payArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		orderScroll = new JScrollPane(orderArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		payScroll.setBounds(30,100,500,100);
		orderScroll.setBounds(30,300,500,100);
		
		add(payScroll);
		add(orderScroll);
		
		payment =new JLabel("Payment Check");
		payment.setBounds(30,30,100,100);
		add(payment);
		
		orderInfo = new JLabel("Past Order List");
		orderInfo.setBounds(30,230,100,100);
		add(orderInfo);
		
		term = new JComboBox<String>(time);
		term.setBounds(150,230,100,100);
		add(term);
		payment = new JLabel("Payment");
		
		search = new JButton("Search");
		search.setBounds(300,250,100,50);
		add(search);
		search.addActionListener(this);
		
		 
		 try {
			 
			 content = "productID   Transport company      invoice\n";
			 content = content + "------------------------------------------\n";
			rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"'");//where으로 해당 아이디만 추가하
			while(rs.next()) {
				
				company = rs.getString("transport_company");
				invoice = rs.getString("number_of_invoice");
				product_ID = rs.getString("product_id");
				 
				content = content + product_ID+"                 "+company + "                    "+invoice+"\n";
				payArea.setText(content);
				
			}
			 content = "productID   Transport company      invoice\n";
			 content = content + "------------------------------------------\n";
			 if(term.getActionCommand() == "1month")
				 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"' AND date(time_stp) >= date(subdate(now(), INTERVAL 1 month)) and date(time_stp) <= date(now()) ");
			 else if(term.getActionCommand() == "3month")
				 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"' AND date(time_stp) >= date(subdate(now(), INTERVAL 3 month)) and date(time_stp) <= date(now()) ");
			 else if(term.getActionCommand() == "6month")
				 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"' AND date(time_stp) >= date(subdate(now(), INTERVAL 6 month)) and date(time_stp) <= date(now()) ");
			 else if (term.getActionCommand() == "1year")
				 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"' AND date(time_stp) >= date(subdate(now(), INTERVAL 1 year)) and date(time_stp) <= date(now()) ");
			 else
				 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"'");
			while(rs.next()) {
				
				company = rs.getString("transport_company");
				invoice = rs.getString("number_of_invoice");
				product_ID = rs.getString("product_id");
				 
				content = content + product_ID+"                 "+company + "                    "+invoice+"\n";
				orderArea.setText(content);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		 content = "productID   Transport company      invoice\n";
		 content = content + "------------------------------------------\n";
		 if(e.getActionCommand() == "Search")
			try {
				if(term.getActionCommand() == "1month")
					rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"' AND date(time_stp) >= date(subdate(now(), INTERVAL 1 month)) and date(time_stp) <= date(now()) ");
				else if(term.getActionCommand() == "3month")
					 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"' AND date(time_stp) >= date(subdate(now(), INTERVAL 3 month)) and date(time_stp) <= date(now()) ");
				 else if(term.getActionCommand() == "6month")
					 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"' AND date(time_stp) >= date(subdate(now(), INTERVAL 6 month)) and date(time_stp) <= date(now()) ");
				 else if (term.getActionCommand() == "1year")
					 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"' AND date(time_stp) >= date(subdate(now(), INTERVAL 1 year)) and date(time_stp) <= date(now()) ");
				 else if(term.getActionCommand() == "---")
					 rs = s.executeQuery("SELECT * FROM orderlist INNER JOIN consumer ON orderlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"'");
				while(rs.next()) {
					
					company = rs.getString("transport_company");
					invoice = rs.getString("number_of_invoice");
					product_ID = rs.getString("product_id");
					 
					content = content + product_ID+"                 "+company + "                    "+invoice+"\n";
					orderArea.setText(content);
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}
}
