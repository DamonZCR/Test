package postgraduate.leetcd.ms;

import java.util.*;

/**
 * 输入一个只含有"（","）","{","}","[","]"的字符串S,输出此字符串能否正确配对，返回true和false；
 */
public class JSCC_KuoHaoPiPei {
    public static void main(String[] args) {
        System.out.println(isValid("()()()()(()){}"));
        System.out.println(numFactoredBinaryTrees(new int[]{1,2,3,4}));
    }
    public static boolean isValid(String s) {
        if(s==null) return true;
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }
            else if(c=='['){
                stack.push(']');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(stack.empty() || c!=stack.pop()){
                return false;
            }
        }
        return stack.empty();
    }
    public static int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x: dp) ans += x;
        return (int) (ans % MOD);
    }
}
