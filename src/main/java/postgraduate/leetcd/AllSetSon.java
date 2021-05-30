package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * 现在有一个没有重复元素的整数集合S，求S的所有子集
 * 注意:你给出的子集中的元素必须按升序排列给出的解集中不能出现重复的元素
 * 例如:
 * 如果S=[1,2,3],给出的解集应为:[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
 * 解答：
 *  如下程序使用DFS算法实现。每一层代表一个元素，左子树代表不使用该节点，右子树代表使用该节点，
 *  使用中序遍历来获得全部叶子结点，那么就能获得该数组的子集。思路图片在file文件夹中。
 * */
public class AllSetSon {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] begin = bf.readLine().split(" ");
        List<Integer> list = new ArrayList<Integer>();
        for (String i:begin) {
            list.add(Integer.parseInt(i));
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int level = 0;
        // list 为初始集合，result所求子集集合，temp为当前子集，level为当前层次。
        getArr(list, result, temp, level);
        System.out.println(result);
    }
    private static void getArr(List<Integer> list, List<List<Integer>> result, List<Integer> temp, int level)
    {
        if(level == list.size()){
            // 终止条件，满足后将每一个temp集合加入到result中。
            result.add(temp);
        }else {
            getArr(list, result, new ArrayList(temp), level+1);
            temp.add(list.get(level));
            getArr(list, result, new ArrayList(temp), level+1);
        }
    }
}