package postgraduate.studyJava;

import org.junit.Test;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringTest {

    @Test
    public void testReplace(){
        // replace 和 replaceAll 的区别
        // replaceAll支持正则表达式，因此会对参数进行解析（两个参数均是），如replaceAll("\\d", "*")
        // 而replace则不会，replace("\\d","*")就是替换"\\d"的字符串，而不会解析为正则。如果不使用正则表达式反而用了replaceAll,效率更低。
        String ss = "We are happy 2021 !.";
        System.out.println(ss.replace(" ", "*"));// We%20are%20happy%202021%20!.
        // \\d 代表整数字符。
        System.out.println(ss.replaceAll("\\d", "*"));// We are happy %20%20%20%20 !.
    }

    @Test
    public void testToString(){
        // 把一个整数数组转为一整个字符串，如：1020304050549865
        // 和一般的方法 toString() 不同，它得到的结果含有 [ ] 以及 ， 。

        int[] num = {10,20,30,40,50,54,98,65};
        String[] ss = {"1","s"};
        String s = "";
        String s2 = "";
        // 将 整数数组 连接为一整个字符串
        for (int i : num) {
            s += String.valueOf(i);
        }
        // 将 字符串数组 连接为一整个字符串
        for (String i : ss) {
            s2 += i;
        }
        System.out.println("拼接数字：" + s);
        System.out.println("拼接任意字符：" + s2);
        // 使用 Stream 将一个整数数组转为一整个字符串。
        IntStream stream = Arrays.stream(num);
        String collect = stream.mapToObj(x -> String.valueOf(x)).collect(Collectors.joining());
        System.out.println("暂时只能用于拼接数字：" + collect);
    }

    @Test
    public void testCharToString(){

        // String 类构造方法二，将字符 数组转为 一整个 字符串
        // 不可以使用 整数数组转为字符串，
        char[] num = {'1','2','3','4','5','5','9','6'};
        String ss = new String(num);
        System.out.println(ss);
    }

    @Test
    public void testStringSon(){
        // 字符串截除函数
        String c = "abcdefg";
        System.out.println(c.substring(2));// cdefg
        System.out.println(c.substring(0, 2));// ab
    }

    @Test
    public void AddString(){
        // 字符串拼接函数（当然，也可以在返回或输出时直接使用 + 号来拼接两个字符串）
        String c = "123";
        // 方法一： 使用concat()函数
        c.concat("456"); //13456
        // 方法二： 使用StringBuilder() 方法中的append() 方法,append()方法可用于追加更多类型数据。
        String c2 = "234";
        c2 = new StringBuilder(c2).append("567").toString();

        System.out.println(c + "  "+ c2);
    }

    @Test
    public void indexChar(){
        // 定位输出字符串中的某位置字符
        String s = "12345";
        System.out.println(s.charAt(2));// 3
    }
    @Test
    public void test3(){
        int a = 1;
        int b = 1;
        System.out.println("字符串与整数直接相加结果为拼接：abc" + a);
        System.out.print("字符 与整数加减为Unicode码 相加的值：   ");
        System.out.println('a' + b);// 98
    }
    @Test
    public void findStr() {
        // 字符串匹配：方法一
        // 双层
        String s1 = "asdfahgasdfasf";
        String s2 = "asf";
        for (int i = 0;i <= s1.length()-s2.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + j) == s2.charAt(j)) {
                    if (j == s2.length() - 1) {
                        System.out.println(i + 1);
                        return;
                    }
                } else
                    break;
            }
        }
    }
    @Test
    public void findStr1() {
        // 字符串匹配：方法二
        // BF（模式匹配）
        String s1 = "asdfaasfi";
        String s2 = "asf";
        int s1Begin = 3;
        int s2Begin = 0;
        while (s1Begin < s1.length() && s2Begin < s2.length()){
            if (s1.charAt(s1Begin) == s2.charAt(s2Begin)){
                s1Begin++;
                s2Begin++;
            }else {
                s1Begin = s1Begin - s2Begin + 1;
                s2Begin = 0;
            }
        }
        if (s2Begin == s2.length())
            System.out.println(s1Begin - s2.length() + 1);
        else
            System.out.println("匹配失败！");
    }
    @Test
    public void testCompareTo(){
        /**
         * 首先取出两个字符串的长度，比较较小的长度内，两者是否相等。
         * 若不相等，则直接返回该位置字符的ASCII码相减后的值。
         * 若各位置都相等，则将两个 字符串长度 的差值返回。
         *
         * 相等为0，小于返回 负值，大于返回正值。
         */
        String s1 = "coding";
        String s2 = "looding";
        // c 和 l 的unicode码的差值是 9.
        System.out.println(s1.compareTo(s2));
        System.out.println(-s1.compareTo(s2));
        System.out.println(s1.compareTo(s1));
    }
    @Test
    public void testEquals(){
        /**
         * equals() 源码分析：首先使用 == 比较，如果地址和值相等直接返回true。
         * 再判断长度是否相等，不相等就返回false。
         * 然后再一个字符一个字符的比较，出现不相等字符返回false。
         *
         * new String("ab")和 String a = "ab" 什么区别？
         * String a=“ab”;直接赋值的本质是将一个开辟好的堆内存空间的使用权交给了对象a，也可以说对象a指向了保存有“ab”的堆内存空间。
         * String a=new String(“ab”);该方法是重新开辟一个新的堆内存空间并将“ab”保存进去。
         * 两种方法的比较：
         * 直接赋值不需要开辟新的内存，而是直接获得”ab“对象内存的使用权，且以后声明”ab“对象都不会开辟新的内存空间，而是直接引用；
         * 而通过new String（）方法赋值需要开辟新的内存空间。
         */

        String A = new String("美好一天");
        String B = new String("美好一天");
        System.out.println(A.equals(B));
        System.out.println(A == B);

        String C = "美好一天";
        String D = "美好一天";
        System.out.println(C.equals(D));
        System.out.println(C == D);
    }

}
