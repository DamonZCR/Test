package postgraduate.leetcd.qiuZhao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class XiaoMi_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> nums = new ArrayList<>();
        while (sc.hasNext()){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            nums.add(new int[]{t1, t2});
        }
        Collections.sort(nums, (int[] a, int[] b) -> (a[0] - b[0]));
        int res = 0;
        int start = -1,end = -1;
        for (int i = 0; i < nums.size(); i++) {
            if ((end >= nums.get(i)[0])){
                end = Math.max(end, nums.get(i)[1]);
            }else {
                res += end - start;
                start = nums.get(i)[0];
                end = nums.get(i)[1];
            }
        }
        res += end - start;
        System.out.println(res);
    }
}
