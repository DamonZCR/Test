package postgraduate.leetcd.ms;

import java.util.HashMap;
import java.util.Scanner;

public class BLF_ZuiXiaoTongQinFei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] person = new int[2][n];
        for (int i = 0; i < n; i++) {
            person[0][i] = sc.nextInt();
            person[1][i] = sc.nextInt();
        }
        //System.out.println(solve(n, person));
    }
/*    public static int solve(int n, int[][] per){
        HashMap<Integer, String> map = new HashMap<>();

    }*/
}
