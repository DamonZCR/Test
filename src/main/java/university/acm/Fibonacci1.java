package university.acm;
/*
 * �ǵݹ�ʵ��Fibonacci���е����
 * �ݹ�ת��Ϊ�ǵݹ��˼·��Ҫѧϰ
 */
import java.util.Scanner;

public class Fibonacci1 {
	public static void main(String arg[]){
		
		int n;
		Scanner ds = new Scanner(System.in);
		System.out.print("������һ��������");
		n = ds.nextInt();
		System.out.println("������е� "+n+"�����е�ֵΪ��"+FibonacciTest(n));
		
	}
	public static long FibonacciTest(int x){
		long ff = 1;
		long fs = 1;
		long fr = 0;
		if(x==0||x==1) return 1;
		while(x>=2){
			fr = ff + fs;
			fs = ff;
			ff = fr;
			--x;
		}
		return fr;
	}
}
