package postgraduate.leetcd.learnDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciSequence_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());
        System.out.println(solve(val));
    }

    private static int solve(int val){
        int zero = 0;
        if (zero == val)
            return zero;
        int one = 1;
        int flag = 1;
        int lin = 0;
        while (val > flag){
            lin = one;
            one = one + zero;
            zero = lin;

            flag++;
        }
        return one;
    }
}
