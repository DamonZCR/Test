package postgraduate.leetcd.xunLian;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**46. 全排列
 * 重点参考SortTheStr2.java题思路。
 *给定一个不含重复数字的数组 nums ，返回其所有可能的全排列 。你可以 按任意顺序 返回答案。
 *     1 <= nums.length <= 6
 *     -10 <= nums[i] <= 10
 *     nums 中的所有整数 互不相同
 */
public class QuanPaiLie1 {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        solve(new ArrayList<Integer>(nums.length), nums, 0, res);
        return res;
    }

    /**
     * 执行结果：
     * 通过
     * 执行用时：9 ms, 在所有 Java 提交中击败了5.84% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了5.24% 的用户
     * 通过测试用例：26 / 26
     * @param list
     * @param nums
     * @param index
     * @param res
     */
    private void solve(List<Integer> list, int[] nums, int index, List<List<Integer>> res){
        if (index == nums.length){
            res.add(list);
        }
        List<Integer> co = Arrays.stream(nums).boxed().collect(Collectors.toList());
        ArrayList<Integer> naci = new ArrayList(co);
        ArrayList<Integer> bian = new ArrayList(list);
        naci.removeAll(bian);
        for (int i = 0;i < naci.size();i++){
            list.add(index, naci.get(i));
            solve(new ArrayList<>(list), nums, index + 1, res);
            list.remove(index);
        }
    }
}
