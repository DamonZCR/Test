package university.demo;

import java.util.Scanner;

public class BMItest {
    public static void main(String[] args) {
        float b;
        Scanner la = new Scanner(System.in);
        System.out.println("�������������أ�Kg����");
        int i = la.nextInt();
        System.out.println("������������ߣ�m)��");
        float a = la.nextFloat();
        b = i/(a*a);
        System.out.println("����BMIֵΪ��"+b);
    }
}
