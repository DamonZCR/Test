package postgraduate.leetcd.ms;
/** 20220424-腾讯-第二题
 * 牛牛有一个长度为n的数组a，数组下标从1~n。牛牛每一次会将a中所有下标为非质数的元素进行删除，
 * 即ai且i不为质数。在删除完之后，牛牛会将数组a重新按顺序拼接起来。牛牛会不断循环这个过程，
 * 直至数组a的大小为1。牛牛现在给你这个数组，他想知道这个数组最后剩下的那个元素的值是多少呢，
 * 请你告诉牛牛。注: 1不是质数
 * (本题是核心模式，不需要自己处理输入输出，完成函数即可)
 * 示例1
 * 输入
 * [1,2,3,4]
 * 输出
 * 3
 * 说明
 * 第一次数组会变成[2,3]。第二次数组会变成[3]。
 * 示例2
 * 输入
 * [3,1,1,4,5,6]
 * 输出
 * 5
 * 说明
 * 第一次数组会变成[1,1,5]。
 * 第二次数组会变成[1,5]。
 * 第三次数组会变成[5]。
 * 备注:
 * 2 <= n <= 2*10^5;1 <= ai <= 10^5
 */
public class TX_ShanChuFeiZhiShu {
    public static void main(String[] args) {
        System.out.println(getNumber(new int[]{3,1,1,4,5,6}));
    }
   public static int getNumber(int[] a){
        boolean[] visited = new boolean[a.length];
        int len2 = a.length;

        while(len2 > 1){
            int m = 1;
            int w = 1;
            while (w <= a.length){
                if (!visited[w - 1]){
                    if (!isPrime(m)){
                        visited[w - 1] = true;
                        len2--;
                    }
                    m++;
                }
                w++;
            }
        }
        int flag = 0, index = 0;
        while (index < a.length){
           if (!visited[index]){
               flag = index;
           }
           index++;
       }
       return a[flag];
    }
    // 判断一个数是不是质数
    private static boolean isPrime(int num){
        boolean res = true;
        if (num == 1)
            return false;
        if (num == 2)
            return true;
        for (int i = 2; i * i <= num && res; i++) {
            if (num % i == 0)
                res = false;
        }
        return res;
    }
}
