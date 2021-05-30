package postgraduate.leetcd.lanqiao;

import java.io.*;
import java.util.Scanner;

public class FileContain2020 {
    public static String readTxt(File file){
        String result ="";

        try {
            BufferedReader bread = new BufferedReader(new FileReader(file));//����һ��BuffrerdReader���ȡ�ļ�
            String s = null;
            while ((s = bread.readLine())!=null){//һ��һ�ж�ȡ��Ҳ����һ���Զ�ȡ��
                result+=s;//����ȡ���ַ������ӳ�һ��
                //System.out.println(s);
            }
            bread.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;//���ض�ȡ���ַ�
    }

    public static void main(String args[]){

        File file = new File("D:/2020.txt");//�����ļ���
        String s = readTxt(file);//���ö�ȡ�ļ�����
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//����N,����������� N * N �ġ�
        int [][] a = new int[n][n];
        int k = 0;//��¼2020���ܸ���

        //����ȡ���ַ���������ʽ��n��n���ŷ�
        for(int i = 0 ; i < n ; i++){
            // �ֽ����һ�����ݡ�
            String ss = s.substring(i*n, (i+1)*n);
            System.out.println(ss);
            String[] sss = ss.split("");
            // �ֽ�һ��һ����������
            for(int j = 0; j < n; j ++){
                a[i][j] = Integer.parseInt(sss[j]);
            }
        }

        //�Ƚ�2020
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n-3; j ++){
                //��
                int temp = a[i][j] * 1000 + a[i][j+1] * 100 + a[i][j+2] * 10 + a[i][j+3] ;
                if(temp == 2020){
                    k++;
                }
                //��
                temp = a[j][i] * 1000 + a[j+1][i] * 100 + a[j+2][i] * 10 + a[j+3][i];
                if(temp == 2020){
                    k++;
                }
                //б��
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


