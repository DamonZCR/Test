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
    public void connection(){//连接数据库
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8","root","");
            stmt = conn.createStatement();
            System.out.println("连接成功！");
        }catch(ClassNotFoundException e1){
            System.out.println("驱动装载失败！");
        }catch(SQLException e2){
            e2.getSQLState();
            e2.getMessage();
        }
    }
    public void close() {//断开数据库
        try {
            if (stmt != null)
                stmt.close();
            conn.close();
        } catch (SQLException e2) {
            System.out.println("不能正常关闭");
        }
    }
    public static void main(String[] args) {
        ConnDB test = new ConnDB();
        test.connection();
    }
}
