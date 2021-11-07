package postgraduate.leetcd.learnDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaiBoOfN_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());
        System.out.println(solve(val));
    }
    private static int solve(int n){
        int zero = 0;
        if (n == zero)
            return 0;
        int one = 0;
        int two = 1;
        int flag = 1;

        while(n > flag){
            int lin1 = two;
            two = two + one + zero;
            zero = one;
            one = lin1;

            flag++;
        }
        return two;
    }
}
