package university.acm;

/*
Fibonacci���еĵ��ƹ�ʽΪ��Fn=Fn-1+Fn-2������F1=F2=1��
��n�Ƚϴ�ʱ��FnҲ�ǳ�������������֪����Fn����10007�������Ƕ��١�
 */
//�õĵݹ���㷨��
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
