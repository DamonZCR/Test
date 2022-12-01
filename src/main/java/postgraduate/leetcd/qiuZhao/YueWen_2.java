package postgraduate.leetcd.qiuZhao;

import java.util.Arrays;
//阅文集团20221101笔试
//给定两个有序的数组，并且给定他们的长度，将两个数组合并为一个有序的数组；
public class YueWen_2 {
    public int[] merge (int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        for (int i = 0; i < m; i++) {
            res[i] = nums1[i];
        }
        for (int i = 0,j = m; i < n; i++, j++) {
            res[j] = nums2[i];
        }
        Arrays.sort(res);
        return res;
    }
}
