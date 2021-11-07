package postgraduate.studyJava.studyStr;

import org.junit.Test;

/**
 * StringBuilder 初始容量16，非线程安全。
 * StringBuilder和StringBuffer 的方法一样。
 */
public class StudyStringBuilder {

    @Test
    public void AddStringFunc(){
        String str = "helloworld";
        String a = "hello" + "world";

        String b = "hello";
        String c = "world";
        String d = b + c;

        System.out.println(a); // helloworld
        System.out.println(d); // helloworld
        System.out.println(a == d); // false
        System.out.println(str == a); // true
        System.out.println(str == d); // false
        /**
         * 先来看 String a，“hello” + “world” 在 String 编译期间进行优化，优化结果为 “helloworld”，
         * 而该值在常量池中已经存有一份，因此 a 也指向了该常量池中的字符串，因此 a1 和 a 相等，输出 true
         * 在对 b 和 c 进行相加的过程中，其实是分两个步骤来进行。先是调用 StringBuilder 对象的 append()
         * 方法，加上 “hello” 字符；然后在调用一次 append() 方法，加上 “world”，最后默认调用 StringBuilder
         * 的 toString() 方法输出“helloworld”。很明显 d 对象指向的是堆中的 String 对象，而 a1 则指向的是
         * 常量池中的字符串，两者引用明显不同，因此输出 false。a 和 d 的比较与之类似，这里不加以赘述。
         */
    }
    @Test
    public void ChaJu(){
        // 使用String 的 + 拼接
        String text = "" ;
        long beginTime = System.currentTimeMillis();
        for ( int i= 0 ;i< 10000 ;i++)
            text = text + i;
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间：" +(endTime-beginTime));

        // 使用StringBuilder的 append() 拼接，相差百倍。
        StringBuilder sb = new StringBuilder ( "" );
        beginTime = System.currentTimeMillis();
        for ( int i= 0 ;i< 10000 ;i++)
            sb.append(String.valueOf(i));
        endTime = System.currentTimeMillis();
        System.out.println("执行时间：" +(endTime-beginTime));
    }
    @Test
    public void studyFunc(){
        // 初始化
        StringBuilder sb = new StringBuilder("Hello World!");

        // 追加
        sb.append(" What a beautiful day.");
        System.out.println("1、追加             " + sb);

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
         * 所以说，StringBuilder它可以改变字符序列的长度和内容。
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
}
