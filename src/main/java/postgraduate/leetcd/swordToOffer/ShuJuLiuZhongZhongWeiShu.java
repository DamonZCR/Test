package postgraduate.leetcd.swordToOffer;

import java.util.ArrayList;
import java.util.Collections;

/**剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于
 * 中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 */
public class ShuJuLiuZhongZhongWeiShu {
    ArrayList<Integer> list;
    double mid;
    int loca;
    public ShuJuLiuZhongZhongWeiShu() {
        list = new ArrayList<>();
        mid = Integer.MIN_VALUE;
        loca = 0;
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
        int lin = list.size() % 2;
        if (lin == 1){
            loca = list.size() / 2;
            mid = list.get(loca);
        }else {
            loca = (list.size() - 1) / 2;
            if (list.size() > 1)
                mid = (double)(list.get(loca) + list.get(loca + 1)) / 2;
            else
                mid = list.get(0);
        }
    }

    public double findMedian() {
        return mid;
    }
}
