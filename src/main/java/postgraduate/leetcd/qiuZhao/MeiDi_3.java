package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/** 美的-20220923
 * 第三题；
 * 森林中有一个老人，他会给迷路的人指路，但是他也会指出一些繁杂的出路，比如指向了东，西，南。就是往东走后，往西走，再往难走，
 * 实际中我们可以发现，往东走，再往西走是白花功夫，所以最简单的路线是直接往南走，所以协议程序，在输入一段方向以后，找到最终
 * 应该走的路线。
 * 如：
 * 东，西，南，北，北，东
 * 最简单的就是北、东；
 * 输入和输出都是英文的方向；
 */
public class MeiDi_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.substring(1, s.length() - 1).split(", ");

/*        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }*/
        //System.out.println(Arrays.toString(s1));
        Stack<String> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>(4);
        map.put("\"NORTH\"", "\"SOUTH\"");
        map.put("\"SOUTH\"", "\"NORTH\"");
        map.put("\"EAST\"", "\"WEST\"");
        map.put("\"WEST\"", "\"EAST\"");
        for (int i = 0; i < s1.length; i++) {
            if (!stack.isEmpty()){
                String s2 = map.get(stack.peek());
                if (s2.equals(s1[i])){
                    stack.pop();
                    i++;
                    continue;
                }else {
                    stack.add(s1[i]);
                }
            }
            stack.add(s1[i]);
        }
        System.out.println(stack);
    }
    public String[] dirReduc (String[] arr) {
        ArrayList<String> list = (ArrayList<String>) Arrays.asList(arr);
        Stack<String> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>(4);
        map.put("NORTH", "SOUTH");
        map.put("SOUTH", "NORTH");
        map.put("EAST", "WEST");
        map.put("WEST", "EAST");
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty()){
                String s2 = map.get(stack.peek());
                if (s2.equals(arr[i])){
                    stack.pop();
                    i++;
                    continue;
                }else {
                    stack.add(arr[i]);
                }
            }
            stack.add(arr[i]);
        }
        String[] res = new String[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
    public String[] dirReduc2 (String[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>(4);
        map.put("NORTH", "SOUTH");
        map.put("SOUTH", "NORTH");
        map.put("EAST", "WEST");
        map.put("WEST", "EAST");
        if (arr.length == 0)
            return new String[0];
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty()){
                String s2 = map.get(stack.peek());
                if (s2.equals(arr[i])){
                    stack.pop();
                    list.add(i);
                    i++;
                    continue;
                }else {
                    stack.add(arr[i]);
                }
            }
            stack.add(arr[i]);
        }
        String[] res = new String[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
