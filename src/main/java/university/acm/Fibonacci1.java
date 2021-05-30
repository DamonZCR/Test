package university.acm;
/*
 * 非递归实现Fibonacci数列的相加
 * 递归转换为非递归的思路需要学习
 */
import java.util.Scanner;

public class Fibonacci1 {
	public static void main(String arg[]){
		
		int n;
		Scanner ds = new Scanner(System.in);
		System.out.print("请输入一个整数：");
		n = ds.nextInt();
		System.out.println("输出数列第 "+n+"个数列的值为："+FibonacciTest(n));
		
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
