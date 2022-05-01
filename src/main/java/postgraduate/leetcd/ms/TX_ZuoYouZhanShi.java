package postgraduate.leetcd.ms;

import java.util.Scanner;

/** 20220424-腾讯-第三题
 * 有n个战士站成一排，分别编号为1,2,3...n，战士的战斗力等于他的编号，有一些战士只会进攻，有一些战士只会防守。
 * 现在我们要将他们从某个点开始分成两个阵营，假设这个点为pos(0<=pos<=n)，则编号为1,2,3....pos的战士为第一
 * 个阵营，pos+1,pos+2...n 的战士为第二个阵营。假设pos为0时，说明第一阵营没有战士，所有战士都在第二阵营。
 * 我们令第一个阵营为进攻方，第二个阵营为防守方，假设第一个阵营中能够进攻的战士战斗力总和为w,第二个阵营中能够
 * 防守的战士战斗力总和为v，我们希望|w-v|的值最小，其中| |为绝对值符号。求|w-v|最小值。
 * 即0代表进攻，1代表防守。左边进攻，右边防守；
 * 输入描述:
 * 第一行输入一个正整数n，表示战士的数量(1<=n<=10^5)。
 * 第二行给出一个字符串 s，仅由字符О或1组成，字符串中的每一位分别代表每一位战士的属性，0代表这个战士只会进攻，1代表这个战士只会防守。
 * 输出描述:
 * 输出一行一个整数表示|w-v|最小值。
 * 示例1
 * 输入
 * 4
 * 0011
 * 输出：
 * 1
 * 说明
 * 假设我们在第二个位置切割，这样左边的字符串为00，右边的字符串为11，代表左边有2个会进攻的战士，战斗力之和为1+2=3，
 * 右边有2个会防守的战士，战斗力之和为 3+4=7，即|w-v|=|3-7|=4。但如果我们在第三个位置切割，左边的字符串为001，
 * 右边的字符串为 1，此时左边会攻击的战士战斗力之和还是 3，右边会防守的战士战斗力为 4，此时差值为1，差值最小。
 * 示例2：
 * 输入
 * 7
 * 1000101
 * 输出
 * 2
 * 说明
 * 第二个样例可以在第五个位置分割，即左边的字符串为10001，右边的字符串为01，代表左边有3个会进攻的战士，2个会防守的战士，所
 * 有会攻击战士的战斗力之和即w = 2+3+4=9;右边有1个会防守的战士，1个会进攻的战士，所有会防守的战士的战斗力之和为v = 7。所
 * 以|9-7|=2。
 */
public class TX_ZuoYouZhanShi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        long[] left = new long[n + 1];
        long[] right = new long[n + 1];
        // 以下两个for循环用来计算前缀和
        for (int i = 1; i <= n; i++) {
            if (str.charAt(i - 1) == '0'){
                left[i] = left[i - 1] + i;
            }else {
                left[i] = left[i - 1];
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (str.charAt(i) == '1'){
                right[i] = right[i + 1] + i + 1;
            }else {
                right[i] = right[i + 1];
            }
        }
        // 找到左边的前缀和右边的前缀插值最小的情况
        long res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.abs(left[i] - right[i]));
        }

        // 特殊情况：即左边没有战士，或者右边没有战士的情况
        long rightSum = 0;
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1')
                rightSum += i + 1;
            else
                leftSum += i + 1;
        }
        System.out.println(Math.min(res,Math.min(rightSum, leftSum)));// 取最小；
    }
}
