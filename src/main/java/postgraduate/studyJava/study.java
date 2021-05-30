package postgraduate.studyJava;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class study {

    public static void main(String[] args) {
        study1();
    }
    public static void study1(){
        // Java中，String使用双引号 "",char使用单引号。
        // String比较是否相等使用 equal(),char可以使用 ==。
        Scanner input  = new Scanner(System.in);
        String m = input.next();
        if(m == "T")//此时输入 T 不会相等。
            System.out.println(22);
    }
    @Test
    public void study2(){
        // Java中，String使用双引号 "",char使用单引号。
        // String比较是否相等使用 equal(),char可以使用 ==。
        String m = "T";
        System.out.println(m.equals("T"));
    }

    @Test
    public void test2(){
        char c = '2';
        System.out.println("Character.isDigit(char c)判断是不是数字字符：" + Character.isDigit(c));
        System.out.println("Character.isLetter(char c)判断是不是字母：" + Character.isLetter(c));
        System.out.println("Character.isLetterOrDigit(char c)判断是否是字母或数字字符：" + Character.isLetterOrDigit(c));
    }

    @Test
    public void arrayForm(){
        // 声明数组的形式

        int[] a = new int[3];
        // 采用静态初始化定义数组
        int[] b = {1, 2, 3,4};
        // 采用静态初始化定义数组完整格式
        int[] c = new int[]{1, 2, 3,4};
        // 二维数组必须规定行数。
        int[][] d = new int[4][];
    }
    @Test
    public void StringCompareTO(){
        // compareTo() 函数。
        String s = "b";
        String ss = "a";
        String sss = null;
        // 主字符串等于它得 0，小于得 -1 ，大于得 1
        System.out.println(s.compareTo(ss));
        // 不能和空null 进行比较
        //System.out.println(s.compareTo(sss));
    }
    @Test
    public void outType(){
        // 判断此对象 是否 是这个类的对象；
        String s = "22";
        System.out.println(s instanceof String);// true
    }
    @Test
    public void CalcuteTime(){

        // 方法一：估计程序运行时间，以毫秒为单位；
        long startTime=System.currentTimeMillis();
        /**
         * 程序代码段；
         */
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+" ms");

        // 方法二： 估计程序运行时间，以纳秒为单位；
        long startTime2 = System.nanoTime();   //获取开始时间
        /**
         * 程序代码段；
         */
        long endTime2 = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime2 - startTime2)+" ns");
    }
    @Test
    public void testBit(){
        // Integer.bitCount(int val) 返回整数的二进制形式中 1 的个数。
        // 具体使用见HammingDis.java 中的使用。
        System.out.println(Integer.bitCount(5));// val=4,res=1;val=5,res=2
    }
}
