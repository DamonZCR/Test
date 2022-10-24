package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**20221015-滴滴
 *
 */
public class DiDi_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(nums);
        int res = 0;
        int n1 = 0;
        int i = 0;
        for (; i < n;) {
            while (i < n){
                if (nums[i] <= nums[n1] + k){
                    i++;
                }else {
                    res = Math.max(res, i - n1);
                    n1++;
                    break;
                }
            }
        }
        res = Math.max(res, i - n1);
        System.out.println(res);
    }
}
