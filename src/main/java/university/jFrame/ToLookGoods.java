package university.jFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ToLookGoods implements ActionListener{

	public ToLookGoods() {
		// TODO 自动生成的构造函数存根
	}
	Connection conn;//定义连接接口对象conn
	Statement stmt;//定义执行语句接口对象stmt
	public void connection(){//连接数据库;
		try{
  			Class.forName("com.mysql.jdbc.Driver");//装载驱动程序
			//ODBC数据源studentManage
  			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8","root","root");
  			stmt=conn.createStatement();//获得执行语句对象stmt
		}catch(ClassNotFoundException e1){
  			System.err.println("驱动程序装载失败！");
		}catch(SQLException e2){
  			e2.getSQLState();
  			e2.getMessage();
		}
	}
	JLabel l1=new JLabel("请输入你要查询的日期");
	JTextField t1=new JTextField("格式为：yyyy-mm-dd",15);
	JButton b1=new JButton("查询");
	Component p41() {
		JPanel p41=new JPanel();
		JPanel p47=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p41.setBackground(new Color(173, 216, 230));
		p47.add(l1);
		JPanel p48=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p48.add(t1);
		p48.add(b1);
		p41.add(p47);
		p41.add(p48);
		b1.addActionListener(this);
		p41.setSize(500, 60);
		p41.setLocation(0, 30);
		
		
		return p41;
		
	}
	JLabel l2=new JLabel("请输入你要查询的时段：");
	JLabel l3=new JLabel("起始时间：");
	JLabel l4=new JLabel("结束时间：");
	JTextField t2=new JTextField("格式为：yyyy-mm-dd",12);
	JTextField t3=new JTextField("格式为：yyyy-mm-dd",12);
	JButton b2=new JButton("查询");
	
	Component p42() {
		JPanel p41=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p41.setBackground(new Color(173, 216, 230));
		l2.setFont(new Font("宋体", Font.PLAIN, 22));
		p41.add(l2);
		p41.add(l3);
		p41.add(t2);
		p41.add(l4);
		p41.add(t3);
		p41.add(b2);
		b2.addActionListener(this);

		p41.setSize(250, 200);
		p41.setLocation(200, 30);
		
		
		return p41;
		
	}
	//单日查询
	Component j41(String time) {
		JPanel panel1 = new JPanel(new BorderLayout());
		JFrame j1=new JFrame();
		try {
			connection();
			String sql="select * from 日售货总表  where 日期 ='"+time+"'";
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][20];
			Object s1[] = { "日期","账号", "姓名", "商品编号","商品","厂商","单价","折扣","实价","数量"};
			JTable tb1 = new JTable(r1, s1);
			if (k != 0) {
				for (int i = 0; i < k && rs.next(); i++) {
					r1[i][0] = rs.getString(1);
					r1[i][1] = rs.getString(2);
					r1[i][2] = rs.getString(3);
					r1[i][3] = rs.getString(4);
					r1[i][4] = rs.getString(5);
					r1[i][5] = rs.getString(6);
					r1[i][6] = rs.getString(7);
					r1[i][7] = rs.getString(8);
					r1[i][8] = rs.getString(9);
					r1[i][9] = rs.getString(10);
				}
				JScrollPane spane1 = new JScrollPane(tb1);
				panel1.add(spane1, BorderLayout.CENTER);
				panel1.setSize(700, 400);
				panel1.setLocation(20, 30);
				rs.close();
				stmt.close();
				conn.close();
				j1.setSize(700,800);
				j1.setLocation(300, 300);
				j1.getContentPane().add(panel1);
				j1.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null,"本日沒有商品售出");
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.getMessage();
			e.printStackTrace();
		}
		// TODO 自动生成的构造函数存根
			return j1;
	}
	//时段查询
	Component j42(String time1,String time2) {
		JPanel panel1 = new JPanel(new BorderLayout());
		JFrame j2=new JFrame();
		try {
			connection();
			String sql="select * from 收支详表  where 日期>='"+time1+"' and 日期<='"+time2+"'";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][20];
			Object s1[] = { "日期","进货总额", "售货总额", "记号"};
			JTable tb1 = new JTable(r1, s1);
			if (k != 0) {
				for (int i = 0; i < k && rs.next(); i++) {
					r1[i][0] = rs.getString(1);
					r1[i][1] = rs.getString(2);
					r1[i][2] = rs.getString(3);
					r1[i][3] = rs.getString(4);
				}
				JScrollPane spane1 = new JScrollPane(tb1);
				panel1.add(spane1, BorderLayout.CENTER);
				panel1.setSize(700, 400);
				panel1.setLocation(20, 30);
				rs.close();
				stmt.close();
				conn.close();
				j2.getContentPane().add(panel1);
				j2.setSize(700,500);
				j2.setLocation(300, 300);
				j2.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null,"这段时间里沒有商品售出！");
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.getMessage();
			e.printStackTrace();
		}
		// TODO 自动生成的构造函数存根
			return j2;
	}
	//浏览全部

	Component j43() {
		JPanel panel1 = new JPanel(new BorderLayout());
		JFrame j2=new JFrame();
		try {
			connection();
			String sql="select * from 收支详表";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][20];
			Object s1[] = { "日期","进货总额", "售货总额", "记号"};
			JTable tb1 = new JTable(r1, s1);
			for (int i = 0; i < k && rs.next(); i++) {
				r1[i][0] = rs.getString(1);
				r1[i][1] = rs.getString(2);
				r1[i][2] = rs.getString(3);
				r1[i][3] = rs.getString(4);
				

			}
			JScrollPane spane1=new JScrollPane(tb1);
			panel1.add(spane1,BorderLayout.CENTER);
			j2.getContentPane().add(panel1);
			panel1.setSize(600, 400);
			panel1.setLocation(20, 30);
			rs.close();
			stmt.close();
			conn.close();
			j2.getContentPane().add(panel1);
			j2.setSize(700,500);
			j2.setLocation(300, 300);
			j2.setVisible(true);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.getMessage();
			e.printStackTrace();
		}
		
			
		// TODO 自动生成的构造函数存根
			return j2;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			j41(t1.getText());
			
		}
		if(e.getSource()==b2){
			j42(t2.getText(),t3.getText());
		}
		// TODO 自动生成的方法存根
		
	}

}
