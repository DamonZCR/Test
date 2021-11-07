package postgraduate.studyJava.studyStr;

import org.junit.Test;

/**
 * StringBuilder类,初始大小16，线程安全，每一个内部方法都有锁。
 * StringBuilder和StringBuffer 的方法一样。
 *
 * 还有一个StringBuilder类，它也是字符串缓冲区，StringBuilder与它和StringBuffer的有什么不同呢？
 * 它也是一个可变的字符序列。此类提供一个与 StringBuffer 兼容的 API，但不保证同步。该类被设计用作
 * StringBuffer 的一个简易替换，用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。如果可能，
 * 建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快。
 */
public class StudyStringBuff {
    @Test
    public void testFunc1(){
        // 声明的方式建议使用这个构造方法式的声明，也可以使用空的构造方法最后再追加内容。
        StringBuffer sb = new StringBuffer("abcdefg");

        sb.append("12"); //添加字符串,append()方法可以追加任意类型的东西。
        System.out.println("1、追加           ：" + sb );

        sb.insert(2, "34");//在指定位置插入
        System.out.println("2、指定为插入字符串： " + sb );

        sb.insert(2, 666);//在指定位置插入数字类型
        System.out.println("3、指定为插入int类型：" + sb );

        sb.delete(1, 4);//删除
        System.out.println("4、删除指定区间的字符：" + sb );

        sb.replace(1, 4, "****");//替换指定范围内的内容
        System.out.println("5、替换指定区间的字符：" + sb );
        /**
         * 注意：append、delete、insert、replace、reverse方法调用后，返回值都是当前对象自己，
         * 所以说，StringBuffer它可以改变字符序列的长度和内容。
         */
    }

    @Test
    public void testFunc2(){
        StringBuffer sb = new StringBuffer("abcdefg");

        sb.reverse(); //反转字符串
        System.out.println("1、 " + sb);

        System.out.println("2、 " + sb.charAt(1)); // 指定位置的字符

        System.out.println("3、 " + sb.deleteCharAt(1)); // 删除指定位置的字符

        System.out.println("4、 " + sb.indexOf("cb")); // 定位某字串首次出现的位置
        // 从指定位置处，定位某字串首次出现的位置，找不到返回 -1
        System.out.println("5、 " + sb.indexOf("cb",4));
    }
    @Test
    public void testFunc3(){
        StringBuffer sb = new StringBuffer("abcdefg");
        // 截取字符串
        System.out.println("1、截取字符串1：" + sb.substring(1));
        System.out.println("2、截取字符串1：" + sb.substring(1,4));
        System.out.println("原字符串不改变：" + sb);
        // 最后一次出现的位置
        StringBuffer sb2 = new StringBuffer("a3bc3def3g");
        System.out.println("3、最后一次出现位置1：" + sb2.lastIndexOf("3"));
        System.out.println("4、定位最后出现位置2：" + sb2.lastIndexOf("3",4));
    }
    @Test
    public void StrBufferDel(){
        StringBuffer s = new StringBuffer("abcdefghijk");
        // StringBuffer中删除指定位置的某个字符
        s.deleteCharAt(1);
        System.out.println(s);
    }
}
