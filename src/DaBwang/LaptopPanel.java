package DaBwang;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LaptopPanel extends JPanel implements ActionListener {
	
	private int W = 600;
	private int H = 900;
	
	private static JTextArea text;
	
	private static JComboBox<String> manufac;
	private static JComboBox<String> ram;
	private static JComboBox<String> storage;
	private static JComboBox<String> color;
	private static JComboBox<String> weight;
	private static JComboBox<String> size;

	private static ArrayList<String> manufacturer;
	private static ArrayList<String> RAM;
	private static ArrayList<String> store;
	private static ArrayList<String> product_color;
	private String product_weight[] = {"---", "1kg 미만","1~2kg", "2kg 이상"};
	private String product_size[] = {"---", "13인치 이하", "14인치","15인치 이상" };
	
	private JLabel manufL;
	private JLabel ramL;
	private JLabel storageL;
	private JLabel colorL;
	private JLabel weightL;
	private JLabel sizeL;

	private JButton search;
	private JButton enter;
	private JScrollPane jsp;
	
	private JButton GPA;
	private JButton salesV;
	private JButton highPrice;
	private JButton lowPrice;
	private JTextField inputT;
	
    Statement stmt = null;
	ResultSet rs= null;	 
	//setting the sorting list
	public void setingNameL() throws SQLException{
		manufacturer = new ArrayList<>();
		RAM = new ArrayList<>();
		store = new ArrayList<>();
		product_color = new ArrayList<>();
		
		manufacturer.add("---");RAM.add("---");product_color.add("---");store.add("---");
        
		stmt = MainApp.con.createStatement();
		rs = stmt.executeQuery("SELECT DISTINCT manufacturer FROM laptopinfolist;");
		while( rs.next() )
			manufacturer.add(rs.getString("manufacturer"));
		rs = stmt.executeQuery("SELECT DISTINCT ram_info FROM laptopinfolist;");
		while( rs.next() )
			RAM.add(rs.getString("ram_info"));
		rs = stmt.executeQuery("SELECT DISTINCT storage_capacity FROM laptopinfolist;");
		while( rs.next() ) 
			store.add(rs.getString("storage_capacity"));
		rs = stmt.executeQuery("SELECT DISTINCT color FROM laptopinfolist;");
		while( rs.next() )
			product_color.add(rs.getString("color"));

	}
	
	
	public LaptopPanel() throws SQLException {
		setingNameL() ;
		String content = "productName		Seller ID	Price	Stock \n";
		content = content + "----	----	----	----	 ----	----	----	----	 \n";
		stmt = MainApp.con.createStatement();

		inputT = new JTextField();
		inputT.setBounds(50,530,150,50);
		add(inputT);

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
		
		text = new JTextArea();
		jsp = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(50,300,500,150);
		add(jsp);
		
		manufL = new JLabel("Manufacturer");
		ramL = new JLabel("RAM");
		storageL = new JLabel("Storage");
		colorL = new JLabel("Color");
		weightL = new JLabel("Weight");
		sizeL = new JLabel("Size");
		
		manufL.setBounds(16,50,150,50);
		ramL.setBounds(270,50,150,50);
		storageL.setBounds(50,150,150,50);
		colorL.setBounds(265,150,150,50);
		weightL.setBounds(50,250,150,50);
		sizeL.setBounds(270,250,150,50);
		
		add(manufL);
		add(ramL);
		add(storageL);
		add(colorL);
		add(weightL);
		add(sizeL);
		
		search = new JButton("Search");
		enter = new JButton("Enter");
		enter.setBounds(200,530,80,50);
		search.setBounds(470,130,80,100);
		enter.addActionListener(this);
		search.addActionListener(this);
		add(search);
		add(enter);
		
		manufac = new JComboBox<String>(new Vector<String>(manufacturer));
		ram = new JComboBox<String>(new Vector<String>(RAM));
		storage = new JComboBox<String>(new Vector<String>(store));
		color = new JComboBox<String>(new Vector<String>(product_color));
		weight = new JComboBox<String>(product_weight);
		size = new JComboBox<String>(product_size);
		
		manufac.setBounds(100,50,150,50);
		ram.setBounds(300,50,150,50);
		storage.setBounds(100,150,150,50);
		color.setBounds(300,150,150,50);
		weight.setBounds(100,250,150,50);
		size.setBounds(300,250,150,50);
		
		add(manufac);
		add(ram);
		add(storage);
		add(color);
		add(weight);
		add(size);
		
		setSize(W,H);
		setBackground(Color.WHITE);
		setLayout(null);
	   	setVisible(true);
	   	try{
			rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.laptop_name, sellerlist.seller_id "
					+ "FROM productlist "
					+ " INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
					+ " INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id "
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
		String content = "productName		Seller ID	Price	Stock \n";
		content = content + "------------------------------------------ \n";
		if(e.getActionCommand() == "Search")
		{
			try{
				if(manufac.getSelectedItem() != "---") 
					s = s + "AND laptopinfolist.manufacturer = '"+ manufac.getSelectedItem().toString() +"' " ;
				if(ram.getSelectedItem() != "---") 
					s = s + "AND laptopinfolist.ram_info = '"+ ram.getSelectedItem().toString() +"' ";
				if(storage.getSelectedItem() != "---") 
					s = s + "AND laptopinfolist.storage_capacity = '"+ storage.getSelectedItem().toString() +"' " ;
				if(color.getSelectedItem() != "---") 
					s = s + "AND laptopinfolist.color = '"+ color.getSelectedItem().toString() +"' " ;
				if(weight.getSelectedItem() != "---") {
					if (weight.getSelectedItem() == "1kg 미만")
						s = s + "AND laptopinfolist.weight between 0 and 0.999; " ;
					else if(weight.getSelectedItem() == "1~2kg") 
						s = s + "AND laptopinfolist.weight between 1 and 1.999;" ;
					else if(weight.getSelectedItem() == "2kg 이상")
						s = s + "AND laptopinfolist.weight between 2 and 10; " ;
				}
				if(size.getSelectedItem() != "---") {
					if (weight.getSelectedItem() == "13인치 이하")
						s = s + "AND laptopinfolist.size_info  between 0 and 13  ";
					else if(weight.getSelectedItem() == "14인치") 
						s = s + "AND laptopinfolist.size_info between 14 and 14.9 ";
					else if(weight.getSelectedItem() == "15인치 이상")
						s = s + "AND laptopinfolist.size_info between 15 and 14.9 ";
				}
				if(s != null) {
					s = "where " + s.substring(7);
					rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.laptop_name, sellerlist.seller_id FROM productlist "
							+ "INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no " 
							+" INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id "+ s + ";" );
				}
				else if ( s == null)
					rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.laptop_name, sellerlist.seller_id "
							+ "FROM productlist "
							+ " INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
							+ " INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id "
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
					rs = stmt.executeQuery("SELECT productlist.*, reviewlist.* , orderlist.*, sellerlist.*,  laptopinfolist.*"
							+ " FROM (orderlist "
							+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id"
							+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no"
							+ " INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id"
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
					rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  laptopinfolist.*, count(orderlist.product_id) as num"
							+ " FROM (orderlist " 
							+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
							+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
							+ "	INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id ) group by orderlist.product_id order by num desc;");
				
					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if salesV
			if(e.getActionCommand() == "High Price")
			{
				try{
					rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.*, sellerlist.*"
		    				+ " FROM (productlist"
		    				+ " INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id"
		    				+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price DESC;") ;
		        	
					if( rs == null ) System.out.println("해당  제품을 찾을 수 없습니다.");		
					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if highPrice
			if(e.getActionCommand() == "Low Price")
			{
				try{
					System.out.println("확인");
					rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.*, sellerlist.*"
	        				+ " FROM (productlist"
	        				+ " INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id"
	        				+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price ASC;") ;
	    	
					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if lowPrice			
//	
//			MainFrame f;
//			try {
//				f = new MainFrame();
//			if(e.getActionCommand() == "Enter")
//				f.changePanel("enter");
//		
//			} catch (SQLException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//			}
	}//end actionPerformed
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
	    	product_name = rs.getString("laptop_name");
			seller_id = rs.getString("seller_id");
			price = rs.getString("price");
			stock = rs.getInt("stock");
			content = content + product_name+"	"+seller_id + "	"+price+"	"+stock+"\n";
			text.setText(content);
		 }
	   }
}
