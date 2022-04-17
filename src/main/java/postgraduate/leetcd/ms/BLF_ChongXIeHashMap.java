package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/** 20220414-便利蜂笔试-第三题
 * 自定义简单的hashmap
 * 自己实现一个简单的hashmap,包括
 * 1.一个表示hashmap的数据结构
 * 2一些基本机制,如:哈希,扩容
 * 3.put/get/remove方法
 * 注意
 * 1.请不要使用语言内置的map/hashmap/hashtable/list/arraylist/linkedlist/vector/set等数据结构2.你可以使用语言内置的基本数据类型,实现你自己的数据结构/类
 * 3.为简单起见,本题目中你可以默认key都是整数，value都是字符串
 * 输入描述
 * 第一行输入—个整数N,表示操作的个数(0 <= N <= 10000)
 * 接下来N行输入操作信息，共有三种操作: put/get/remove,各操作信息格式如下:
 * put:> key,value
 * get:<key
 * remove:Xkey
 * 输出描述
 * put和remove无输出;
 * get输出:
 * ①如果正常查询到,返回value:
 * ②如果该key不存在,返回”_EMPTY_"
 * 样例输入
 * 7
 * >1,aaa
 * <1
 * >1, ccc
 * <1
 * X1
 * <1
 * <2
 * 样例输出
 * aaa
 * ccc
 * _EMPTY_
 * _EMPTY_
 */
public class BLF_ChongXIeHashMap {
    class Entry{
        public Integer key;
        public String value;
        Entry next;
        public Entry (int key, String value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    final float DEFAULT_LOAD_FACTOR = 0.75f;
    int size = 16;
    Entry[] table;
    float load = 0f;
    public BLF_ChongXIeHashMap(){
        table = new Entry[size];
    }

    public synchronized void put(Integer key, String val){
        int index = key & (size - 1);
        if (table[index] != null){
            Entry node = table[index];
            while (node.next != null && !node.key.equals(key)){
                node = node.next;
            }
            if (node.key.equals(key)){
                node.value = val;
            }else {
                node.next = new Entry(key, val);
            }
        } else {
            Entry entry = new Entry(key, val);
            table[index] = entry;
        }
        //return val;
    }
    public synchronized String get(Integer key){
        int index = key & (size - 1);
        String val = "_EMPTY_";
        if (table[index] != null){
            Entry node = table[index];
            while (node.next != null && !node.key.equals(key)){
                node = node.next;
            }
            if (node.key.equals(key)){
                val = node.value;
            }
        }
        return val;
    }
    public synchronized void remove(Integer key){
        int index = key & (size - 1);
        if (table[index] != null){
            Entry node = table[index];
            Entry nt = node.next;
            if (node.key.equals(key)){
                node = node.next;
                table[index] = node;
                //System.out.println(node);
            }
            else {
                while (nt.next != null && !nt.key.equals(key)){
                    nt = nt.next;
                    node = node.next;
                }
                if (nt.key.equals(key)){
                    node.next = nt.next;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BLF_ChongXIeHashMap test = new BLF_ChongXIeHashMap();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[num];
        for (int i = 0; i < num; i++) {
            s[i] = br.readLine();
            String[] s1 = s[i].split("");

            if (s1[0].equals(">")){
                String s2 = s[i].substring(1, s[i].length());
                String[] s3 = s2.split(",");
                int xxxx = Integer.parseInt(s3[0]);
                test.put(xxxx, String.valueOf(s3[1]));
            }else if (s1[0].equals("<")){
                String s4 = test.get(Integer.parseInt(s[i].substring(1, s[i].length())));
                System.out.println(s4);
            }else{
                String s2 = s[i].substring(1, s[i].length());
                test.remove(Integer.parseInt(s2));
            }
        }
    }
}
