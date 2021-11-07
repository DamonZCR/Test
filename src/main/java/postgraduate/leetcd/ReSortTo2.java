package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**869. 重新排序得到 2 的幂
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * 示例 1：
 * 输入：1
 * 输出：true
 * 示例 2：
 * 输入：10
 * 输出：false
 * 示例 3：
 * 输入：16
 * 输出：true
 * 示例 4：
 * 输入：24
 * 输出：false
 * 示例 5：
 * 输入：46
 * 输出：true
 */
public class ReSortTo2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(ReSortTo2.solve(n));
    }

    private static boolean solve(int n) {
        String[] nums = {"1", "2", "4", "8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096", "8192", "16384",
                "32768", "65536", "131072", "262144", "524288", "1048576", "2097152", "4194304", "8388608", "16777216", "33554432",
                "67108864", "134217728", "268435456", "536870912"};
        String[] split = String.valueOf(n).split("");
        ArrayList list1 = new ArrayList<String>(Arrays.asList(split));
        ArrayList<String> list = new ArrayList<String>(split.length);
        list.addAll(list1);

        int index = 0;
        while(index < nums.length){
            if (nums[index].length() == split.length){
                ArrayList<String> numarr = new ArrayList<>(Arrays.asList(nums[index].split("")));
                list.removeAll(numarr);
                numarr.removeAll(list1);

                if (list.size() == 0 && numarr.size() == 0){
                    System.out.println();
                    ArrayList<String> lin = new ArrayList<>(Arrays.asList(nums[index].split("")));
                    for (int i = 0;i < split.length;i++){
                        if (Collections.frequency(list1,split[i]) != Collections.frequency(lin,split[i]))
                            return false;
                    }
                    return true;
                }
                list.clear();
                list.addAll(list1);
            }else if (nums[index].length() > split.length)
                break;
            index++;
        }
        return false;
    }
}
