package university.acm;

/*
Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 */
//用的递归的算法！
import java.util.Scanner;

public class Fibonacci {

        public static void main(String[] args)
        {
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            int sum=F(n);
            System.out.print(sum%10007);
        }
        public static int F(int n)
        {
            if(n==1||n==2)
            {
                return 1;
            }
            else
            {
                return F(n-1)+F(n-2);
            }
        }
    }
