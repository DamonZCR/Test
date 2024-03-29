package postgraduate.leetcd.ms;

import java.util.Scanner;

/**微众-20220411笔试
 * 小亮来到了一个特殊的国度，这个国家的人有一个奇特的地方:如果一个人身边的人都比自己强，那么这个人会开始努力提升自己。
 * 现在有n个人排成一排，因为视线是有限的，所以每个人只能看见左边的x个人和右边的y人。每个人都有一个能力值a_i,如果他
 * 视线能看到的人能力值都比他高，则他会开始努力提升自己。如果左边人数不足x个人，则左边的视线能看见左边所有人，如果右边并没有y个人，那么右边
 * 的视线仅仅覆盖右边的所有人。
 * 已知这n个人的编号从左到右为1 ~ n，请问努力的人中最左边的人编号是多少。保证这n个人的能力值都不重复，且都在10^6以内。
 *
 * 输入描述
 * 输入第一行包含三个空格隔开的正整数，n,x,y,含义如题。(1<=n<=10^5,1<=x,y<=10000)
 * 第二行有n个正整数，表示n个人的能力值,中间用空格隔开。
 * 输出描述
 * 输出仅包含一个正整数，即努力的人中最左边的编号是多少。
 * 样例输入
 * 10 2 3
 * 10 8 7 1 9 2 6 4 3 5
 * 样例输出
 * 4
 *
 * 提示
 * 输入样例2
 * 6 2 2
 * 10 8 2 7 3 1
 * 输出样例2
 * 3
 *
 * 输入样例3
 * 5 2 2
 * 10 8 2 7 1
 * 输出样例3
 * 5
 * 思想：
 *      假设他能向左看到距离为left，向右能看到right。遍历整个数组，对于数组中的某一个数字i,
 *      从它i-left的位置，到i,并且从i+ right的都是大于它的。i-left最小为0，所以，要遍历
 *      从i-left到i+right的位置，i-left最小为0.i + right最大为数组的长度；
 *      所以对一个位置为i的元素，可以从它最远能看到的左边界，遍历到它所能看到的右边界，如果里面的
 *      元素除它本身外都是大于它的，就是满足的；
 */
public class WZ_NuLiDeRen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int left = sc.nextInt();
        int right = sc.nextInt();
        int[] fenshu = new int[nums];
        for (int i = 0; i < nums; i++) {
            fenshu[i] = sc.nextInt();
        }
        int i = 0;
        while (i < nums){
            int left2 = Math.max(i - left, 0);
            // 在右边界和最后一个元素的位置取最小，因为担心越界；
            int right2 = Math.min(i + right, nums - 1);
            //int index = 1;
            int index = left2;//此处应该是从它的左相应能看到的距离搜，不能从1；
            while (i == index || (index <= right2 && fenshu[index] > fenshu[i])){
                index++;
            }
            if (index > right2){
                System.out.println(i + 1);
                break;
            }
            i++;
        }
    }
}
