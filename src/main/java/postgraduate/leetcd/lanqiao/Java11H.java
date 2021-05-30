package postgraduate.leetcd.lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 案例输入：
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * 输出：
 * 27
 */
public class Java11H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //ArrayList 里存放每一行，每一行的数据使用 List 装。
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<Integer>());
            String[] col = br.readLine().split(" ");
            for (int j=0;j<=i;j++) {
                list.get(i).add(Integer.parseInt(col[j]));
            }
        }
        int sum = cauculate(n-1, 0, list.get(0).get(0), 0, 0, list);
        System.out.println(sum);
    }

    // n 代表层数，sort 代表从该层中取第几位的数，left 代表向左取，right 代表向右取，list 是数字三角形。
    public static int cauculate(int n, int sort, int sum, int left, int right, ArrayList<ArrayList<Integer>> list){
        if (right + left == n){
            if (Math.abs(right - left) > 1)
                return 0;
            else
                return sum;
        }
        // 向右下
        int rvalue = cauculate(n, sort + 1, sum + list.get(right + 1 + left).get(sort + 1), left, right + 1, list);
        // 向左下
        int lvalue = cauculate(n, sort, sum + list.get(right + left + 1).get(sort), left + 1, right, list);
        return lvalue >= rvalue ? lvalue : rvalue;
    }
}

