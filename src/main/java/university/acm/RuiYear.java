package university.acm;
/*
给定一个年份，判断这一年是不是闰年。
当以下情况之一满足时，这一年是闰年：
1. 年份是4的倍数而不是100的倍数；
2. 年份是400的倍数。
其他的年份都不是闰年。
注意: 等于号是有两个等于==
 */
import java.util.Scanner;

public class RuiYear {
    public static void main(String[] args) {
        int y;
        Scanner dc = new Scanner(System.in);
        y = dc.nextInt();
        if(((y % 100!=0) && (y % 4 == 0)) || y % 400 == 0){
            System.out.println("yes");
        }else
            System.out.println("no");
    }
}
