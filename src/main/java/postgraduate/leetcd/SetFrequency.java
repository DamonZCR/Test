package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
// hashmap 对值排序。compartTo 和equals
/**
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率,按字母顺序排序。
 * 案例1：
 * i love leetcode i love coding
 * 2
 * 结果输出：
 * [i, love]
 *  * 解析: "i" 和"love“为出现次数最多的两个单词，均为2次。注意，按字母顺序"i在"love'之前。
 * 案例2：
 * the day is sunny the the the sunny is is
 * 4
 * 结果输出：
 * [the, is, sunny, day]
 */
public class SetFrequency {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        solve(s, k);
        topKFrequent(s, k);
    }
    // 方法一，自己写的。与方法二思想相同，但是实现上更复杂。
    public static void solve(String[] words, int k) {
        ArrayList list = new ArrayList(Arrays.asList(words));
        List<String> collect = Arrays.stream(words).distinct().collect(Collectors.toList());
        HashMap<String, Integer> linlist;
        ArrayList<HashMap<String, Integer>> allele = new ArrayList(collect.size());
        for (String i :
                collect) {
            linlist = new HashMap<>(2);
            int fre = Collections.frequency(list, i);
            linlist.put(i, fre);
            allele.add(linlist);
        }
        list.clear();
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof HashMap && o2 instanceof HashMap){
                    HashMap<String, Integer> s1 = (HashMap<String, Integer>) o1;
                    HashMap<String, Integer> s2 = (HashMap<String, Integer>) o2;

                    Set<Map.Entry<String, Integer>> ent1 = s1.entrySet();
                    Iterator<Map.Entry<String, Integer>> it1 = ent1.iterator();
                    Map.Entry<String, Integer> next1 = it1.next();
                    String key1 = next1.getKey();
                    Integer val1 = next1.getValue();

                    Set<Map.Entry<String, Integer>> ent2 = s2.entrySet();
                    Iterator<Map.Entry<String, Integer>> it2 = ent2.iterator();
                    Map.Entry<String, Integer> next2 = it2.next();
                    String key2 = next2.getKey();
                    Integer val2 = next2.getValue();

                    int val = val1.compareTo(val2);
                    if (val == 0){
                        return key1.compareTo(key2);
                    }else
                        return -val;
                }else
                    throw new RuntimeException("异常！");
            }
        };
        allele.sort(comparator);

        for(int j = 0;j < k;j++){
            HashMap<String, Integer> outmap = allele.get(j);
            Set<String> strings = outmap.keySet();
            Iterator<String> iterator = strings.iterator();
            String next = iterator.next();
            list.add(next);
        }
        System.out.println(list);
    }
    //方法二，使用一个Map 来存储字符串和对应的频率。
    public static void topKFrequent(String[] words, int k) {
        // Map 保存某个值 出现的频率。
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        // list 存储每一个字符串值（不重复）。
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }

        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        System.out.println(rec.subList(0, k));
    }
}
