package DaBwang;
import java.awt.CardLayout;
import java.sql.SQLException;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private int W = 600;
	private int H = 600;
	
	private static CardLayout cards  = new CardLayout();; 
	
	private	LoginPanel lp; 
	private SellerRegisterPanel srp; 
	private SellerOrBuyer sb;
	private BuyerRegisterPanel brp;
	private BuyerSelectProduct bsp;
	private LaptopPanel lapp;
	private MousePanel mp;
	private MonitorPanel mop;
	private ProductInfo pi;
	private OrderPanel op;
	private MyPagePanel mpp;
	private ModifyInfo mfi;
	private OrderListPanel olp;
	private CommentPanel cp;
	private SellerMyPage smp;
	private SellerModifi smf;
	private ProductRegistration pr;
	private SellerRegLaptop srlt;
	private SellerRegMonitor srm;
	private SellerRegMouse srmouse;
	private SellerRegKeyboard srk;
	private SellerMyProduct smyproduct;
	private ProductAccept pa;
	private KeyboardPanel kp;
	private BuyerComment bc;
	private BuyerReview br;
	
	public MainFrame() throws SQLException {
		setSize(W,H);
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		lp = new LoginPanel() ;
		srp = new SellerRegisterPanel();
		sb = new SellerOrBuyer();
		brp = new BuyerRegisterPanel();
		bsp = new BuyerSelectProduct();
		lapp = new LaptopPanel();
		mp = new MousePanel();
		mop = new MonitorPanel();
		pi = new ProductInfo();
		op = new OrderPanel();
		mpp = new MyPagePanel();
		mfi = new ModifyInfo();
		olp = new OrderListPanel();
		cp = new CommentPanel();
		smp = new SellerMyPage();
		smf =new SellerModifi();
		pr = new ProductRegistration();
		srlt = new SellerRegLaptop();
		srm = new SellerRegMonitor();
		srmouse = new SellerRegMouse();
		srk = new SellerRegKeyboard();
		smyproduct = new SellerMyProduct();
		pa = new ProductAccept();
		kp = new KeyboardPanel();
		bc = new BuyerComment();
		br = new BuyerReview();
		
		getContentPane().add("Login",lp);
		getContentPane().add("SellerRegister", srp);
		getContentPane().add("SellerOrBuyer", sb);
		getContentPane().add("BuyerRegister", brp);
		getContentPane().add("BuyerSelectProduct", bsp);
		getContentPane().add("Laptop", lapp);
		getContentPane().add("Mouse", mp);
		getContentPane().add("Monitor",mop);
		getContentPane().add("ProductInfo", pi);
		getContentPane().add("Order", op);
		getContentPane().add("MyPage", mpp);
		getContentPane().add("ModifyInfo", mfi);
		getContentPane().add("OrderList", olp);
		getContentPane().add("Comment", cp);
		getContentPane().add("SellerMyPage", smp);
		getContentPane().add("SellerModifi", smf);
		getContentPane().add("ProductRegistration", pr);
		getContentPane().add("SellerRegLaptop", srlt);
		getContentPane().add("SellerRegMonitor", srm);
		getContentPane().add("SellerRegMouse", srmouse);
		getContentPane().add("SellerRegKeyboard", srk);
		getContentPane().add("SellerMyProduct", smyproduct);
		getContentPane().add("ProductAccept", pa);
		getContentPane().add("Keyboard", kp);
		getContentPane().add("BuyerComment", bc);
		getContentPane().add("BuyerReview", br);
		
		setVisible(true);
	}
	public void changePanel(String name) {
		if(name == "Register")
			cards.show(this.getContentPane(), "SellerOrBuyer"); 
		else if (name == "Seller")
			cards.show(this.getContentPane(), "SellerRegister");
		else if(name == "Buyer")
			cards.show(this.getContentPane(), "BuyerRegister");
		else if(name == "complete_reg")
			cards.show(this.getContentPane(), "Login");
		else if(name == "Login")
			cards.show(this.getContentPane(), "BuyerSelectProduct");
		else if (name == "laptop") 
			cards.show(this.getContentPane(), "Laptop");
		else if(name == "mouse")
			cards.show(this.getContentPane(), "Mouse");
		else if(name == "monitor")
			cards.show(this.getContentPane(), "Monitor");
		else if (name == "enter")
			cards.show(this.getContentPane(), "ProductInfo");
		else if (name == "buy")
			cards.show(this.getContentPane(), "Order");
		else if(name == "MyPage")
			cards.show(this.getContentPane(), "MyPage");
		else if (name == "Modification")
			cards.show(this.getContentPane(), "ModifyInfo");
		else if (name == "OrderInfo")
			cards.show(this.getContentPane(), "OrderList");
		else if(name == "Comment")
			cards.show(this.getContentPane(), "Comment");
		else if(name == "Temp")
			cards.show(this.getContentPane(), "SellerMyPage");
		else if(name == "SellerModification")
			cards.show(this.getContentPane(), "SellerModifi");
		else if(name == "Product Registration")
			cards.show(this.getContentPane(), "ProductRegistration");
		else if(name == "Sellerlaptop")
			cards.show(this.getContentPane(), "SellerRegLaptop");
		else if (name == "SellerMonitor")
			cards.show(this.getContentPane(), "SellerRegMonitor");
		else if ( name == "SellerMouse")
			cards.show(this.getContentPane(), "SellerRegMouse");
		else if(name == "SellerKeyboard")
			cards.show(this.getContentPane(), "SellerRegKeyboard");
		else if(name == "MyProduct")
			cards.show(this.getContentPane(), "SellerMyProduct");
		else if(name == "Accept")
			cards.show(this.getContentPane(), "ProductAccept");
		else if(name == "Keyboard")
			cards.show(this.getContentPane(), "Keyboard");
		else if(name == "BuyerComment")
			cards.show(this.getContentPane(), "BuyerComment");
		else if(name == "BuyerReview")
			cards.show(this.getContentPane(), "BuyerReview");
			
	}
}
