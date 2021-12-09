package university.jFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ReturnData {

	JPanel m1;
	Statement stmt;
	Connection conn;
	
	public void connection(){//连接数据库
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8","root","root");
			stmt = conn.createStatement();
			
		}catch(ClassNotFoundException e1){
			System.out.println("驱动装载失败！");
		}catch(SQLException e2){
			e2.getSQLState();
			e2.getMessage();
		}
	}
	public void close(){//断开数据库
		try{
			if(stmt!=null)
				stmt.close();
			conn.close();
		}catch(SQLException e2){
			System.out.println("不能正常关闭");
		}
	}
			//商品页面
	public Component FindGoods(String name){
		m1 = new JPanel(new BorderLayout());
		try{
			connection();
			String sql = "SELECT * From 商品总表 where 商品 = '"+name+"'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.last();
			rs.beforeFirst();
			Object r1[][];
			r1 = new Object[1][10];
			Object s1[] = {"编号","商品","厂商","类别","进价","数量","售价","进货时间","总进价"};
			JTable tb1 = new JTable(r1,s1);
			if(rs.next()){
				r1[0][0] = rs.getString(1);
				r1[0][1] = rs.getString(2);
				r1[0][2] = rs.getString(3);
				r1[0][3] = rs.getString(4);
				r1[0][4] = rs.getString(5);
				r1[0][5] = rs.getString(6);
				r1[0][6] = rs.getString(7);
				r1[0][7] = rs.getString(8);
				r1[0][8] = rs.getString(9);
			}
			else{
				JOptionPane.showMessageDialog(null,"该商品不存在");
			}
			JScrollPane spane1 = new JScrollPane(tb1);
			m1.add(spane1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		close();
		return m1;
	}
	public void AddGoods(String goods,String num1){
		try {//新进商品数量
			int num = Integer.valueOf(num1), num2, num3;
			String str1 = null;
			connection();
			String sql = "SELECT * From 商品总表  where 商品='" + goods + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				str1 = rs.getString(6);
			}
			num2 = Integer.valueOf(str1);
			num3 = num + num2;
			str1 = Integer.toString(num3);
			String updateSQL = "update 商品总表  set 数量=?" + "where 商品='" + goods + "' ";
			PreparedStatement stmt;
			stmt = conn.prepareStatement(updateSQL);
			stmt.setString(1, str1);
			JOptionPane.showMessageDialog(null,"修改成功！");
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  close();
	}
	public void NewGoods(String str2,String str3,String str4,String str5,String str6,String str7,String str1){
		    String s;
		    int num1;
			double num4,num2;
		    Time t=new Time();
			String str8=t.TimeTest2();//时间
			num4 = Double.valueOf(str5);
			num1=Integer.valueOf(str6);
			num2=num1*num4;
			s=Double.toString(num2);//总价
			
	  		try{
				connection();
				String InsSQL;
				InsSQL = "INSERT INTO 商品总表  (编号,商品,厂商,类别,进价,数量,售价,进货时间,总进价) "+" VALUES ("+"'"+str1+"',"+"'"+str2+"',"
						+ ""+"'"+str3+"',"+"'"+str4+"',"+"'"+str5+"',"+"'"+str6+"',"+"'"+str7+"',"+"'"+str8+"',"+"'"+s+"')";
				stmt.execute(InsSQL);// 执行将新记录插入到数据表student中；
				JOptionPane.showMessageDialog(null, "添加商品成功");
			} 
	  		 catch (SQLException e1) {
				e1.getMessage();
				System.err.println(e1.getSQLState());
				e1.printStackTrace();
			} 
	  		finally {
				close();
	  		}
	}
			//VIP页面
	Component SeeVIP(){
		JPanel panel1 = new JPanel(new BorderLayout());
		try {
			connection();
			String sql="select * from vip信息表";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][100];
			Object s1[] = { "账号","密码", "姓名", "性别", "住址", "电话",  "注册时间","折扣"};
			JTable tb1 = new JTable(r1, s1);
			for (int i = 0; i < k && rs.next(); i++) {
				r1[i][0] = rs.getString(1);
				r1[i][1] = rs.getString(2);
				r1[i][2] = rs.getString(3);
				r1[i][3] = rs.getString(4);
				r1[i][4] = rs.getString(5);
				r1[i][5] = rs.getString(6);
				r1[i][7] = rs.getString(7);
				r1[i][6] = rs.getString(8);
			}
			JScrollPane spane1=new JScrollPane(tb1);
			panel1.add(spane1,BorderLayout.CENTER);
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
			return panel1;
	}
	Component WhatToBuy(){
		JPanel panel1 = new JPanel(new BorderLayout());
		try {
			connection();
			String sql="select * from vip购物记录表";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][20];
			Object s1[] = { "日期","账号", "姓名", "商品", "厂商", "单价", "折扣", "实价", "总量", "节省"};
			JTable tb1 = new JTable(r1, s1);
			if(k!=0){
			for (int i = 0; i < k && rs.next(); i++) {
				r1[i][0] = rs.getString(1);
				r1[i][1] = rs.getString(2);
				r1[i][2] = rs.getString(3);
				r1[i][3] = rs.getString(4);
				r1[i][4] = rs.getString(5);
				r1[i][5] = rs.getString(6);
				r1[i][7] = rs.getString(7);
				r1[i][8] = rs.getString(8);
				r1[i][9] = rs.getString(9);
				r1[i][10] = rs.getString(10);
			}
			JScrollPane spane1=new JScrollPane(tb1);
			panel1.add(spane1,BorderLayout.CENTER);
			rs.close();
			stmt.close();
			conn.close();
			}
			else{
				JOptionPane.showMessageDialog(null,"购物记录为空");
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
			return panel1;
	}
	public void NewVIP(String str2,String str3,String str4,String str5,String str6,String str7,String str1){
		Time t=new Time();
		String str8=t.TimeTest2();
		try{
			connection();
			String InsSQL;
			InsSQL = "INSERT INTO vip信息表   (帐号,密码,姓名,性别,住址,电话,折扣,注册时间) "+" VALUES ("+"'"+str1+"',"+"'"+str2+"',"+"'"+str3+"',"+"'"+str4+"',"+"'"+str5+"',"+"'"+str6+"',"+"'"+str7+"',"+"'"+str8+"')";
			stmt.execute(InsSQL);// 执行将新记录插入到数据表student中；
			JOptionPane.showMessageDialog(null, "注册成功,可进入浏览VIP页面查看！");
			stmt.close();
			conn.close();
		} catch (SQLException e1) {
			e1.getMessage();
			System.err.println(e1.getSQLState());
			e1.printStackTrace();
		}
	}
	public  Component FindVIP(String num2){
		int r = 0;
		Object r1[][];
		r1=new Object[1][10];
		try {
			connection();
			String sql="SELECT * From vip信息表   where 帐号='"+num2+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				r=1;
				r1[0][0] = rs.getString(1);
				r1[0][2] = rs.getString(2);
				r1[0][2] = rs.getString(3);
				r1[0][3] = rs.getString(4);
				r1[0][4] = rs.getString(5);
				r1[0][5] = rs.getString(6);
				r1[0][6] = rs.getString(7);
				r1[0][7] = rs.getString(8);
			}
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {if(r==1){
			Object s1[] = { "账号","密码", "姓名", "性别", "住址", "电话",  "注册时间","折扣"};
			JTable tb1 = new JTable(r1, s1);
			JScrollPane spane1 = new JScrollPane(tb1);
			JPanel spa = new JPanel(new BorderLayout());
			spa.add(spane1,BorderLayout.CENTER);
			return spa;
		}else{
			JPanel spb = new JPanel();
			JLabel txt = new JLabel("您查询的用户不存在！");
			spb.add(txt);
			return spb;
		}
		}
	}

	public  Component SetVIP(final String num3){
		JPanel c4 = new JPanel();
		 c4.setLayout(new BorderLayout());
		 JPanel zhu1 = new JPanel();
		 zhu1.add(new JLabel("修改VIP"));
		 JPanel zhu2 = new JPanel();
		 JPanel zhu3 = new JPanel(new GridLayout(6,2,3,3));
		 final JTextField t1 = new JTextField();
		final JTextField t2 = new JTextField();
		 final JTextField t3 = new JTextField();
		final JTextField t4 = new JTextField();
		 final JTextField t5 = new JTextField();
		final JTextField t6 = new JTextField();
		 zhu3.add(new JLabel("修改密码"));zhu3.add(t1);
		 zhu3.add(new JLabel("修改姓名"));zhu3.add(t2);
		 zhu3.add(new JLabel("修改性别"));zhu3.add(t3);
		 zhu3.add(new JLabel("修改住址"));zhu3.add(t4);
		 zhu3.add(new JLabel("修改电话"));zhu3.add(t5);
		 zhu3.add(new JLabel("修改折扣"));zhu3.add(t6);
		 zhu2.add(zhu3);
		 c4.add(zhu1,BorderLayout.NORTH);
		 c4.add(zhu2);JButton Fin = new JButton("完成");
		 c4.add(Fin,BorderLayout.SOUTH);
		 Fin.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
		try {
			
			connection();
			String updateSQL="update vip信息表  set 密码=?,"+"姓名=?," +"性别=?," +"住址=?," +"电话=?," +"折扣=?"+"where 帐号='"+num3+"' ";
			PreparedStatement stmt;
			stmt=conn.prepareStatement(updateSQL);
			stmt.setString(1, t1.getText());
			stmt.setString(2, t2.getText());
			stmt.setString(3, t3.getText());
			stmt.setString(4, t4.getText());
			stmt.setString(5, t5.getText());
			stmt.setString(6, t6.getText());
			stmt.execute();
			JOptionPane.showMessageDialog(null,"修改成功");
  			stmt.close();
  			stmt.close();
  			conn.close();
		} catch (SQLException i) {
			// TODO 自动生成的 catch 块
			i.printStackTrace();
		}
			 }}
				 );
		 return c4;
	}

	public void DelVIP(String num4){
		String delStr="delete from vip信息表  where 帐号='"+num4+"'";
		try{
 			connection();
 			stmt.execute(delStr);
 			JOptionPane.showMessageDialog(null,"删除成功!");
		}catch(SQLException e1){
  			System.err.println("删除失败！");
  			System.err.println(e1.getSQLState()+e1.getMessage());
		}
	}

			//人事管理页面
	public Component SeeWorker(){
		JPanel panel1 = new JPanel(new BorderLayout());
		try {
			connection();
			String sql="select * from 人事信息总表";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][20];
			Object s1[] = { "工号","姓名", "性别", "年龄", "部门", "职务", "电话", "月薪", "住址", "状态", "注册时间"};
			JTable tb1 = new JTable(r1, s1);
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
				r1[i][10] = rs.getString(11);
			}
			JScrollPane spane1=new JScrollPane(tb1);
			panel1.add(spane1,BorderLayout.CENTER);
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.getMessage();
			e.printStackTrace();
		}
			return panel1;

	    }
	public Component FindWorker(String num5){
		int r = 0;
		Object r1[][];
		r1=new Object[1][12];
		try {
			connection();
			String sql="SELECT * From 人事信息总表   where 工号='"+num5+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				r=1;
				r1[0][0] = rs.getString(1);
				r1[0][1] = rs.getString(2);
				r1[0][2] = rs.getString(3);
				r1[0][3] = rs.getString(4);
				r1[0][4] = rs.getString(5);
				r1[0][5] = rs.getString(6);
				r1[0][6] = rs.getString(7);
				r1[0][7] = rs.getString(8);
				r1[0][8] = rs.getString(9);
				r1[0][9] = rs.getString(10);
				r1[0][10] = rs.getString(11);
			}
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {if(r==1){
			Object s1[] = { "工号", "姓名", "性别", "年龄","部门","职务","电话","月薪","住址","状态","注册时间"};
			JTable tb1 = new JTable(r1, s1);
			JScrollPane spane1 = new JScrollPane(tb1);
			JPanel spa = new JPanel(new BorderLayout());
			spa.add(spane1,BorderLayout.CENTER);
			return spa;
		}else{
			JPanel spb = new JPanel();
			JLabel txt = new JLabel("您查询的员工不存在！");
			spb.add(txt);
			return spb;
		}
		}
	}
	public void NewWorker(String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9,String str10){
		Time t=new Time();
		String str11=t.TimeTest2();
		try{
			connection();
			String InsSQL;
			InsSQL = "INSERT INTO 人事信息总表   (工号,姓名,电话,性别,年龄,部门,职务,月薪,状态,住址,注册时间) "+" VALUES ("+"'"+str1+"',"+"'"+str2+"',"+"'"+str3+"',"+"'"+str4+"',"+"'"+str5+"',"+"'"+str6+"',"+"'"+str7+"',"+"'"+str8+"',"+"'"+str9+"',"+"'"+str10+"',"+"'"+str11+"')";
			stmt.execute(InsSQL);// 执行将新记录插入到数据表student中；
			JOptionPane.showMessageDialog(null, "注册成功,可进入浏览员工页面查看！");
			stmt.close();
			conn.close();
		} catch (SQLException e1) {
			e1.getMessage();
			System.err.println(e1.getSQLState());
			e1.printStackTrace();
		}
	}
	
	public  Component SetWorker(final String num6){
		JPanel c4 = new JPanel();
		 c4.setLayout(new BorderLayout());
		 JPanel zhu1 = new JPanel();
		 zhu1.add(new JLabel("修改员工"));
		 JPanel zhu2 = new JPanel();
		 JPanel zhu3 = new JPanel(new GridLayout(9,2,3,3));
		 final JTextField t1 = new JTextField();
		 final JTextField t2 = new JTextField();
		final JTextField t3 = new JTextField();
		 final JTextField t4 = new JTextField();
		final JTextField t5 = new JTextField();
		 final JTextField t6 = new JTextField();
		final JTextField t7 = new JTextField();
		 final JTextField t8 = new JTextField();
		final JTextField t9 = new JTextField();
		 zhu3.add(new JLabel("修改姓名"));zhu3.add(t1);
		 zhu3.add(new JLabel("修改性别"));zhu3.add(t2);
		 zhu3.add(new JLabel("修改年龄"));zhu3.add(t3);
		 zhu3.add(new JLabel("修改部门"));zhu3.add(t4);
		 zhu3.add(new JLabel("修改职务"));zhu3.add(t5);
		 zhu3.add(new JLabel("修改电话"));zhu3.add(t6);
		 zhu3.add(new JLabel("修改月薪"));zhu3.add(t7);
		 zhu3.add(new JLabel("修改住址"));zhu3.add(t8);
		 zhu3.add(new JLabel("修改状态"));zhu3.add(t9);
		 zhu2.add(zhu3);
		 c4.add(zhu1,BorderLayout.NORTH);
		 c4.add(zhu2);JButton Fin = new JButton("完成");
		 c4.add(Fin,BorderLayout.SOUTH);
		 Fin.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
		try {
			connection();
			String updateSQL="update 人事信息总表  set 姓名=?,"+"性别=?,"+"年龄=?,"+"部门=?,"+"职务=?,"+"电话=?,"+"月薪=?,"+"住址=?,"+"状态=?"+"where 工号='"+num6+"'";
			PreparedStatement stmt;
			stmt=conn.prepareStatement(updateSQL);
			stmt.setString(1, t1.getText());
			stmt.setString(2, t2.getText());
			stmt.setString(3, t3.getText());
			stmt.setString(4, t4.getText());
			stmt.setString(5, t5.getText());
			stmt.setString(6, t6.getText());
			stmt.setString(7, t7.getText());
			stmt.setString(8, t8.getText());
			stmt.setString(9, t9.getText());
			stmt.execute();
			JOptionPane.showMessageDialog(null,"修改成功！可返回浏览页面查看~");
 			stmt.close();
 			stmt.close();
 			conn.close();
		} catch (SQLException i) {
			// TODO 自动生成的 catch 块
			i.printStackTrace();
		}
			 }}
				 );
		 return c4;
	}
	public  Component LookWorker(String num2){
		int r = 0;
		Object r1[][];
		r1=new Object[1][11];
		try {
			connection();
			String sql="SELECT * From 人事信息总表   where 工号='"+num2+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				r=1;
				r1[0][0] = rs.getString(1);
				r1[0][1] = rs.getString(2);
				r1[0][2] = rs.getString(3);
				r1[0][3] = rs.getString(4);
				r1[0][4] = rs.getString(5);
				r1[0][5] = rs.getString(6);
				r1[0][6] = rs.getString(7);
				r1[0][7] = rs.getString(8);
				r1[0][8] = rs.getString(9);
				r1[0][9] = rs.getString(10);
				r1[0][10] = rs.getString(11);
			}
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {if(r==1){
			Object s1[] = {"工号","姓名", "性别","年龄","部门","职务", "电话",  "月薪", "住址", "状态", "注册时间"};
			JTable tb1 = new JTable(r1, s1);
			JScrollPane spane1 = new JScrollPane(tb1);
			JPanel spa = new JPanel(new BorderLayout());
			spa.add(spane1,BorderLayout.CENTER);
			return spa;
		}else{
			JPanel spb = new JPanel();
			JLabel txt = new JLabel("您查询的员工不存在！");
			spb.add(txt);
			return spb;
		}
		}
	}
	public void DelWorker(String num4){
		String delStr="delete from 人事信息总表  where 工号='"+num4+"'";
		try{
 			connection();
 			stmt.execute(delStr);
 			JOptionPane.showMessageDialog(null,"删除成功!");
		}catch(SQLException e1){
  			System.err.println("删除失败！");
  			System.err.println(e1.getSQLState()+e1.getMessage());
		}
	}
	
	Component SeeMoney(){
	JPanel panel1 = new JPanel(new BorderLayout());
	try {
		connection();
		String sql="select * from 利润表";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		rs.last();
		int k=rs.getRow();
		rs.beforeFirst();
		Object r1[][];
		r1=new Object[k][100];
		Object s1[] = { "总金额","总售额", "标记"};
		JTable tb1 = new JTable(r1, s1);
		for (int i = 0; i < k && rs.next(); i++) {
			r1[i][0] = rs.getString(1);
			r1[i][1] = rs.getString(2);
			r1[i][2] = rs.getString(3);
		}
		JScrollPane spane1=new JScrollPane(tb1);
		panel1.add(spane1,BorderLayout.CENTER);
		rs.close();
		stmt.close();
		conn.close();
	} catch (SQLException e) {
		e.getMessage();
		e.printStackTrace();
	}
		return panel1;
	}
}





