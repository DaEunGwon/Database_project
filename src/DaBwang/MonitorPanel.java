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

public class MonitorPanel extends JPanel implements ActionListener {
	
	private int W = 600;
	private int H = 900;
	
	private static JTextArea text;
	
	private JComboBox<String> manufac;
	private JComboBox<String> size;
	private JComboBox<String> resolution;
	private JComboBox<String> panelType;
	private JComboBox<String> input_T;
	private JComboBox<String> rate;
	
	private static ArrayList<String> manufacture;
	private static ArrayList<String> screen_size;
	private static ArrayList<String> screen_resolution;
	private static ArrayList<String> panel_Type;
	private static ArrayList<String> input;
	private static ArrayList<String> screen_rate;
	
	private JLabel manufL;
	private JLabel sizeL;
	private JLabel resolL;
	private JLabel panelL;
	private JLabel inputL;
	private JLabel rateL;
	
	private JButton search;
	private JButton enter;
	private JScrollPane jsp;
	
	private JButton GPA;
	private JButton salesV;
	private JButton highPrice;
	private JButton lowPrice;
	private JTextField inputT;
	
	ResultSet rs = null;
    Statement stmt = null;
	
    public void setingNameMoni() throws SQLException{
    	manufacture = new ArrayList<>();
    	screen_size = new ArrayList<>();
    	screen_resolution = new ArrayList<>();
    	panel_Type = new ArrayList<>();
    	input = new ArrayList<>();
    	screen_rate = new ArrayList<>();
		
    	manufacture.add("---");screen_size.add("---");screen_resolution.add("---");
    	panel_Type.add("---");input.add("---");screen_rate.add("---");
        
		stmt = MainApp.con.createStatement();
		rs = stmt.executeQuery("SELECT DISTINCT manufacturer FROM monitorlist;");
		while( rs.next() )
			manufacture.add(rs.getString("manufacturer"));
		rs = stmt.executeQuery("SELECT DISTINCT screen_size FROM monitorlist;");
		while( rs.next() )
			screen_size.add(rs.getString("screen_size"));
		rs = stmt.executeQuery("SELECT DISTINCT panel_type FROM monitorlist;");
		while( rs.next() ) 
			panel_Type.add(rs.getString("panel_Type"));
		rs = stmt.executeQuery("SELECT DISTINCT input_terminal FROM monitorlist;");
		while( rs.next() )
			input.add(rs.getString("input_terminal"));
		rs = stmt.executeQuery("SELECT DISTINCT screen_rate FROM monitorlist;");
		while( rs.next() )
			screen_rate.add(rs.getString("screen_rate"));

	}
	public MonitorPanel() throws SQLException {
		setingNameMoni();
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
		sizeL = new JLabel("Size");
		resolL = new JLabel("Resolution");
		panelL = new JLabel("Panel");
		inputL = new JLabel("Terminal");
		rateL = new JLabel("Rate");
		
		manufL.setBounds(16,50,150,50);
		sizeL.setBounds(270,50,150,50);
		resolL.setBounds(15,150,150,50);
		panelL.setBounds(260,150,150,50);
		inputL.setBounds(25,250,150,50);
		rateL.setBounds(260,250,150,50);
		
		add(manufL);
		add(sizeL);
		add(resolL);
		add(panelL);
		add(inputL);
		add(rateL);
		
		search = new JButton("Search");
		enter = new JButton("Enter");
		enter.setBounds(200,530,80,50);
		search.setBounds(470,130,80,100);
		enter.addActionListener(this);
		search.addActionListener(this);
		add(search);
		add(enter);
		
		manufac = new JComboBox<String>(new Vector<String>(manufacture));
		size = new JComboBox<String>(new Vector<String>(screen_size));
		resolution = new JComboBox<String>(new Vector<String>(screen_resolution));
		panelType = new JComboBox<String>(new Vector<String>(panel_Type));
		input_T = new JComboBox<String>(new Vector<String>(input));
		rate = new JComboBox<String>(new Vector<String>(screen_rate));
		
		manufac.setBounds(100,50,150,50);
		size.setBounds(300,50,150,50);
		resolution.setBounds(100,150,150,50);
		panelType.setBounds(300,150,150,50);
		input_T.setBounds(100,250,150,50);
		rate.setBounds(300,250,150,50);
		
		add(manufac);
		add(size);
		add(resolution);
		add(panelType);
		add(input_T);
		add(rate);
		
		setSize(W,H);
		setBackground(Color.WHITE);
		setLayout(null);
	   	setVisible(true);
		try{
			rs = stmt.executeQuery("SELECT productlist.*, monitorlist.monitor_name, sellerlist.seller_id "
					+ "FROM productlist INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
					+ " INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id "
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
					s = s + "AND monitorlist.manufacturer = '"+ manufac.getSelectedItem().toString() +"' " ;
				if(size.getSelectedItem() != "---") 
					s = s + "AND monitorlist.screen_size = '"+ size.getSelectedItem().toString() +"' ";
				if(resolution.getSelectedItem() != "---") 
					s = s + "AND monitorlist.resolution = '"+ resolution.getSelectedItem().toString() +"' " ;
				if(panelType.getSelectedItem() != "---") 
					s = s + "AND monitorlist.panel_type = '"+ panelType.getSelectedItem().toString() +"' " ;
				if(input_T.getSelectedItem() != "---") 
					s = s + "AND monitorlist.input_terminal = '"+ input_T.getSelectedItem().toString() +"' " ;
				if(rate.getSelectedItem() != "---") 
					s = s + "AND monitorlist.screen_rate = '"+ rate.getSelectedItem().toString() +"' " ;
				if(s != null) {
					s = "where " + s.substring(7);
					rs = stmt.executeQuery("SELECT productlist.*, monitorlist.*, sellerlist.seller_id FROM productlist "
						+ "INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
							+" INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id " + s + ";" );
				}
				else if(s == null)
					rs = stmt.executeQuery("SELECT productlist.*, monitorlist.monitor_name, sellerlist.seller_id "
							+ "FROM productlist INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "
							+ " INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id "
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
					rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  monitorlist.*, count(orderlist.product_id) as num"
							+ " FROM (orderlist " 
							+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
							+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
							+ "	INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id ) group by orderlist.product_id order by num desc;");

					display(rs);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}//end if salesV
			if(e.getActionCommand() == "High Price")
			{
				try{
					rs = stmt.executeQuery("SELECT productlist.*, monitorlist.*, sellerlist.*"
		    				+ " FROM (productlist"
		    				+ " INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id"
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
					rs = stmt.executeQuery("SELECT productlist.*, monitorlist.*, sellerlist.*"
	        				+ " FROM (productlist"
	        				+ " INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id"
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
		content = content + "\n";
		if( rs == null ) System.out.println("해당  내용을 찾을 수 없습니다.");
	    while( rs.next() )
	      { 
	    	product_name = rs.getString("monitor_name");
			seller_id = rs.getString("seller_id");
			price = rs.getString("price");
			stock = rs.getInt("stock");
			content = content + product_name+"	"+seller_id + "	"+price+"	"+stock+"\n";
			text.setText(content);
		 }
	   }

}
