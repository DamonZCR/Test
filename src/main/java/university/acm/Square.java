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
		//第一个矩形x坐标0、2，y坐标1、3。第二个矩形的x坐标4、6，y坐标5、7

	}

}
