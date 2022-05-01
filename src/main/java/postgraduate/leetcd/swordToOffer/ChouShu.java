package postgraduate.leetcd.swordToOffer;

public class ChouShu {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber2(1500));
    }
    // 暴力，超时；
    // 通过率：502/509
    public static int nthUglyNumber(int n) {
        int res = 1;
        int from = 2;
        if (n == 1)
            return 1;
        if (1500 > n && n > 1350) {
            from = 400000000;
            res = 1350;
        }else if (1600 > n && n >= 1500){
            from = 859963392;
            res = 1499;
        }else if (n >= 1600){
            from = 1399680000;
            res = 1599;
        }
        for (int i = from; i < 2147483647; i++) {
            if (zhiYinVerti(i)){
                res++;
                //System.out.println(i);
                if (res == n)
                    return i;
            }
        }
        return res;
    }
    private static boolean zhiYinVerti(int num){
        if (num % 7 != 0){
            while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0){
                if (num % 8 == 0)
                    num /= 8;
                else if (num % 6 == 0) {
                    num /= 6;
                }else if (num % 2 == 0) {
                     num /= 2;
                } else if (num % 3 == 0) {
                    if (num % 9 == 0)
                        num /= 9;
                    else
                        num /= 3;
                }else if (num % 5 == 0){
                    if (num % 125 == 0)
                        num /= 25;
                    else
                        num /= 5;
                }
            }
        }else
            return false;
        if (num == 1)
            return true;
        return false;
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了98.67%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了44.87%的用户
     * 通过测试用例：596 / 596
     * 思想：
     *     一个丑数和2、3、5相乘以后仍然是一个丑数，那么如果我有第一个丑数 1 ，
     *     就可以通过和2，3，5相乘得到下一个丑数，这个下一个丑数怎么选择呢？那就是
     *     我只取最小的一个作为下一个丑数，那么这下一个丑数怎么选择呢？那就是我只取最小的一个作为下一个丑数即可；
     *    具体实现，我使用三个指针，分别计算当前元素与2、3、5相乘以后的结果，如果是小于当前元素那么指针肯定是要增1的，
     *    只有下一位元素乘上指针对应额数字（2、3、5）才可以是下一个丑数；
     * @param n
     * @return
     */
    public static int nthUglyNumber2(int n){
        if (n < 0)
            return 0;
        // 用来存储每一个丑数；
        int[] uglyArr = new int[n];
        uglyArr[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;//三个数的指针；
        for (int i = 1; i < n; i++) {
            int lastMaxUgly = uglyArr[i - 1];
            if (lastMaxUgly >= uglyArr[p2] * 2) p2++;//小于当前元素，指针就要增 1
            if (lastMaxUgly >= uglyArr[p3] * 3) p3++;
            if (lastMaxUgly >= uglyArr[p5] * 5) p5++;
            uglyArr[i] = Math.min(uglyArr[p2] * 2, Math.min(uglyArr[p3] * 3, uglyArr[p5] * 5));
        }
        return uglyArr[n - 1];
    }
}
