package DaBwang;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommentPanel extends JPanel {

	private JLabel comment;
	private JLabel review;
	
	
	private JTextArea commentArea;
	private JTextArea reviewArea;
	
	private JScrollPane commScroll;
	private JScrollPane reviewScroll;
	
	
    Statement s;
    ResultSet rs;
	private String gpa;
	private String review_comment;
	private String review_ID;
	private String content = "";
	private String comments;
	private String productID;
	public CommentPanel() throws SQLException {
		
		s = MainApp.con.createStatement();
		
		System.out.println("comment");

		 commentArea = new JTextArea();
		 reviewArea = new JTextArea();
		 
		commScroll = new JScrollPane(commentArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		reviewScroll = new JScrollPane(reviewArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		commScroll.setBounds(30,100,500,100);
		reviewScroll.setBounds(30,300,500,100);
		
		add(commScroll);
		add(reviewScroll);
		
		comment =new JLabel("Comment");
		comment.setBounds(30,30,100,100);
		add(comment);
		
		review = new JLabel("Review");
		review.setBounds(30,230,100,100);
		add(review);
		
		 try {
			 	content = "Num    GPA    commment\n";
			 	content = content + "------------------------------------\n";
				rs = s.executeQuery("SELECT * FROM reviewlist INNER JOIN consumer ON reviewlist.consumer_no = consumer.consumer_no WHERE consumer_id LIKE '"+LoginPanel.id.getText()+"'");//where으로 해당 아이디만 추가하
				while(rs.next()) {
					
					gpa = rs.getString("review_GPA");
					review_comment = rs.getString("review_comment");
					review_ID = rs.getString("review_id");
					
					content = content + review_ID+"        "+gpa + "        "+review_comment+"\n";
				 
					reviewArea.setText(content);
				}
				
				content = "productID      commment\n";
			 	content = content + "------------------------------------\n";
			 	rs = s.executeQuery("SELECT * FROM commentlist WHERE user_id LIKE '"+LoginPanel.id.getText()+"' ");//where으로 해당 아이디만 추가하
			 	
			 	
				while(rs.next()) {
					if(rs.getInt("parent_comment_id")==0) {
						productID = rs.getString("product_id");
						comments = rs.getString("comment_contents");
						
						content = content + productID+"        "+comments +"\n";
					 
						commentArea.setText(content);
						}
				}
			 	
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 try {
				s.close();
				//con.close();
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		
	}
	
}
