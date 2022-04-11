package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 有n个大饼，每个大饼都有一 个半径a。如果a[i] < a[j], 那么可以把第个大饼放在第j个大饼上面，你可以将大饼叠在一起，如
 * ai/aj  (代表ai 叠在 aj 上)，请问最少可以将这些大饼叠几堆。
 * 输入描述:
 *  第一行一个整数n(1 < n < 100000)。
 *  接下来n个整数a[i](1 < a[i] < 100000)。
 * 输出描述:
 *  输出一行，一个整数表示最少堆数。
 * 输入
 *  4
 *  4 2 4 3
 * 输出
 *  2
 * 说明
 * 一个半径为4的大饼一堆，另外一个半径为2, 3, 4的大饼叠在一堆。
 *
 * 输入
 *  7
 *  4977332
 * 输出
 *  2
 * 说明
 * 一种情况为:9，7.4.3.2堆，7，3-堆
 */
public class AddFood {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap();
        int ret = 0;
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (String i :
                s) {
            list.add(Integer.parseInt(i));
        }
        for (int i = 0;i < n;i++) {
            map.put(list.get(i), 0);
        }
        for (int i = 0;i < n; i++){
            int one = map.get(list.get(i)) + 1;
            map.replace(list.get(i), map.get(list.get(i)), one);
            if (map.get(list.get(i)) > ret) {
                ret = map.get(list.get(i));
            }
        }
        System.out.println(ret);
    }
}
