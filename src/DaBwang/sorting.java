package DaBwang;
//made by Gwon Daeun
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class sorting {
	
	private static String sql_option = "SELECT productlist.*, laptopinfolist.*, sellerlist.*"
			+ "FROM productlist "
			+ "INNER JOIN sellerlist ON  productlist.seller_no = sellerlist.seller_no "; 
			
	public static void search_laptop(Connection conn) throws SQLException{
		ResultSet rs = null;
		Statement stmt = null;
		String type = "laptop_";
		Scanner sc = new Scanner(System.in);
       	System.out.print("0:ram, 1:색상, 2:크기, 3:가격, 4:제조사, 5:판매순위, 6:평점  ---> ");
        int key = Integer.parseInt( sc.nextLine() );
        stmt = (Statement) conn.createStatement();
       
        if( key == 0 ){ //사양
        	System.out.print("ram 선택 : ");
    		String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option + "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id where laptopinfolist.ram_info = "+cn+";" );
    		display(rs, type);
        }
        else if( key == 1 ){//색상(완성)
		System.out.print("색 선택 : ");
		String cn = sc.nextLine();
		rs = stmt.executeQuery(sql_option + "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id where laptopinfolist.color like '%"+cn+"%';" );
		display(rs, type);
        }
        else if( key == 2 ){//크기
    		System.out.print("크기 선택 : ");
    		String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option + "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id where laptopinfolist.size_info like '%"+cn+"%';" );
    		display(rs, type);
        }
        else if( key == 3 ){//가격 
        	//s높은 가격 순
    		System.out.print("높은 가격(1) 낮은 가격(2) : ");
    		int cn = sc.nextInt();
    		if(cn == 1)
    		rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.*, sellerlist.*"
    				+ "FROM (productlist"
    				+ "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id"
    				+ "INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price DESC;") ;
        	//낮은 가격순
    		else if(cn == 2)
    			rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.*, sellerlist.*"
        				+ "FROM (productlist"
        				+ "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id"
        				+ "INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price ASC;") ;
    		display(rs, type);
        }
        else if( key == 4 ){//제조사
			System.out.print("제조사 : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option + "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id where laptopinfolist.manufacturer like '%"+cn+"%';" );
			display(rs,type);
        }
        else if( key == 5 ){//판매순위
			System.out.print("판매순 : ");
			rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  laptopinfolist.*, count(orderlist.product_id) as num"
					+ " FROM (orderlist " 
					+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
					+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
					+ "	INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id ) group by orderlist.product_id order by num desc;");
			display(rs,type);
        }
        else if( key == 6 ){//평점순으로  수정
			System.out.print("평점순 : ");
			rs = stmt.executeQuery("SELECT productlist.*, reviewlist.* , orderlist.*, sellerlist.*,  laptopinfolist.*"
					+ " FROM (orderlist "
					+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id"
					+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no"
					+ " INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id"
					+ " INNER JOIN reviewlist ON orderlist.order_id = reviewlist.order_id ) order by review_GPA ASC");
			display(rs,type);
        }
	}//end search
	
	@SuppressWarnings("resource")
	public static void search_mouse(Connection conn) throws SQLException{
		ResultSet rs = null;
		Statement stmt = null;
		String type = "mouse_";
		Scanner sc = new Scanner(System.in);
        System.out.print("0:제조사, 1:판매순위 , 2:무게, 3:연결 방법, 4:dpi, 5:acceleration ---> ");// 센싱방법은 모두 동일 제외
        int sn = Integer.parseInt( sc.nextLine() );
        stmt = (Statement) conn.createStatement();
        if( sn == 0 ){ //제조사
        	System.out.print("제조사 : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option + "INNER JOIN mouselist ON productlist.product_id = mouselist.product_id where mouselist.manufacturer like '%"+cn+"%';" );
			display(rs,type);
        }
        else if( sn == 1 ){//판매순
			System.out.print("판매순 : ");
			rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  mouselist.*, count(orderlist.product_id) as num"
					+ " FROM (orderlist " 
					+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
					+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
					+ "	INNER JOIN mouselist ON productlist.product_id = mouselist.product_id ) group by orderlist.product_id order by num desc;");
			display(rs,type); 
		}
        if( sn == 2 ){ //무게
        	System.out.print("무게(kg) : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN mouselist ON productlist.product_id = mouselist.product_id where mouselist.weight like '%"+cn+"%';" );
			display(rs,type);
        }
        if( sn == 3 ){ //연결 방법
        	System.out.print("연결방법 : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN mouselist ON productlist.product_id = mouselist.product_id where mouselist.connection_way like '%"+cn+"%';" );
			display(rs,type);
        }
        if( sn == 4 ){ //dpi
        	System.out.print("dpi : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN mouselist ON productlist.product_id = mouselist.product_id where mouselist.dpi like '%"+cn+"%';" );
			display(rs,type);
        }
        if( sn == 5 ){ //acceleration
        	System.out.print("acceleration : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN mouselist ON productlist.product_id = mouselist.acceleration where mouselist.connection_way like '%"+cn+"%';" );
			display(rs,type);
        }
	}//end search
	
	public static void search_keyboard(Connection conn) throws SQLException{
		ResultSet rs = null;
		Statement stmt = null;
		String type = "keyboard_";
		Scanner sc = new Scanner(System.in);
        System.out.print("0:제조사, 1:판매순위  ---> ");
        int sn = Integer.parseInt( sc.nextLine() );
        stmt = (Statement) conn.createStatement();
        if( sn == 0 ){ //제조사
        	System.out.print("제조사 : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option + "INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id where keyboardlist.manufacturer like '%"+cn+"%';" );
			display(rs,type);
        }
        else if( sn == 1 ){//색상(완성)
        	System.out.print("판매순 : ");
			rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  keyboardlist.*, count(orderlist.product_id) as num"
					+ " FROM (orderlist " 
					+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
					+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
					+ "	INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id ) group by orderlist.product_id order by num desc;");
			display(rs,type); 
        }		
	}//end search

	public static void search_monitor(Connection conn) throws SQLException{
		ResultSet rs = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		String type = "monitor_";
        System.out.print("0:제조사, 1:크기, 2:판매순위 , 3:스크린 해상도, 4: 판넬 타입, 5:input, 6:rate---> ");
        int sn = Integer.parseInt( sc.nextLine() );
        stmt = (Statement) conn.createStatement();
        if( sn == 0 ){ //제조사
        	System.out.print("제조사 : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.manufacturer like '%"+cn+"%';" );
			display(rs,type);
        }
        else if( sn == 1 ){//크기
        	System.out.print("크기 선택 : ");
    		String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.size_info like '%"+cn+"%';" );
    		display(rs, type);
		}
        else if( sn == 2 ){//판매순위
    		System.out.print("판매순 : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  monitorlist.*, count(orderlist.product_id) as num"
					+ " FROM (orderlist " 
					+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
					+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
					+ "	INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id ) group by orderlist.product_id order by num desc;");
			display(rs,type); 
        }
        else if( sn == 3 ){//스크린 해상도
    		System.out.print("스크린 해상도 : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.resolution like '%"+cn+"%';" );
			display(rs,type); 
        }
        else if( sn == 4 ){//판넬 타입
    		System.out.print("판넬 타입 : ");
			String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.panel_type like '%"+cn+"%';" );
			display(rs,type); 
        }
        else if( sn == 5 ){//input
    		System.out.print("input : ");
			String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.input_terminal like '%"+cn+"%';" );
				display(rs,type); 
        }
        else if( sn == 6 ){//rate
    		System.out.print("rate : ");
    		String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.screen_rate like '%"+cn+"%';" );
			display(rs,type); 
        }
	}//end search
	
	public static void display(ResultSet rs, String type) throws SQLException{
		String product_name;
    	String seller_id;
		String price;
		int stock;
		if( rs == null ) System.out.println("해당  내용을 찾을 수 없습니다.");
	    while( rs.next() )
	      { 
	    	product_name = rs.getString(type+"name");
	    	seller_id = rs.getString("seller_id");
			price = rs.getString("price");
			stock = rs.getInt("stock");
	          System.out.printf("%s %s %s %d",product_name,seller_id,price,stock );
	          System.out.println("");
	      }
	      System.out.println("");
	}
}
