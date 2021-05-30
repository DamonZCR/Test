package university.acm;

import java.util.Scanner;

public class Tiger {
	public static void main(String arg[]){
		int a,b;
		int[][] x =  new int[20][3];
		Scanner dc = new Scanner(System.in);
		a = dc.nextInt();
		Scanner dd = new Scanner(System.in);
		for(int i = 0;i<a;i++){
			for(int w=0;w<3;w++){
			x[i][w] = dd.nextInt();}
		}
		
		for(int i = 0;i<a;i++){
			b = (x[i][2])/4;
			for(int y=0;y<=b;y++){
				for(int z=0;z<=b;z++){
					for(int j=0;j<=b;j++){
						if((y+z+j==b)&&(z+y==x[i][1])&&(2*j+2*y==x[i][0]))
							{System.out.println(y);}
					}
				}
			}
		}
	}
}
