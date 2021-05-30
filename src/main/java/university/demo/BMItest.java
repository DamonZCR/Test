package university.demo;

import java.util.Scanner;

public class BMItest {
    public static void main(String[] args) {
        float b;
        Scanner la = new Scanner(System.in);
        System.out.println("请输入您的体重（Kg）：");
        int i = la.nextInt();
        System.out.println("请输入您的身高（m)：");
        float a = la.nextFloat();
        b = i/(a*a);
        System.out.println("您的BMI值为："+b);
    }
}
