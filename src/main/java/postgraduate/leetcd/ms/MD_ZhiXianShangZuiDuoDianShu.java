package postgraduate.leetcd.ms;

import java.util.HashMap;

/**20220414-美的笔试-第二题
 * 直线上的最多点个数
 * 题目描述
 * 对于给定的n个位于同一二维平面上的点,求最多能有多少个点位于同一直线上
 * 实例1：
 * 输入：
 * [(0,0),(0,-1)]
 * 输出：
 *
 * 解析：
 *      见图片；
 */
class Point {
   int x;
   int y;
   public Point(int x, int y) {
     this.x = x;
     this.y = y;
   }
 }
public class MD_ZhiXianShangZuiDuoDianShu {
    public static void main(String[] args) {

    }
    public int maxPointsNum (Point[] points) {
        if (points.length < 3){
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int value = 0;
            int max = 0;
            HashMap<String ,Integer> map = new HashMap<>();
            // 计算此点与其他点的斜率
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                //此处是判断会不会出现重合的点，如果有重合的点，那么就不能向下执行，因为会报错；
                if (x == 0 && y == 0){
                    value++;
                    continue;
                }
                // 求这两个数的最大公约数；
                int gcd = gcd(x, y);
                // 除去最大公约数得到最简的数
                x = x / gcd;
                y = y /gcd;
                String key = x + "&" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + value + 1);
        }
        return res;
    }
    private int gcd(int a, int b){
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
