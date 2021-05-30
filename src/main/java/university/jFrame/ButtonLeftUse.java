package university.jFrame;


import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public  class  ButtonLeftUse extends ReturnData implements ActionListener {

	JPanel c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,liu1;
	Object data[][];
	Object colname[] = {"编号","商品","厂商","类别","进价","数量","售价","进货时间","总进价"};
	JTable liulan;
	String name,goods,num1,str2,str3,str4,str5,str6,str7,str1,str8,str9,str10;
	
	
	JLabel[] L = {new JLabel("请输入您要查询的物品名称：") ,new JLabel("请输入商品名称："),new JLabel("请输入商品数量"),
			new JLabel("请输入您要查询VIP的账号："),new JLabel("请输入您要注销的VIP的账号："),new JLabel("请输入您要查询员工的工号："),
			new JLabel("请输入您要修改员工的工号："),new JLabel("请输入您要注销的员工的工号："),new JLabel("请输入密码："),
			new JLabel("请您确认密码："),new JLabel("商场新增商品"),new JLabel("注册VIP用户"),
			new JLabel("注册新员工"),new JLabel("管理员个人详情")};
	
	JTextField[] T = {new JTextField("",25),new JTextField("",15),new JTextField("",10),//0-2
			new JTextField("",5),new JTextField("",25),new JTextField("",25),//3-5
			new JTextField("",25),new JTextField("",25),new JTextField("",25),//6-8
			new JTextField("",25),new JTextField("",25),new JTextField("",25),//9-11
			new JTextField("",25),new JTextField("",25),new JTextField("",25),//12-14
			new JTextField("",25),new JTextField("",25),new JTextField("",25),//15-17
			new JTextField("",25),new JTextField("",25),new JTextField("",25),//18-20
	        new JTextField("",25),new JTextField("",25),new JTextField("",25),//21-23
	        new JTextField("",25),new JTextField("",25),new JTextField("",25),//24-26
	        new JTextField("",25),new JTextField("",25),new JTextField("",25),//27-29
	        new JTextField("",25),new JTextField("",25),new JTextField("",25),//30-32
	        new JTextField("",25),new JTextField("",25),new JTextField("",25)};//33-35
	
	JButton[] B = {new JButton("查询"),new JButton("取消"),new JButton("确定"),//0-2
			new JButton("退出"),new JButton("确认新增"),new JButton("注册VIP"),//3-5
			new JButton("退出"),new JButton("查询"),new JButton("修改"),//6-8
			new JButton("进入"),new JButton("进入"),new JButton("退出"),//9-11
			new JButton("注册员工"),new JButton("查询"),new JButton("修改"),//12-14
			new JButton("进入"),new JButton("退出"),new JButton("修改密码")};//15-17
	
	JTextField[] F ={new JTextField("编号",4),new JTextField("商品",4),new JTextField("厂商",4),//0-2
			new JTextField("类别",4),new JTextField("进价",4),new JTextField("数量",4),//3-5
			new JTextField("售价",4),new JTextField("账号",4),new JTextField("密码",4),//6-8
			new JTextField("姓名",4),new JTextField("性别",4),new JTextField("住址",4),//9-11
			new JTextField("电话",4),new JTextField("折扣",4),new JTextField("工号",4),//12-14
			new JTextField("性别",4),new JTextField("部门",4),new JTextField("月薪",4),//15-17
			new JTextField("电话",4),new JTextField("状态",4),new JTextField("职务",4),//18-20
			new JTextField("年龄",4),new JTextField("注册时间",4)};
	//构造方法
	public ButtonLeftUse(){
		//设置字体颜色、方框
		for(int i = 0;i<13;i++){
			L[i].setFont(new Font("宋体", Font.BOLD,20));
			L[i].setForeground(Color.BLACK);
			L[i].setBorder(BorderFactory.createLineBorder(Color.PINK, 3));
		}
		for(int i = 10;i<14;i++){
			L[i].setFont(new Font("宋体", Font.BOLD, 10));
			L[i].setBorder(BorderFactory.createLineBorder(Color.PINK, 3));
		}
		for(int i = 0;i<23;i++){
			F[i].setEditable(false);
			F[i].setForeground(Color.BLACK);
			F[i].setFont(new Font("宋体", Font.BOLD,26));
		}
	}
	
	//第一块面板的按钮方法
	public Component liulan(){
		liu1 = new JPanel(new BorderLayout());
		data = new Object[9][9];
		loadData();
		liulan = new JTable(data,colname);
		liu1.add(new JScrollPane(liulan));
		return liu1;
	}
	  private void loadData(){//内部方法
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8","root","123456");
			Statement stmt = conn.createStatement();
			String sql = "select*from 商品总表";
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()){
				data[i][0] = rs.getString(1);
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getString(3);
				data[i][3] = rs.getString(4);
				data[i][4] = rs.getString(5);
				data[i][5] = rs.getString(6);
				data[i][6] = rs.getString(7);
				data[i][7] = rs.getString(8);
				data[i][8] = rs.getString(9);
				i++;
			}
			rs.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	 public Component chaxun(){
		
		c1 = new JPanel();
		GroupLayout layout = new GroupLayout(c1);
  		c1.setLayout(layout);
  		layout.setAutoCreateGaps(true);
  		layout.setAutoCreateContainerGaps(true);
  		GroupLayout.ParallelGroup h1 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
  		h1.addComponent(L[0]);
  		h1.addComponent(T[2]);
   		h1.addComponent(B[0]);
  		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(h1));
  		layout.linkSize(SwingConstants.VERTICAL,new Component[]{L[0],T[2],B[0]});
  		GroupLayout.ParallelGroup v1 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
  		v1.addComponent(L[0]);
  		GroupLayout.ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
  		v2.addComponent(T[2]);
  		GroupLayout.ParallelGroup v3 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
  		v3.addComponent(B[0]);
  		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(v1).addGroup(v2).addGroup(v3));
  		B[0].addActionListener(this);
		return c1;
		
	}  
	 public Component xinjin(){
		 c2 = new JPanel();
		 
		 JPanel a25 = new JPanel(new GridLayout(3,2,5,5));
		 a25.setSize(100,100);
		 a25.add(L[1]);
		 a25.add(T[8]);
		 a25.add(L[2]);
		 a25.add(T[9]);
		 a25.add(B[1]);
		 a25.add(B[2]);
		 c2.add(a25);
		 B[2].addActionListener(this);
		 return c2;
	 }
	 public Component xinzeng(){
		 c3 = new JPanel();
			GroupLayout layout = new GroupLayout(c3);
	  		c3.setLayout(layout);
	  		layout.setAutoCreateGaps(true);
	  		layout.setAutoCreateContainerGaps(true);
	  		GroupLayout.ParallelGroup h1 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
	  		h1.addComponent(F[0]);
	  		h1.addComponent(F[1]);
	  		h1.addComponent(F[2]);
	  		h1.addComponent(F[3]);
	  		h1.addComponent(F[4]);
	  		h1.addComponent(F[5]);
	  		h1.addComponent(F[6]);
	  		h1.addComponent(B[3]);
			GroupLayout.ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			h2.addComponent(L[10]);
			h2.addComponent(T[1]);
			h2.addComponent(T[2]);
			h2.addComponent(T[3]);
			h2.addComponent(T[4]);
			h2.addComponent(T[5]);
			h2.addComponent(T[6]);
			h2.addComponent(T[7]);
			h2.addComponent(B[4]);
	 		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(h1).addGroup(h2));
			GroupLayout.ParallelGroup v1 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v1.addComponent(L[10]);
			GroupLayout.ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v2.addComponent(F[0]);
			v2.addComponent(T[1]);
			GroupLayout.ParallelGroup v3 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v3.addComponent(F[1]);
			v3.addComponent(T[2]);
			GroupLayout.ParallelGroup v4 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v4.addComponent(F[2]);
			v4.addComponent(T[3]);
			GroupLayout.ParallelGroup v5 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v5.addComponent(F[3]);
			v5.addComponent(T[4]);
			GroupLayout.ParallelGroup v6 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v6.addComponent(F[4]);
			v6.addComponent(T[5]);
			GroupLayout.ParallelGroup v7 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v7.addComponent(F[5]);
			v7.addComponent(T[6]);
			GroupLayout.ParallelGroup v8 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v8.addComponent(F[6]);
			v8.addComponent(T[7]);
			GroupLayout.ParallelGroup v9 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
			v9.addComponent(B[3]);
			v9.addComponent(B[4]);
			layout.setVerticalGroup(layout.createSequentialGroup().addGroup(v1).addGroup(v2)
					.addGroup(v3).addGroup(v4).addGroup(v5).addGroup(v6).addGroup(v7).addGroup(v8).addGroup(v9));
			B[3].addActionListener(this);
			B[4].addActionListener(this);
		 return c3;
	 }
	 //第二块面板的按钮方法
	 public Component zhuceVIP(){
		 c4 = new JPanel();
		 c4.setLayout(new BorderLayout());
		 JPanel zhu1 = new JPanel();
		 zhu1.add(L[11]);
		 JPanel zhu2 = new JPanel();
		 JPanel zhu3 = new JPanel(new GridLayout(7,2,3,3));
		 zhu3.add(F[7]);zhu3.add(T[10]);
		 zhu3.add(F[8]);zhu3.add(T[11]);
		 zhu3.add(F[9]);zhu3.add(T[12]);
		 zhu3.add(F[10]);zhu3.add(T[13]);
		 zhu3.add(F[11]);zhu3.add(T[14]);
		 zhu3.add(F[12]);zhu3.add(T[15]);
		 zhu3.add(F[13]);zhu3.add(T[16]);
		 JPanel zhu4 = new JPanel();
		 zhu4.add(B[6]);zhu4.add(B[5]);
		 zhu2.add(zhu3);
		 c4.add(zhu1,BorderLayout.NORTH);
		 c4.add(zhu4,BorderLayout.SOUTH);
		 c4.add(zhu2);
		 B[5].addActionListener(this);
		 return c4;
	 }
	 public Component chakan(){
		 c5 = new JPanel();
		 c5.setLayout(new BorderLayout());
		 JPanel kan1 = new JPanel();
		 kan1.add(L[3]);
		 c5.add(kan1,BorderLayout.NORTH);
		 JPanel kan2 = new JPanel();
		 kan2.add(T[17]);
		 JPanel kan3 = new JPanel(new BorderLayout());
		 kan3.add(kan2);
		 JPanel kan4 = new JPanel();
		 kan4.add(B[7]);kan4.add(B[8]);
		 c5.add(kan1,BorderLayout.NORTH);
		 c5.add(kan3,BorderLayout.CENTER);
		 c5.add(kan4,BorderLayout.SOUTH);
		 B[7].addActionListener(this);
		 B[8].addActionListener(this);
		 return c5;
	 }

	 public Component zhuxiaoVIP(){
		 c6 = new JPanel();
		 c6.setLayout(new BorderLayout());
		 JPanel xiao = new JPanel();
		 xiao.add(L[4]);
		 c6.add(xiao,BorderLayout.NORTH);
		 JPanel xiao2 = new JPanel();
		 xiao2.add(T[18]);
		 JPanel xiao3 = new JPanel(new BorderLayout());
		 xiao3.add(xiao2);
		 JPanel xiao4 = new JPanel();
		 xiao4.add(B[9]);
		 c6.add(xiao3,BorderLayout.CENTER);
		 c6.add(xiao4,BorderLayout.SOUTH);
		 B[9].addActionListener(this);
		 return c6;
	 }
	 
	 //第三块面板按钮  
	 public Component chaxunyuan(){
		 c7 = new JPanel(new GridLayout(3,1,20,0));
		 JPanel cha1 = new JPanel();
		 cha1.add(L[5]);
		 JPanel cha2 = new JPanel();
		 cha2.add(T[19]);
		 JPanel cha3 = new JPanel();
		 cha3.add(B[10]);
		 c7.add(cha1);
		 c7.add(cha2);
		 c7.add(cha3);
		 B[10].addActionListener(this);
		 return c7;
	 }
	 public Component zhuceyuan(){
		 c8 = new JPanel(new BorderLayout());
		 JPanel zhu1 = new JPanel();
		 JPanel zhu2 = new JPanel(new GridLayout(2,2,6,3));
		 JPanel zhu3 = new JPanel(new BorderLayout());
		 JPanel zhu31 = new JPanel(new GridLayout(3,2,3,3));
		 JPanel zhu32 = new JPanel(new GridLayout(3,4,3,3));
		 zhu1.add(L[12]);
		 zhu2.add(F[11]);zhu2.add(T[20]);
		 zhu2.add(B[11]);zhu2.add(B[12]);
		 zhu31.add(F[14]);zhu31.add(T[21]);
		 zhu31.add(F[9]);zhu31.add(T[22]);
		 zhu31.add(F[18]);zhu31.add(T[23]);
		 zhu32.add(F[15]);zhu32.add(T[24]);zhu32.add(F[21]);zhu32.add(T[25]);
		 zhu32.add(F[16]);zhu32.add(T[26]);zhu32.add(F[20]);zhu32.add(T[27]);
		 zhu32.add(F[17]);zhu32.add(T[28]);zhu32.add(F[19]);zhu32.add(T[29]);
		 c8.add(zhu1,BorderLayout.NORTH);
		 c8.add(zhu2,BorderLayout.SOUTH);
		 c8.add(zhu3,BorderLayout.CENTER);
		 zhu3.add(zhu31,BorderLayout.NORTH);
		 zhu3.add(zhu32,BorderLayout.CENTER);
		 B[12].addActionListener(this);
		 return c8;
	 }
	 public Component xiugaiyuan(){
		 c9 = new JPanel(new GridLayout(3,1,20,0));
		 JPanel xiu2 = new JPanel();
		 xiu2.add(L[6]);
		 JPanel xiu3 = new JPanel();
		 xiu3.add(T[30]);
		 JPanel xiu1 = new JPanel();
		 xiu1.add(B[13]);xiu1.add(B[14]);
		 c9.add(xiu2);
		 c9.add(xiu3);
		 c9.add(xiu1);
		 B[13].addActionListener(this);
		 B[14].addActionListener(this);
		 return c9;
	 }
	 public Component zhuxiaoyuan(){
		 c10 = new JPanel(new GridLayout(3,1,20,0));
		 JPanel zhu1 = new JPanel();
		 zhu1.add(L[7]);
		 JPanel zhu2 = new JPanel();
		 zhu2.add(T[31]);
		 JPanel zhu3 = new JPanel();
		 zhu3.add(B[15]);
		 c10.add(zhu1);c10.add(zhu2);c10.add(zhu3);
		 B[15].addActionListener(this);
		 return c10;
	 }
	 
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == B[0]){
			 c1.setVisible(false);
			 c1.removeAll();
			 c1.setLayout(new FlowLayout());
			 name = T[2].getText();
			 c1.add(FindGoods(name));
			 c1.setVisible(true);
		 }
		 if(e.getSource() == B[2]){
			 goods = T[8].getText();
			 num1 = T[9].getText();
			 AddGoods(goods,num1);
		 }
		 if(e.getSource() == B[3]){
			 c3.setVisible(true);
		 }
		 if(e.getSource() == B[4]){
			 str1=T[1].getText();
			 str2=T[2].getText();
			 str3=T[3].getText();
			 str4=T[4].getText();
			 str5=T[5].getText();
			 str6=T[6].getText();
			 str7=T[7].getText();
			 NewGoods(str2,str3,str4,str5,str6,str7,str1);
		 }
		 if(e.getSource() == B[5]){
			 str1=T[10].getText();
			 str2=T[11].getText();
			 str3=T[12].getText();
			 str4=T[13].getText();
			 str5=T[14].getText();
			 str6=T[15].getText();
			 str7=T[16].getText();
			 NewVIP(str2,str3,str4,str5,str6,str7,str1);
		 }
		 if(e.getSource() == B[7]){
			 String num2 = T[17].getText();
			 c5.setVisible(false);
			 c5.removeAll();
			 c5.add(FindVIP(num2));
			 c5.setVisible(true);
		 }
		 if(e.getSource() == B[8]){
			 String num3 = T[17].getText();
			 c5.setVisible(false);
			 c5.removeAll();
			 c5.add(SetVIP(num3));
			 c5.setVisible(true);
		 }
		 if(e.getSource() == B[9]){
			 String num4 = T[18].getText();
			 c6.setVisible(false);
			 c6.removeAll();
			 DelVIP(num4);
			 c6.setVisible(true);
		 }
		 if(e.getSource() == B[10]){
			 String num5 = T[19].getText();
			 c7.setVisible(false);
			 c7.removeAll();
			 c7.add(FindWorker(num5));
			 c7.setVisible(true);
		 }
		 if(e.getSource() == B[12]){
			 str1=T[21].getText();
			 str2=T[22].getText();
			 str3=T[23].getText();
			 str4=T[24].getText();str5=T[25].getText();
			 str6=T[26].getText();str7=T[27].getText();
			 str8=T[28].getText();str9=T[29].getText();
			 str10=T[20].getText();
			 NewWorker(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10);
		 }
		 if(e.getSource() == B[13]){//查询员工
			 String num2 = T[30].getText();
			 c9.setVisible(false);
			 c9.removeAll();
			 c9.add(LookWorker(num2));
			 c9.setVisible(true);
		 }
		 if(e.getSource() == B[14]){
			 String num6 = T[30].getText();
			 c9.setVisible(false);
			 c9.removeAll();
			 c9.setLayout(new BorderLayout());
			 c9.add(SetWorker(num6));
			 c9.setVisible(true);
		 }
		 if(e.getSource() == B[15]){//注销VIP
			 String num4 = T[31].getText();
			 c10.setVisible(false);
			 c10.removeAll();
			 DelWorker(num4);
			 c10.setVisible(true);
		 }
	 }
	 
}









