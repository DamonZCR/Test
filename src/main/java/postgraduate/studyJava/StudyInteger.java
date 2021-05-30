package postgraduate.studyJava;

import org.junit.Test;

public class StudyInteger {
    @Test
    public void test1(){
        String s1 = "100";
        int num = 5;
        System.out.println("将二进制字符串 100 转为整数：" + Integer.parseInt(s1, 2));
        System.out.println("将十进制字符串 5 转为二进制字符串：" + Integer.toBinaryString(num));
    }

    @Test
    public void test2(){
        int a = 10;
        System.out.println("输出一个整数的16进制形式：" + Integer.toHexString(a));
        System.out.println("输出一个整数的8进制形式：" + Integer.toOctalString(a));
        System.out.println("输出整数 -3 无符号 任意进制 形式：" + Integer.toUnsignedString(-3, 8));
    }

    @Test
    public void test3(){

    }

}
