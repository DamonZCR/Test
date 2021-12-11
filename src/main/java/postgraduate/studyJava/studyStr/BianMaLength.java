package postgraduate.studyJava.studyStr;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class BianMaLength {
    //不同的编码格式占字节数是不同的，UTF-8编码下一个中文所占字节也是不确定的，可能是2个、3个、4个字节；
    @Test
    public void AChinese() throws UnsupportedEncodingException {
        String a = "名";
        System.out.println("UTF-8编码长度:"+a.getBytes("UTF-8").length);
        System.out.println("GBK编码长度:"+a.getBytes("GBK").length);
        System.out.println("GB2312编码长度:"+a.getBytes("GB2312").length);
        System.out.println("==========================================");

        String c = "0x20001";
        System.out.println("UTF-8编码长度:"+c.getBytes("UTF-8").length);
        System.out.println("GBK编码长度:"+c.getBytes("GBK").length);
        System.out.println("GB2312编码长度:"+c.getBytes("GB2312").length);
        System.out.println("==========================================");

        char[] arr = Character.toChars(0x20001);
        String s = new String(arr);
        System.out.println("char array length:" + arr.length);
        System.out.println("content:|  " + s + " |");
        System.out.println("String length:" + s.length());
        System.out.println("UTF-8编码长度:"+s.getBytes("UTF-8").length);
        System.out.println("GBK编码长度:"+s.getBytes("GBK").length);
        System.out.println("GB2312编码长度:"+s.getBytes("GB2312").length);
        System.out.println("==========================================");
    }
}
