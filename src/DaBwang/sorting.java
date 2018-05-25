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
       	System.out.print("0:ram, 1:����, 2:ũ��, 3:����, 4:������, 5:�Ǹż���, 6:����  ---> ");
        int key = Integer.parseInt( sc.nextLine() );
        stmt = (Statement) conn.createStatement();
       
        if( key == 0 ){ //���
        	System.out.print("ram ���� : ");
    		String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option + "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id where laptopinfolist.ram_info = "+cn+";" );
    		display(rs, type);
        }
        else if( key == 1 ){//����(�ϼ�)
		System.out.print("�� ���� : ");
		String cn = sc.nextLine();
		rs = stmt.executeQuery(sql_option + "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id where laptopinfolist.color like '%"+cn+"%';" );
		display(rs, type);
        }
        else if( key == 2 ){//ũ��
    		System.out.print("ũ�� ���� : ");
    		String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option + "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id where laptopinfolist.size_info like '%"+cn+"%';" );
    		display(rs, type);
        }
        else if( key == 3 ){//���� 
        	//s���� ���� ��
    		System.out.print("���� ����(1) ���� ����(2) : ");
    		int cn = sc.nextInt();
    		if(cn == 1)
    		rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.*, sellerlist.*"
    				+ "FROM (productlist"
    				+ "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id"
    				+ "INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price DESC;") ;
        	//���� ���ݼ�
    		else if(cn == 2)
    			rs = stmt.executeQuery("SELECT productlist.*, laptopinfolist.*, sellerlist.*"
        				+ "FROM (productlist"
        				+ "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id"
        				+ "INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no ) order by price ASC;") ;
    		display(rs, type);
        }
        else if( key == 4 ){//������
			System.out.print("������ : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option + "INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id where laptopinfolist.manufacturer like '%"+cn+"%';" );
			display(rs,type);
        }
        else if( key == 5 ){//�Ǹż���
			System.out.print("�Ǹż� : ");
			rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  laptopinfolist.*, count(orderlist.product_id) as num"
					+ " FROM (orderlist " 
					+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
					+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
					+ "	INNER JOIN laptopinfolist ON productlist.product_id = laptopinfolist.product_id ) group by orderlist.product_id order by num desc;");
			display(rs,type);
        }
        else if( key == 6 ){//����������  ����
			System.out.print("������ : ");
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
        System.out.print("0:������, 1:�Ǹż��� , 2:����, 3:���� ���, 4:dpi, 5:acceleration ---> ");// ���̹���� ��� ���� ����
        int sn = Integer.parseInt( sc.nextLine() );
        stmt = (Statement) conn.createStatement();
        if( sn == 0 ){ //������
        	System.out.print("������ : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option + "INNER JOIN mouselist ON productlist.product_id = mouselist.product_id where mouselist.manufacturer like '%"+cn+"%';" );
			display(rs,type);
        }
        else if( sn == 1 ){//�Ǹż�
			System.out.print("�Ǹż� : ");
			rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  mouselist.*, count(orderlist.product_id) as num"
					+ " FROM (orderlist " 
					+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
					+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
					+ "	INNER JOIN mouselist ON productlist.product_id = mouselist.product_id ) group by orderlist.product_id order by num desc;");
			display(rs,type); 
		}
        if( sn == 2 ){ //����
        	System.out.print("����(kg) : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN mouselist ON productlist.product_id = mouselist.product_id where mouselist.weight like '%"+cn+"%';" );
			display(rs,type);
        }
        if( sn == 3 ){ //���� ���
        	System.out.print("������ : ");
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
        System.out.print("0:������, 1:�Ǹż���  ---> ");
        int sn = Integer.parseInt( sc.nextLine() );
        stmt = (Statement) conn.createStatement();
        if( sn == 0 ){ //������
        	System.out.print("������ : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option + "INNER JOIN keyboardlist ON productlist.product_id = keyboardlist.product_id where keyboardlist.manufacturer like '%"+cn+"%';" );
			display(rs,type);
        }
        else if( sn == 1 ){//����(�ϼ�)
        	System.out.print("�Ǹż� : ");
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
        System.out.print("0:������, 1:ũ��, 2:�Ǹż��� , 3:��ũ�� �ػ�, 4: �ǳ� Ÿ��, 5:input, 6:rate---> ");
        int sn = Integer.parseInt( sc.nextLine() );
        stmt = (Statement) conn.createStatement();
        if( sn == 0 ){ //������
        	System.out.print("������ : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.manufacturer like '%"+cn+"%';" );
			display(rs,type);
        }
        else if( sn == 1 ){//ũ��
        	System.out.print("ũ�� ���� : ");
    		String cn = sc.nextLine();
    		rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.size_info like '%"+cn+"%';" );
    		display(rs, type);
		}
        else if( sn == 2 ){//�Ǹż���
    		System.out.print("�Ǹż� : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery("SELECT productlist.*, sellerlist.*,  monitorlist.*, count(orderlist.product_id) as num"
					+ " FROM (orderlist " 
					+ " INNER JOIN productlist ON orderlist.product_id = productlist.product_id "
					+ " INNER JOIN sellerlist ON productlist.seller_no = sellerlist.seller_no" 
					+ "	INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id ) group by orderlist.product_id order by num desc;");
			display(rs,type); 
        }
        else if( sn == 3 ){//��ũ�� �ػ�
    		System.out.print("��ũ�� �ػ� : ");
			String cn = sc.nextLine();
			rs = stmt.executeQuery(sql_option	+ "INNER JOIN monitorlist ON productlist.product_id = monitorlist.product_id where monitorlist.resolution like '%"+cn+"%';" );
			display(rs,type); 
        }
        else if( sn == 4 ){//�ǳ� Ÿ��
    		System.out.print("�ǳ� Ÿ�� : ");
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
		if( rs == null ) System.out.println("�ش�  ������ ã�� �� �����ϴ�.");
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
