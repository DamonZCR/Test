package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**20221015-滴滴
 *
 */
public class DiDi_2 {
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < n; i++) {
            nums[i][1] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(nums, new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0] - b[0];
            }
        });
        dfs(0, 0, -1, nums);
        System.out.println(res);
    }
    private static void dfs(int sum, int index, int num, int[][] nums){
        if (num == nums.length)
            return;
        if (sum == 3){
            res++;
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i][0] > num){
                dfs(sum + 1, i, nums[i][1], nums);
            }
        }
    }
}
