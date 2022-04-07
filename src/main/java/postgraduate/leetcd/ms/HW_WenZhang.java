package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 华为-文章词汇频率-凉凉
 * 输入带有标题的文章，输出出现频率最高的前topN个词汇，如果一个词语在标题出现一次，就记为3次，
 * 文章中出现1次就为1次。如果出现了相同频率的次数，那就以标题为先，文章其次。否则按照第一次的出现
 * 先后顺序；
 * 输入
 * 第一行输入为正整教数N文章教M，即要输出的出现频率最高的间语
 * 的个数和处理的文章的数量，由于每篇文章被处理为标题和正文2行，
 * 因此后面有2*M行数据。
 * 从第二行起，是按顺序处理后每篇文章的标题串和正文串，即第二行是
 * 第一篇文章的标题串，第三行是第一篇文章的正文串， 第四行是第二篇
 * 文章的标题串，第五行是第二篇文章的正文串，以此类推。
 * 参数限制如下:
 * 0<topN<1000
 * 0<M<100000
 * 0<每篇文章的词语数<5000
 * 输出
 * 使用一行输独出现频率最高的N个词语，每个词调头" "隔开，
 * 案例：
 * 3 2
 * xinguan feiyan xinzeng bendi quezhen anli
 * ju baodao chengdu xinzeng xinguan feiyan bendi quezhen anli yili shenzhen xinzeng bendi quezhen anli liangli yiqing zhengti kongzhi lianghao
 * xinguan yimiao linchuang shiyan
 * wuzhong xinguan yimiao tongguo sanqi linchaung shiyan xiaoguo lianghao
 *
 * 1 2
 * xinguan feiyan xinzeng bendi quezhen anli
 * ju baodao chengdu xinzeng xinguan feiyan bend quezhen anli yili shenzhen xinzeng bendi quezhen anli liangh yiqing zhengti kongzhi lianghao
 * xinguan yimiao linchuang shiyan
 * wuzhong xinguan yimiao tnggo sanqi inchaung shlyanxiaoguo lianghao
 */
public class HW_WenZhang {
    public static void main(String[] args) throws IOException {
        int N;
        int m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sss = br.readLine();
        N = Integer.parseInt(sss.split(" ")[0]);
        m = Integer.parseInt(sss.split(" ")[1]);
        String[] seq = new String[m * 2];
        for (int i = 0; i < m * 2; i++) {
            seq[i] = br.readLine();
        }
        solve(seq, N);
    }
    public static void solve(String[] seq, int N) throws IOException {
        Map<String, int[]> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < seq.length; i++) {
            String[] words = seq[i].split(" ");
            int k = 0;
            if ((i & 1) == 0){
                k = 3;
                for (int j = 0; j < words.length; j++) {
                    map1.put(words[j], map1.getOrDefault(words[j],0)+1);
                }
            }else
                k = 1;
            for (int j = 0; j < words.length; j++) {
                int[] no = new int[3];
                no[0] = map.getOrDefault(words[j], new int[3])[0] + k;
                no[1] = map1.getOrDefault(words[j], 0);
                if (set.contains(words[j])){
                    no[2] = map.get(words[j])[2];
                }else{
                    no[2] = set.size() + 1;
                    set.add(words[j]);
                }
                map.put(words[j], no);
            }
        }
        String[] nword = new String[map.size()];
        Iterator<String> iterator = map.keySet().iterator();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = 0;
                //while (i < o1.length && o1[i] == o2.length){
                while (i < o1.length && o1[i] == o2[i]){
                    i++;
                }
                if(i == o1.length)
                    return 0;
                return o2[i] - o1[i];
            }
        });
        int i = 0;
        while (iterator.hasNext()){
            nword[i] = iterator.next();
            int[] mo = new int[4];
            int[] tmp = map.get(nword[i]);
            mo[0] = tmp[0];
            mo[1] = tmp[1];
            mo[2] = set.size() - tmp[2];
            mo[3] = i;
            queue.add(mo);
            i++;
        }
        while (N > 0){
            System.out.println(nword[queue.poll()[3]]);
            N--;
        }
    }
}
