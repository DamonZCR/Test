package postgraduate.studyJava.testJSON.testTransient;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @descripiton Externalizable接口的使用
 * 我们知道在Java中，对象的序列化可以通过实现两种接口来实现，若实现的是Serializable接口，
 * 则所有的序列化将会自动进行，若实现的是Externalizable接口，则没有任何东西可以自动序列化，
 * 需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关。
 * 因此第二个例子输出的是变量content初始化的内容，而不是null;
 */
public class A3_ZhenBeNengXuLieMa implements Externalizable {

    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws Exception {

        A3_ZhenBeNengXuLieMa et = new A3_ZhenBeNengXuLieMa();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("test")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test")));
        et = (A3_ZhenBeNengXuLieMa) in.readObject();
        System.out.println(et.content);

        out.close();
        in.close();
    }
}