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

public class MousePanel extends JPanel implements ActionListener {
	
	private int W = 600;
	private int H = 900;
	
	private static JTextArea text;
	
	private static JComboBox<String> manufac;
	private static JComboBox<String> conn;
	private static JComboBox<String> DPI;
	private static JComboBox<String> accel;

	private static ArrayList<String> manufacturer;
	private static ArrayList<String> pro_conn;
	private static ArrayList<String> pro_DPI;
	private static ArrayList<String> pro_accel;

	
	private JLabel manufL;
	private JLabel connL;
	private JLabel dpiL;
	private JLabel accelL;
	
	private JButton search;
	private JButton enter;
	private JScrollPane jsp;
	
	private JButton salesV;
	private JButton highPrice;
	private JButton lowPrice;
	private JTextField inputT;
	
	ResultSet rs = null;
    Statement stmt = null;

	public void setingNameMouse() throws SQLException{
		manufacturer = new ArrayList<>();
		pro_conn = new ArrayList<>();
		pro_DPI = new ArrayList<>();
		pro_accel = new ArrayList<>();
		
		manufacturer.add("---");pro_conn.add("---");
		pro_DPI.add("---");pro_accel.add("---");
		
        stmt = MainApp.con.createStatement();
		rs = stmt.executeQuery("SELECT DISTINCT manufacturer FROM mouselist;");
		while( rs.next() )
			manufacturer.add(rs.getString("manufacturer"));
		rs = stmt.executeQuery("SELECT DISTINCT connection_way FROM mouselist;");
		while( rs.next() ) 
			pro_conn.add(rs.getString("connection_way"));
		rs = stmt.executeQuery("SELECT DISTINCT dpi FROM mouselist;");
		while( rs.next() )
			pro_DPI.add(rs.getString("dpi"));
		rs = stmt.executeQuery("SELECT DISTINCT acceleration FROM mouselist;");
		while( rs.next() )
			pro_accel.add(rs.getString("acceleration"));
		}
	public MousePanel() throws SQLException {
		setingNameMouse();
		stmt = MainApp.con.createStatement();
		
		inputT = new JTextField();
		inputT.setBounds(50,530,150,50);
		add(inputT);
			
		salesV = new JButton("Sales Volume");
		highPrice = new JButton("High Price");
		lowPrice = new JButton("Low Price");
		
		salesV.setBounds(100,480,150,50);
		highPrice.setBounds(250,480,150,50);
		lowPrice.setBounds(400,480,150,50);
		
		salesV.addActionListener(this);
		highPrice.addActionListener(this);
		lowPrice.addActionListener(this);
		
		add(salesV);
		add(highPrice);
		add(lowPrice);
		
		text = new JTextArea();
		jsp = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(50,300,500,150);
		add(jsp);
		
		manufL = new JLabel("Manufacturer");
		connL = new JLabel("Connection");
		dpiL = new JLabel("DPI");
		accelL = new JLabel("Acceleration");
		
		manufL.setBounds(16,50,150,50);
		connL.setBounds(270,50,150,50);
		dpiL.setBounds(50,150,150,50);
		accelL.setBounds(265,150,150,50);
		
		add(manufL);
		add(connL);
		add(dpiL);
		add(accelL);
		
		search = new JButton("Search");
		enter = new JButton("Enter");
		enter.setBounds(200,530,80,50);
		search.setBounds(470,130,80,100);
		enter.addActionListener(this);
		search.addActionListener(this);
		add(search);
		add(enter);
		
		manufac =  new JComboBox<String>(new Vector<String>(manufacturer));
		conn =  new JComboBox<String>(new Vector<String>(pro_conn));
		DPI =  new JComboBox<String>(new Vector<String>(pro_DPI));
		accel =  new JComboBox<String>(new Vector<String>(pro_accel));
		
		manufac.setBounds(100,50,150,50);
		conn.setBounds(300,50,150,50);
		DPI.setBounds(100,150,150,50);
		accel.setBounds(300,150,150,50);
		
		add(manufac);
		add(conn);
		add(DPI);
		add(accel);
		
		setSize(W,H);
		setBackground(Color.WHITE);
		setLayout(null);
	   	setVisible(true);
	   	try{
			rs = stmt.executeQuery("SELECT productlist.*, mouselist.mouse_name, sellerlist.seller_id "
					+ "FROM productlist INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
					+ " INNER JOIN mouselist ON productlist.product_id = mouselist.product_id "
						+ "where productlist.is_Available = 1;" );
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
					s = s + "AND mouselist.manufacturer = '"+ manufac.getSelectedItem().toString() +"' " ;
				if(conn.getSelectedItem() != "---") 
					s = s + "AND mouselist.connection_way = '"+ conn.getSelectedItem().toString() +"' ";
				if(DPI.getSelectedItem() != "---") 
					s = s + "AND mouselist.dpi = '"+ DPI.getSelectedItem().toString() +"' " ;
				if(accel.getSelectedItem() != "---") 
					s = s + "AND mouselist.acceleration = '"+ accel.getSelectedItem().toString() +"' " ;
				if(s != null) {
					s = "where " + s.substring(7);
					rs = stmt.executeQuery("SELECT productlist.*, mouselist.*, sellerlist.seller_id FROM productlist "
						+ "INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
							+" INNER JOIN mouselist ON productlist.product_id = mouselist.product_id " + s + ";" );
				}
				else if(s == null)
					rs = stmt.executeQuery("SELECT productlist.*, mouselist.mouse_name, sellerlist.seller_id "
							+ "FROM productlist INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
							+ " INNER JOIN mouselist ON productlist.product_id = mouselist.product_id "
								+ "where productlist.is_Available = 1;" );
				display(rs);
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//end if search
			if(e.getActionCommand() == "Sales Volume")
			{
				try{
					rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  mouselist.*, count(orderlist.product_id) as num"
							+ " FROM (orderlist " 
							+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
							+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
							+ "	INNER JOIN mouselist ON productlist.product_id = mouselist.product_id ) group by orderlist.product_id order by num desc;");

					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if salesV
			if(e.getActionCommand() == "High Price")
			{
				try{
					rs = stmt.executeQuery("SELECT productlist.*, mouselist.*, sellerlist.*"
		    				+ " FROM (productlist"
		    				+ " INNER JOIN mouselist ON productlist.product_id = mouselist.product_id"
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
					rs = stmt.executeQuery("SELECT productlist.*, mouselist.*, sellerlist.*"
	        				+ " FROM (productlist"
	        				+ " INNER JOIN mouselist ON productlist.product_id = mouselist.product_id"
	        				+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price ASC;") ;
	    	
					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if lowPrice			
		
//		MainFrame f;
//		try {
//			f = new MainFrame();
//			if(e.getActionCommand() == "Enter")
//				f.changePanel("enter");
//			
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
	    	product_name = rs.getString("mouse_name");
			seller_id = rs.getString("seller_id");
			price = rs.getString("price");
			stock = rs.getInt("stock");
			content = content + product_name+"	"+seller_id + "	"+price+"	"+stock+"\n";
			text.setText(content);
		 }
	   }

}
