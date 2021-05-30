package university.acm;

import java.util.Scanner;

/**
 * Created by Damon on 2019/3/15.
 */
//ctrl 加D结束运行

public class ScannerDemo {
    public static void main (String[] args)throws Exception{
        Scanner scann = new Scanner(System.in);
        int sum = 0;
        try{
            while (true){
                sum+=scann.nextInt();
            }
        }catch (Exception e){
            System.out.println((e));
        }
        System.out.println(sum);
    }
}
