package university.acm;

import java.util.Scanner;

//输入自定义数量字符串，比较字符串最短的输出

public class WordLength {
    public static void main(String[] args) {
        Scanner dc = new Scanner(System.in);
        Scanner dd = new Scanner(System.in);
        int a,t;
        String[] str = new String[100];
        int[] x = new int[100];
        a = dc.nextInt();
        for (int i=0;i<a;i++){
            str[i] = dd.nextLine();
            x[i] = str[i].length();
        }
        for (int i = 0;i<a;i++){
            for (int j = 0;j<a-1-i;j++){
                if(x[j]>x[j+1]) {
                    t = x[j];
                    x[j] = x[j+1];
                    x[j+1] = t;
                }
                }
            }
        System.out.print(str[a-1]);
    }
    }

