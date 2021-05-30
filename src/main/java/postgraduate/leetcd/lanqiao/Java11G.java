package postgraduate.leetcd.lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 小蓝正在学习一门神奇的语言，这门语言中的单词都是由小写英文字母组成，有些单词很长，远远超过正常英文单词的长度。
 * 小蓝学了很长时间也记不住一些单词，他准备不再完全记忆这些单词，而是根据单词中哪个字母出现得最多来分辨单词。
 * 现在，请你帮助小蓝，给了一个单词后，帮助他找到出现最多的字母和这 个字母出现的次数。
 * 输入描述
 * 输入一行包含一个单词，单词只由小写英文字母组成。对于所有的评测用例，输入的单词长度不超过 1000。
 * 输出描述
 * 输出两行，第一行包含一个英文字母，表示单词中出现得最多的字母是哪 个。如果有多个字母出现的次数相等，输出字典序最小的那个。
 * 第二行包含一个整数，表示出现得最多的那个字母在单词中出现的次数。
 * 示例 1
 *输入 lanqiao
 *输出
 * a
 * 2
 */
public class Java11G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("");
        // 只能字符串数组只能转为List不能转为ArrayList数组。
        List<String> list = Arrays.asList(word);
        int max = 0;
        String maxs = null;
        for(int i = 0;i<list.size();i++){
            int ci = Collections.frequency(list, list.get(i));
            // 频次最大，或者频次与现有最大值相等但是字母的次序最小
            if(ci > max || (ci == max && (list.get(i).compareTo(maxs) == -1))) {
                max = ci;
                maxs = list.get(i);
            }
        }
        System.out.println(maxs);
        System.out.println(max);
    }
}
