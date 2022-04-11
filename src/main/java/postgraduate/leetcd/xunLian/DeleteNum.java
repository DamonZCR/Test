package postgraduate.leetcd.xunLian;

import java.util.HashMap;

/**
 * 给定一个整数，从整数当中去掉k个数字，要求剩下数字形成的新整数尽可能小。应该如何选取去掉的数字?
 * 如；2020删除一个数字形成最小数为20
 * 1919删除一个数字最小值为119.
 */
public class DeleteNum {
    public static void main(String[] args) {
        String s = "2020";
        int k = 1;
        removeKDigits(s, k);
    }
    /**
     * 删去k个数字后的最小值
     * 时间复杂度0(n)
     * @param str
     * @param k
     */
    public static void removeKDigits(String str, int k ){
        char[] c = new char[str.length() - k];//定义最小值
        int n = 0;
        for (int i = 0; i < str.length(); i++){
            char j = str.charAt(i);
            //循环判断新产生数据和要比较数据的大小
            while(n > 0 && j < c[n-1] && k > 0){//删数据
                //类似栈原理
                System.out.println("删除数据："+c[n-1]);
                k--;//要删除长度减一
                n--;//字符串减一
            }
            c[n++] = j;//放数据
        }
        String c1 = new String(c);
        System.out.println(Integer.parseInt(c1));
    }
}

