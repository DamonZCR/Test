package postgraduate.leetcd.qiuZhao;

import java.util.HashMap;

/**20221111太平洋保险
 * 一个一维数组中，找到最长不重复字数组的长度是多少？
 */
public class TaiPingYangBaoXian {
    public int getMaxLength(int[] arr){
        int len = arr.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], -1);
        }
        map.put(arr[0], 0);
        int[] dp = new int[len];
        dp[0] = -1;
        int res = 0;
        for (int i = 1; i < len; i++) {
            int lin = Math.max(dp[i -1], map.get(arr[i]));
            res = Math.max(res, i - lin);
            dp[i] = lin;
            map.put(arr[i], i);
        }
        return res;
    }
}
