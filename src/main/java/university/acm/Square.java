package university.acm;

import java.util.Scanner;

public class Square {
	public static void main(String arg[]){
		double[][] site = new double[10][8];
		int c;
		Scanner dc = new Scanner(System.in);
		c = dc.nextInt();
		for(int i=0;i<c;i++){
			for(int j=0;j<8;j++){
				site[i][j] = dc.nextDouble();
			}
		}
		//��һ������x����0��2��y����1��3���ڶ������ε�x����4��6��y����5��7

	}

}
