package DaBwang;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyboardPanel extends JPanel implements ActionListener {
	
	private int W = 600;
	private int H = 900;
	
	private static JTextArea text;
	
	private JComboBox<String> manufac;
	private JComboBox<String> connec;
	private JComboBox<String> type;
	
	private static ArrayList<String> manufacturer;
	private static ArrayList<String> connection;
	private static ArrayList<String> typeS;
	
	private JLabel manufL;
	private JLabel connecL;
	private JLabel typeL;
	
	private JButton search;
	private JButton enter;
	
	private JButton GPA;
	private JButton salesV;
	private JButton highPrice;
	private JButton lowPrice;
	private JTextField inputT;
	
	private JScrollPane jsp;

 	ResultSet rs = null;
    Statement stmt = null;
    
    public void setingNamekey() throws SQLException{
		manufacturer = new ArrayList<>();
		connection = new ArrayList<>();
		typeS = new ArrayList<>();
		
		manufacturer.add("---");connection.add("---");typeS.add("---");
		
		stmt = MainApp.con.createStatement();
		rs = stmt.executeQuery("SELECT DISTINCT manufacturer FROM keyboardlist;");
		while( rs.next() )
			manufacturer.add(rs.getString("manufacturer"));
		rs = stmt.executeQuery("SELECT DISTINCT connection_way FROM keyboardlist;");
		while( rs.next() )
			connection.add(rs.getString("connection_way"));
		rs = stmt.executeQuery("SELECT DISTINCT keyboard_type FROM keyboardlist;");
		while( rs.next() ) 
			typeS.add(rs.getString("keyboard_type"));

	}
	public KeyboardPanel() throws SQLException {
		setingNamekey();
		stmt = MainApp.con.createStatement();
		
		inputT = new JTextField();
		inputT.setBounds(50,530,150,50);
		add(inputT);
		
		text = new JTextArea();
		jsp = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(50,300,500,150);
		add(jsp);
		
		GPA = new JButton("GPA");
		salesV = new JButton("Sales Volume");
		highPrice = new JButton("High Price");
		lowPrice = new JButton("Low Price");
		
		GPA.setBounds(50,480,50,50);
		salesV.setBounds(100,480,150,50);
		highPrice.setBounds(250,480,150,50);
		lowPrice.setBounds(400,480,150,50);
		
		GPA.addActionListener(this);
		salesV.addActionListener(this);
		highPrice.addActionListener(this);
		lowPrice.addActionListener(this);
		
		add(GPA);
		add(salesV);
		add(highPrice);
		add(lowPrice);
		
		manufL = new JLabel("Manufacturer");
		connecL = new JLabel("Connect");
		typeL = new JLabel("Type");
		
		
		manufL.setBounds(16,50,150,50);
		typeL.setBounds(270,50,150,50);
		connecL.setBounds(50,150,150,50);
		
		add(manufL);
		add(connecL);
		add(typeL);
		
		search = new JButton("Search");
		enter = new JButton("Enter");
		enter.setBounds(200,530,80,50);
		search.setBounds(470,130,80,100);
		enter.addActionListener(this);
		search.addActionListener(this);
		add(search);
		add(enter);
		
		manufac = new JComboBox<String>(new Vector<String>(manufacturer));
		connec = new JComboBox<String>(new Vector<String>(connection));
		type = new JComboBox<String>(new Vector<String>(typeS));
		
		manufac.setBounds(100,50,150,50);
		type.setBounds(300,50,150,50);
		connec.setBounds(100,150,150,50);
		
		add(manufac);
		add(connec);
		add(type);		
		
		setSize(W,H);
		setBackground(Color.WHITE);
		setLayout(null);
	   	setVisible(true);
	   	
	   	try{
			rs = stmt.executeQuery("SELECT productlist.*, keyboardlist.keyboard_name, sellerlist.seller_id "
					+ "FROM productlist "
					+ " INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
					+ " INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id "
					+ " where productlist.is_Available = 1;" );
			display(rs);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = null;
		if(e.getActionCommand() == "Search")
		{
			try{
				if(manufac.getSelectedItem() != "---") 
					s = s + "AND keyboardlist.manufacturer = '"+ manufac.getSelectedItem().toString() +"' " ;
				if(connec.getSelectedItem() != "---") 
					s = s + "AND keyboardlist.connection_way = '"+ connec.getSelectedItem().toString() +"' ";
				if(type.getSelectedItem() != "---") 
					s = s + "AND keyboardlist.keyboard_type = '"+ type.getSelectedItem().toString() +"' " ;
				if(s != null) {
					s = "where " + s.substring(7);
					rs = stmt.executeQuery("SELECT productlist.*, keyboardlist.keyboard_name, sellerlist.seller_id FROM productlist "
						+ "INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no " 
						+" INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id "+ s + ";" );
				}
				else if (s == null)
					rs = stmt.executeQuery("SELECT productlist.*, keyboardlist.keyboard_name, sellerlist.seller_id "
							+ "FROM productlist "
							+ " INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
							+ " INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id "
							+ " where productlist.is_Available = 1;" );
				display(rs);
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//end if search
			if(e.getActionCommand() == "GPA")
			{
				try{
					rs = stmt.executeQuery("SELECT productlist.*, reviewlist.* , orderlist.*, sellerlist.*,  keyboardlist.*"
							+ " FROM (orderlist "
							+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id"
							+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no"
							+ " INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id"
							+ " INNER JOIN reviewlist ON orderlist.order_id = reviewlist.order_id ) order by review_GPA ASC");
			
					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if GPA
			
			if(e.getActionCommand() == "Sales Volume")
			{
				try{
					rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  keyboardlist.*, count(orderlist.product_id) as num"
							+ " FROM (orderlist " 
							+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
							+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
							+ "	INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id ) group by orderlist.product_id order by num desc;");
				
					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if salesV
			if(e.getActionCommand() == "High Price")
			{
				try{
					rs = stmt.executeQuery("SELECT productlist.*, keyboardlist.*, sellerlist.*"
		    				+ " FROM (productlist"
		    				+ " INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id"
		    				+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price DESC;") ;
		        	
					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if highPrice
			if(e.getActionCommand() == "Low Price")
			{
				try{
					rs = stmt.executeQuery("SELECT productlist.*, keyboardlist.*, sellerlist.*"
	        				+ " FROM (productlist"
	        				+ " INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id"
	        				+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price ASC;") ;
	    	
					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if lowPrice			
//	
//		MainFrame f;
//		try {
//			f = new MainFrame();
//			if(e.getActionCommand() == "Enter")
//				f.changePanel("enter");
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
				
	}
	public static void display(ResultSet rs) throws SQLException{
		String product_name;
		String seller_id;
		String price;
		int stock;
		String content = "productName		Seller ID	Price	Stock \n";
		content = content + " \n";
		if( rs == null ) System.out.println("해당  내용을 찾을 수 없습니다.");
	    while( rs.next() )
	      { 
	    	product_name = rs.getString("keyboard_name");
			seller_id = rs.getString("seller_id");
			price = rs.getString("price");
			stock = rs.getInt("stock");
			content = content + product_name+"	"+seller_id + "	"+price+"	"+stock+"\n";
			text.setText(content);
		 }
	   }
	      
}

