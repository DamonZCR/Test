package university.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Damon on 2018/12/11.
 */
public class ConnDB {
    Statement stmt;
    Connection conn;
    public void connection(){//�������ݿ�
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8","root","");
            stmt = conn.createStatement();
            System.out.println("���ӳɹ���");
        }catch(ClassNotFoundException e1){
            System.out.println("����װ��ʧ�ܣ�");
        }catch(SQLException e2){
            e2.getSQLState();
            e2.getMessage();
        }
    }
    public void close() {//�Ͽ����ݿ�
        try {
            if (stmt != null)
                stmt.close();
            conn.close();
        } catch (SQLException e2) {
            System.out.println("���������ر�");
        }
    }
    public static void main(String[] args) {
        ConnDB test = new ConnDB();
        test.connection();
    }
}
