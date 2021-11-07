package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**重！！！！！！！！
 * 算法思想：
 * 一个n 个字符的字符串s ，通过对1到n 个位置进行分配解决。
 * 对于第一个位置存在n 个可能的字符（如果不考虑s 中存在重复字符），第二个位置就有n-1个可能的.....第 n 个位置就有1 种可能。
 * 如果s = abc,第一位置放a,那么就会第二 和 第三个位置就只能放 bc 中的一个。
 * 那么，第一位置就可以使用for循环来遍历，放a,b,c，在此基础上进行下一轮递归。
 * 当放a 的时候，再去放b 的时候，就可以直接将a和b 交换位置即可，就形成了第一位置放b,后两个位置放ac.
 * 那么，第二个位置上就是第二个位置上的元素依次与后面的元素依次交换位置形成其他情况。
 * 以此类推。
 */
public class SortTheStr2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> res = solve(s);
        for(String i:res)
            System.out.print(i + " ");
    }

    public static ArrayList<String> solve(String s){
        // 用于存储结果；
        ArrayList<String> list = new ArrayList<>();
        char[] schar = s.toCharArray();
        // 执行递归
        dealStr(list, schar,s.length(),0);
        return list;
    }
    private static void dealStr(ArrayList list, char[] schar, int length, int x){
        // 递归终止条件，当拼接的字符串长度达到原字符串长度终止。
        if(x == length-1){
            list.add(String.valueOf(schar));
            return;
        }
        // 集合用来存储该位置已经出现过的字符，为了保证唯一性。
        HashSet<Character> set = new HashSet<>();
        for(int i = x;i < length;i++){
            if(set.contains(schar[i]))
                continue;
            set.add(schar[i]);
            {// 交换
                char c = schar[i];
                schar[i] = schar[x];
                schar[x] = c;
            }
            dealStr(list, schar, length,x+1);
            {// 交换回原状态
                char c = schar[i];
                schar[i] = schar[x];
                schar[x] = c;
            }
        }
    }
}
