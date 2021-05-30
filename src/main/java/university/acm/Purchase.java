package university.acm;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Purchase {
	public static void main(String arg[]){
		int i;
		float n,m;
		double f=0.00;
		float num[] = new float[100];
		Scanner dc = new Scanner(System.in);
		i = dc.nextInt();
		
		for(int j=0;j<i;j++){
			n = dc.nextFloat();
			m = dc.nextFloat();
			num[j] = n*m;
			f = f+num[j];
		}
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(f));
	}
}
