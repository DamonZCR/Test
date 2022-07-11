package postgraduate.studyJava;

import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
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
        System.out.println(Integer.MAX_VALUE);
    }
    @Test
    public void study3(){
        int x = 32;
        int y = x + (x >>> 1) + 1;
        int w = 9;
        System.out.println(w >>> 1);
        System.out.println(y);

        int MAXIMUM_CAPACITY = 1 << 30;
        int n = y - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int u = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(u);

        int q = 16;
        q |= q >>> 16;
        System.out.println(q);
    }

    @Test
    public void test2(){
        // 判断一个字符是不是数字，字母，数字或者字母。
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
        String s = null;
        System.out.println(s.hashCode());
    }
    @Test
    public void StringCompareTO(){
        // compareTo() 函数。
        String s = "a";
        String ss = "c";
        String sss = null;
        // 主字符串等于它得 0，小于得 小于0的值 ，大于得 大于0的值
        System.out.println(s.compareTo(ss));
        // 不能和空null 进行比较
        //System.out.println(s.compareTo(sss));
    }
    @Test
    public void outType(){
        // 判断此对象 是否 是这个类的对象；
        String s = "22";
        System.out.println(s instanceof String);// true

        // 求log(2)(5)即log以2为底的5，根据换底公式可得log(5)/log(2)
        double m = 5.0;
        double n = 3.0;
        double value = Math.log(m) / Math.log(n);
    }
    @Test
    public void CalcuteTime(){

        // 方法一：估计程序运行时间，以毫秒为单位；1s = 1000ms
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
        int i = -1;


        int h;
        int f = 1;
        int j = (f == 0) ? 1 : (h = 3);
        System.out.println(j);
    }
    @Test
    public void testArray(){
        // 测试Java中向函数传递数组为 引用传递，在go中是值传递。
        // 使得被传进的函数会改变数组的内容,而golang不会改变。
        int[] num = {1,2,3,4,5,6};
        testFunc(num);
        for(int i : num)
            System.out.print(" " + i);//  10 2 3 4 5 6
    }
    private void testFunc(int[] num){
        // 传进的数组，首位可以直接赋值。
        num[0] = 10;
    }
    @Test
    public void testPrint(){
        // 格式化输出小数的两个方式，其中一种可用于禁止四舍五入；
        double d = 666.1234567f;
        DecimalFormat ff = new DecimalFormat("0.0000");
        ff.setRoundingMode(RoundingMode.DOWN);//向下取整，取消四舍五入
        System.out.printf("%.4f\n", d);//666.1235
        System.out.println(ff.format(d));//666.1234
    }
    @Test
    public void testMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("aa", "bb");
        System.out.println(map.get("cc"));
    }
}
