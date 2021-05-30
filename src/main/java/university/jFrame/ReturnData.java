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
	
	public void connection(){//�������ݿ�
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8","root","root");
			stmt = conn.createStatement();
			
		}catch(ClassNotFoundException e1){
			System.out.println("����װ��ʧ�ܣ�");
		}catch(SQLException e2){
			e2.getSQLState();
			e2.getMessage();
		}
	}
	public void close(){//�Ͽ����ݿ�
		try{
			if(stmt!=null)
				stmt.close();
			conn.close();
		}catch(SQLException e2){
			System.out.println("���������ر�");
		}
	}
			//��Ʒҳ��
	public Component FindGoods(String name){
		m1 = new JPanel(new BorderLayout());
		try{
			connection();
			String sql = "SELECT * From ��Ʒ�ܱ� where ��Ʒ = '"+name+"'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.last();
			rs.beforeFirst();
			Object r1[][];
			r1 = new Object[1][10];
			Object s1[] = {"���","��Ʒ","����","���","����","����","�ۼ�","����ʱ��","�ܽ���"};
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
				JOptionPane.showMessageDialog(null,"����Ʒ������");
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
		try {//�½���Ʒ����
			int num = Integer.valueOf(num1), num2, num3;
			String str1 = null;
			connection();
			String sql = "SELECT * From ��Ʒ�ܱ�  where ��Ʒ='" + goods + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				str1 = rs.getString(6);
			}
			num2 = Integer.valueOf(str1);
			num3 = num + num2;
			str1 = Integer.toString(num3);
			String updateSQL = "update ��Ʒ�ܱ�  set ����=?" + "where ��Ʒ='" + goods + "' ";
			PreparedStatement stmt;
			stmt = conn.prepareStatement(updateSQL);
			stmt.setString(1, str1);
			JOptionPane.showMessageDialog(null,"�޸ĳɹ���");
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
			String str8=t.TimeTest2();//ʱ��
			num4 = Double.valueOf(str5);
			num1=Integer.valueOf(str6);
			num2=num1*num4;
			s=Double.toString(num2);//�ܼ�
			
	  		try{
				connection();
				String InsSQL;
				InsSQL = "INSERT INTO ��Ʒ�ܱ�  (���,��Ʒ,����,���,����,����,�ۼ�,����ʱ��,�ܽ���) "+" VALUES ("+"'"+str1+"',"+"'"+str2+"',"
						+ ""+"'"+str3+"',"+"'"+str4+"',"+"'"+str5+"',"+"'"+str6+"',"+"'"+str7+"',"+"'"+str8+"',"+"'"+s+"')";
				stmt.execute(InsSQL);// ִ�н��¼�¼���뵽���ݱ�student�У�
				JOptionPane.showMessageDialog(null, "�����Ʒ�ɹ�");
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
			//VIPҳ��
	Component SeeVIP(){
		JPanel panel1 = new JPanel(new BorderLayout());
		try {
			connection();
			String sql="select * from vip��Ϣ��";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][100];
			Object s1[] = { "�˺�","����", "����", "�Ա�", "סַ", "�绰",  "ע��ʱ��","�ۿ�"};
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
			String sql="select * from vip�����¼��";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][20];
			Object s1[] = { "����","�˺�", "����", "��Ʒ", "����", "����", "�ۿ�", "ʵ��", "����", "��ʡ"};
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
				JOptionPane.showMessageDialog(null,"�����¼Ϊ��");
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
			InsSQL = "INSERT INTO vip��Ϣ��   (�ʺ�,����,����,�Ա�,סַ,�绰,�ۿ�,ע��ʱ��) "+" VALUES ("+"'"+str1+"',"+"'"+str2+"',"+"'"+str3+"',"+"'"+str4+"',"+"'"+str5+"',"+"'"+str6+"',"+"'"+str7+"',"+"'"+str8+"')";
			stmt.execute(InsSQL);// ִ�н��¼�¼���뵽���ݱ�student�У�
			JOptionPane.showMessageDialog(null, "ע��ɹ�,�ɽ������VIPҳ��鿴��");
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
			String sql="SELECT * From vip��Ϣ��   where �ʺ�='"+num2+"'";
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {if(r==1){
			Object s1[] = { "�˺�","����", "����", "�Ա�", "סַ", "�绰",  "ע��ʱ��","�ۿ�"};
			JTable tb1 = new JTable(r1, s1);
			JScrollPane spane1 = new JScrollPane(tb1);
			JPanel spa = new JPanel(new BorderLayout());
			spa.add(spane1,BorderLayout.CENTER);
			return spa;
		}else{
			JPanel spb = new JPanel();
			JLabel txt = new JLabel("����ѯ���û������ڣ�");
			spb.add(txt);
			return spb;
		}
		}
	}

	public  Component SetVIP(final String num3){
		JPanel c4 = new JPanel();
		 c4.setLayout(new BorderLayout());
		 JPanel zhu1 = new JPanel();
		 zhu1.add(new JLabel("�޸�VIP"));
		 JPanel zhu2 = new JPanel();
		 JPanel zhu3 = new JPanel(new GridLayout(6,2,3,3));
		 final JTextField t1 = new JTextField();
		final JTextField t2 = new JTextField();
		 final JTextField t3 = new JTextField();
		final JTextField t4 = new JTextField();
		 final JTextField t5 = new JTextField();
		final JTextField t6 = new JTextField();
		 zhu3.add(new JLabel("�޸�����"));zhu3.add(t1);
		 zhu3.add(new JLabel("�޸�����"));zhu3.add(t2);
		 zhu3.add(new JLabel("�޸��Ա�"));zhu3.add(t3);
		 zhu3.add(new JLabel("�޸�סַ"));zhu3.add(t4);
		 zhu3.add(new JLabel("�޸ĵ绰"));zhu3.add(t5);
		 zhu3.add(new JLabel("�޸��ۿ�"));zhu3.add(t6);
		 zhu2.add(zhu3);
		 c4.add(zhu1,BorderLayout.NORTH);
		 c4.add(zhu2);JButton Fin = new JButton("���");
		 c4.add(Fin,BorderLayout.SOUTH);
		 Fin.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
		try {
			
			connection();
			String updateSQL="update vip��Ϣ��  set ����=?,"+"����=?," +"�Ա�=?," +"סַ=?," +"�绰=?," +"�ۿ�=?"+"where �ʺ�='"+num3+"' ";
			PreparedStatement stmt;
			stmt=conn.prepareStatement(updateSQL);
			stmt.setString(1, t1.getText());
			stmt.setString(2, t2.getText());
			stmt.setString(3, t3.getText());
			stmt.setString(4, t4.getText());
			stmt.setString(5, t5.getText());
			stmt.setString(6, t6.getText());
			stmt.execute();
			JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
  			stmt.close();
  			stmt.close();
  			conn.close();
		} catch (SQLException i) {
			// TODO �Զ����ɵ� catch ��
			i.printStackTrace();
		}
			 }}
				 );
		 return c4;
	}

	public void DelVIP(String num4){
		String delStr="delete from vip��Ϣ��  where �ʺ�='"+num4+"'";
		try{
 			connection();
 			stmt.execute(delStr);
 			JOptionPane.showMessageDialog(null,"ɾ���ɹ�!");
		}catch(SQLException e1){
  			System.err.println("ɾ��ʧ�ܣ�");
  			System.err.println(e1.getSQLState()+e1.getMessage());
		}
	}

			//���¹���ҳ��
	public Component SeeWorker(){
		JPanel panel1 = new JPanel(new BorderLayout());
		try {
			connection();
			String sql="select * from ������Ϣ�ܱ�";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.last();
			int k=rs.getRow();
			rs.beforeFirst();
			Object r1[][];
			r1=new Object[k][20];
			Object s1[] = { "����","����", "�Ա�", "����", "����", "ְ��", "�绰", "��н", "סַ", "״̬", "ע��ʱ��"};
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
			// TODO �Զ����ɵ� catch ��
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
			String sql="SELECT * From ������Ϣ�ܱ�   where ����='"+num5+"'";
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {if(r==1){
			Object s1[] = { "����", "����", "�Ա�", "����","����","ְ��","�绰","��н","סַ","״̬","ע��ʱ��"};
			JTable tb1 = new JTable(r1, s1);
			JScrollPane spane1 = new JScrollPane(tb1);
			JPanel spa = new JPanel(new BorderLayout());
			spa.add(spane1,BorderLayout.CENTER);
			return spa;
		}else{
			JPanel spb = new JPanel();
			JLabel txt = new JLabel("����ѯ��Ա�������ڣ�");
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
			InsSQL = "INSERT INTO ������Ϣ�ܱ�   (����,����,�绰,�Ա�,����,����,ְ��,��н,״̬,סַ,ע��ʱ��) "+" VALUES ("+"'"+str1+"',"+"'"+str2+"',"+"'"+str3+"',"+"'"+str4+"',"+"'"+str5+"',"+"'"+str6+"',"+"'"+str7+"',"+"'"+str8+"',"+"'"+str9+"',"+"'"+str10+"',"+"'"+str11+"')";
			stmt.execute(InsSQL);// ִ�н��¼�¼���뵽���ݱ�student�У�
			JOptionPane.showMessageDialog(null, "ע��ɹ�,�ɽ������Ա��ҳ��鿴��");
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
		 zhu1.add(new JLabel("�޸�Ա��"));
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
		 zhu3.add(new JLabel("�޸�����"));zhu3.add(t1);
		 zhu3.add(new JLabel("�޸��Ա�"));zhu3.add(t2);
		 zhu3.add(new JLabel("�޸�����"));zhu3.add(t3);
		 zhu3.add(new JLabel("�޸Ĳ���"));zhu3.add(t4);
		 zhu3.add(new JLabel("�޸�ְ��"));zhu3.add(t5);
		 zhu3.add(new JLabel("�޸ĵ绰"));zhu3.add(t6);
		 zhu3.add(new JLabel("�޸���н"));zhu3.add(t7);
		 zhu3.add(new JLabel("�޸�סַ"));zhu3.add(t8);
		 zhu3.add(new JLabel("�޸�״̬"));zhu3.add(t9);
		 zhu2.add(zhu3);
		 c4.add(zhu1,BorderLayout.NORTH);
		 c4.add(zhu2);JButton Fin = new JButton("���");
		 c4.add(Fin,BorderLayout.SOUTH);
		 Fin.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
		try {
			connection();
			String updateSQL="update ������Ϣ�ܱ�  set ����=?,"+"�Ա�=?,"+"����=?,"+"����=?,"+"ְ��=?,"+"�绰=?,"+"��н=?,"+"סַ=?,"+"״̬=?"+"where ����='"+num6+"'";
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
			JOptionPane.showMessageDialog(null,"�޸ĳɹ����ɷ������ҳ��鿴~");
 			stmt.close();
 			stmt.close();
 			conn.close();
		} catch (SQLException i) {
			// TODO �Զ����ɵ� catch ��
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
			String sql="SELECT * From ������Ϣ�ܱ�   where ����='"+num2+"'";
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {if(r==1){
			Object s1[] = {"����","����", "�Ա�","����","����","ְ��", "�绰",  "��н", "סַ", "״̬", "ע��ʱ��"};
			JTable tb1 = new JTable(r1, s1);
			JScrollPane spane1 = new JScrollPane(tb1);
			JPanel spa = new JPanel(new BorderLayout());
			spa.add(spane1,BorderLayout.CENTER);
			return spa;
		}else{
			JPanel spb = new JPanel();
			JLabel txt = new JLabel("����ѯ��Ա�������ڣ�");
			spb.add(txt);
			return spb;
		}
		}
	}
	public void DelWorker(String num4){
		String delStr="delete from ������Ϣ�ܱ�  where ����='"+num4+"'";
		try{
 			connection();
 			stmt.execute(delStr);
 			JOptionPane.showMessageDialog(null,"ɾ���ɹ�!");
		}catch(SQLException e1){
  			System.err.println("ɾ��ʧ�ܣ�");
  			System.err.println(e1.getSQLState()+e1.getMessage());
		}
	}
	
	Component SeeMoney(){
	JPanel panel1 = new JPanel(new BorderLayout());
	try {
		connection();
		String sql="select * from �����";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		rs.last();
		int k=rs.getRow();
		rs.beforeFirst();
		Object r1[][];
		r1=new Object[k][100];
		Object s1[] = { "�ܽ��","���۶�", "���"};
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





