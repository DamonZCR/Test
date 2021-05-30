package university.acm;
/*
累加求和，最大可到1，000，000，000
使用switch减小了内存消耗
注意：定义一个long整型，需要在数字后加上大写L。
 */
import java.util.Scanner;

public class NumPlus {
    public static void main(String[] args) {
        long a;
        int i= 0;
        Scanner dc = new Scanner(System.in);
        a = dc.nextLong();
        if(a<=999)
        {
        }
        else if (a<=999999)
        {
        i = 1;
        }else if(a<=1000000000) i = 2;

        switch (i){
            case 0:
                int x = 0,n = 1;
                while (n<=a){
                    x = x + n++;
                }
                System.out.println(x);
                break;
            case 1:
                long z = 499500,w = 1000;
                while (w<=a){
                    z = z + w++;
                }
                System.out.println(z);
                break;
            case 2:
                long s = 499999500000L;
                long f = 1000000;
                while (f<=a){
                    s = s + f++;
                }
                System.out.println(s);
                break;
        }
    }
}
