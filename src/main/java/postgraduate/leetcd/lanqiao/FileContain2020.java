package postgraduate.leetcd.lanqiao;

import java.io.*;
import java.util.Scanner;

public class FileContain2020 {
    public static String readTxt(File file){
        String result ="";

        try {
            BufferedReader bread = new BufferedReader(new FileReader(file));//构造一个BuffrerdReader类读取文件
            String s = null;
            while ((s = bread.readLine())!=null){//一行一行读取，也可以一次性读取完
                result+=s;//将读取的字符串连接成一串
                //System.out.println(s);
            }
            bread.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;//返回读取的字符
    }

    public static void main(String args[]){

        File file = new File("D:/2020.txt");//创建文件类
        String s = readTxt(file);//调用读取文件方法
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//输入N,即这个矩阵是 N * N 的。
        int [][] a = new int[n][n];
        int k = 0;//记录2020的总个数

        //将读取的字符以数字形式按n行n列排放
        for(int i = 0 ; i < n ; i++){
            // 分解出来一行数据。
            String ss = s.substring(i*n, (i+1)*n);
            System.out.println(ss);
            String[] sss = ss.split("");
            // 分解一个一个的整数。
            for(int j = 0; j < n; j ++){
                a[i][j] = Integer.parseInt(sss[j]);
            }
        }

        //比较2020
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n-3; j ++){
                //行
                int temp = a[i][j] * 1000 + a[i][j+1] * 100 + a[i][j+2] * 10 + a[i][j+3] ;
                if(temp == 2020){
                    k++;
                }
                //列
                temp = a[j][i] * 1000 + a[j+1][i] * 100 + a[j+2][i] * 10 + a[j+3][i];
                if(temp == 2020){
                    k++;
                }
                //斜线
                if(i < n-3){
                    temp = a[i][j] * 1000 + a[i+1][j+1] * 100 + a[i+2][j+2] * 10 + a[i+3][j+3];
                    if(temp == 2020){
                        k++;
                    }
                }
            }
        }
        System.out.println(k);
    }
}


