package university.acm;
/*
����Բ�İ뾶r����Բ�������
�����ʽ
�������һ������r����ʾԲ�İ뾶��
�����ʽ
���һ�У�����һ��ʵ�����������뱣��С�����7λ����ʾԲ�������
 */
//DecimalFormat�������滮��С���ĸ�ʽ��Format��ʽ��decimalС��
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
