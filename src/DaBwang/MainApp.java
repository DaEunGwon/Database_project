package DaBwang;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;

public class MainApp extends JFrame{
	public static Connection con = null;
	public static void main(String[] args) {
		ResultSet rs = null;
		Statement stmt = null;
		int searchKeyword = 0; //
		// TODO Auto-generated method stub                                    // null�� �ʱ�ȭ �Ѵ�.
		String url = "jdbc:mysql://127.0.0.1:3306/linux?useSSL=false&serverTimezone=UTC";        // ����Ϸ��� �����ͺ��̽����� ������ URL ���
		String id = "root";                                                    // ����� ����
		String pw = "passwoard";
		try{                                                // ����� ������ �н�����
			Class.forName("com.mysql.cj.jdbc.Driver");                       // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.
			con = DriverManager.getConnection(url,id,pw);              // DriverManager ��ü�κ��� Connection ��ü�� ���´�.
			System.out.println("����� ����Ǿ����ϴ�.");
			Scanner sc = new Scanner(System.in);
			//LaptopPanel.setingNameL(con);
			MainFrame mf = new MainFrame();

		} catch(SQLException se) {
			se.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
