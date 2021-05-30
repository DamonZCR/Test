package university.acm;
/*
给定圆的半径r，求圆的面积。
输入格式
输入包含一个整数r，表示圆的半径。
输出格式
输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。
 */
//DecimalFormat类用来规划化小数的格式，Format格式，decimal小数
import java.text.DecimalFormat;
import java.util.Scanner;
import static java.lang.StrictMath.atan;

public class CircleArea {
    public static void main(String[] args) {
        int a;
        double PI = atan(1.0)*4;
        Scanner dc = new Scanner(System.in);
        a = dc.nextInt();
        DecimalFormat fc = new DecimalFormat("0.0000000");
        System.out.println(fc.format(PI*a*a));
    }
}
