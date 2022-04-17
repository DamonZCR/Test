package postgraduate.leetcd.ms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**百度笔试-20220412-第三题
 * 题目描述
 * 牛牛有一个长度为n的数组a,牛牛想知道在所有的长度为k的子序列中,子序列和为偶数的序列个数有多少个呢。
 * 长度为k的子序列的含义为存在一组数1≤ i1 <= i2 <=.....<= ik ≤ n，所构成的数组ai1,ai2 ,...., aik
 * 输入描述:
 * 第一行为t，表示有t组数据。
 * 接下来有2×t行，其中第一行为n, k,表示数组长度和子序列长度。第二行有n个元素，表示数组元素ai。
 * 1≤ t ≤ 100,1 ≤ n ≤10^3,1 < k ≤ n,1 < ai ≤ 10^9.
 * 输出描述:
 * 3
 * 5 2
 * 1 2 3 4 5
 * 3 1
 * 1 2 3
 * 4 3
 * 1 4 2 2
 * 输出：
 * 4
 * 1
 * 1
 * 讲明
 * 第一组中满足题意的子序列为{1,3},{1,5},{3,5},{2，4}.
 * 第三组中满足题意的子序列为{2}。
 * 第三组中满足题意的子序列为{4.2.2}.
 */

public class BD_ZiXuLieHeWeiOuShu {
    static int[] res;

    public static void main(String[] args) throws IOException {
        sovle();
    }

    /**
     * 使用DFS深搜
     * 通过率较低；
     * @throws IOException
     */
    public static void sovle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        res = new int[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int[] nums = new int[a];

            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < a; j++) {
                nums[j] = Integer.parseInt(s1[j]);
            }
            dfs(nums, 0, 0, 0, b, i);
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static void dfs(int[] nums, long sum, int index, int len, int k, int m) {
        if (len == k){//已经达到规定的长度；
            if ((sum & 1) == 0){
                res[m] = (res[m] + 1) % (1000000007);
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            dfs(nums, sum + nums[i], i + 1, len + 1, k, m);
        }
    }
}
