package university.acm;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner ac = new Scanner(System.in);
        int t,x,f = 0;
        int[] z,a;
        x = ac.nextInt();
        z = new int[x];
        a = new int[z.length];
        for (int i=0;i<x;i++)
           z[i] = ac.nextInt();
        for (int j=0;j<z.length;j++)
            f = z[j] + f;
        for(int i=0;i<z.length;i++){
            a[i] = (f-z[i]) * z[i];
        }
        for (int i = 0;i<a.length-1;i++){
            for (int j = 0;j< a.length-1-i;j++){
                if(a[j]>a[j+1]) {
                    t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
            System.out.print(a[x-1]);

    }
}
