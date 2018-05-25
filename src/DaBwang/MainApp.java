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
		// TODO Auto-generated method stub                                    // null로 초기화 한다.
		String url = "jdbc:mysql://127.0.0.1:3306/linux?useSSL=false&serverTimezone=UTC";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "root";                                                    // 사용자 계정
		String pw = "passwoard";
		try{                                                // 사용자 계정의 패스워드
			Class.forName("com.mysql.cj.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
			con = DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
			System.out.println("제대로 연결되었습니다.");
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
