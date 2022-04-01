package postgraduate.studyJava.testJSON;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *  Java的serialization提供了一种持久化对象实例的机制。当持久化对象时，可能有一个特殊的对象数据成员，
 *  我们不想用serialization机制来保存它。为了在一个特定对象的一个域上关闭serialization，可以在这个
 *  域前加上关键字transient。被标记为transient的属性在对象被序列化的时候不会被保存。
 */
class UserInfo implements Serializable {
    private static final long serialVersionUID = 996890129747019948L;
    private String name;
    private transient String psw;

    public UserInfo(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public String toString() {
        return "name=" + name + ", psw=" + psw;
    }
}

public class TestTransient {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.size();
        UserInfo userInfo = new UserInfo("张三", "123456");
        System.out.println(userInfo);
        LinkedList<String> s = new LinkedList<>();
        s.offer("222");
        try {
            // 序列化，被设置为transient的属性没有被序列化
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
                    "UserInfo.out"));
            o.writeObject(userInfo);
            o.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try {
            // 重新读取内容
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                    "UserInfo.out"));
            UserInfo readUserInfo = (UserInfo) in.readObject();
            //读取后psw的内容为null
            System.out.println(readUserInfo.toString());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}