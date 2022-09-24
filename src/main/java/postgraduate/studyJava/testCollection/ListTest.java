package postgraduate.studyJava.testCollection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Arrays.asList() 生成的ArrayList() 与自己去定义出来的ArrayList不同，生成的只是Arrays的内部类。详细参见 test3 及test3_2。
 */
public class ListTest {
    public static void main(String[] args) {
        // ArrayList 初始化时传入初始化值，调用 .size()函数后返回仍为0.因为size()代表元素个数，不是初始空间大小。
        int n = 3;
        int[] xx = {1,2,3,4};
        ArrayList list = new ArrayList(n);
        ArrayList list1 = new ArrayList(6);
        ArrayList list2 = new ArrayList(xx.length);
        // 0， 0， 0
        System.out.println(list.size());
        System.out.println(list1.size());
        System.out.println(list2.size());
    }
    @Test
    public void test1(){
        // Java 1.8新增forEach() 方法，参数使用lambda表达式。
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        // List 中的 set() 修改某一个元素的值。
        list.set(0, 99);
        list.forEach(System.out::println);
    }
    @Test
    public void test2(){
        // 如何删除列表中某一个重复出现元素，如[1,2,4,2,5,8,2]，删除里面全部的 2 ----->[1,4,5,8]
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(2);

        // list.remove(new Integer(2));remove() 只能删除第一次出现的元素
        List<Integer> excut = new ArrayList();
        excut.add(2);
        list.removeAll(excut);
        list.forEach(System.out::println);
    }
    @Test
    public void test3(){
        // 使用add操作 和 remove操作都会报这个错误： java.lang.UnsupportedOperationException
        /**
         * 调用Arrays.asList()生产的List的add、remove方法时报异常，这是由Arrays.asList() 返回的市Arrays的内部类ArrayList，
         * 而不是java.util.ArrayList。Arrays的内部类ArrayList和java.util.ArrayList都是继承AbstractList，remove、add等方法
         * AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。java.util.ArrayList重新了这些方法
         * 而Arrays的内部类ArrayList没有重新，所以会抛出异常。
         */
        String[] array = {"1","2","3","4","5"};
        List<String> list = Arrays.asList(array);
        list.add("6");
    }
    @Test
    public void test3_2(){
        // test3 的正确形式，应该使用新的不是Arrays内部类得ArrayList 进行重新定义。
        String[] array = {"1","2","3","4","5"};
        List<String> list = Arrays.asList(array);
        List arrList = new ArrayList(list);
        arrList.add("6");
    }
    @Test
    public void test4(){
        // disjoint(Collection c1, Collection c2)如果两个指定的集合没有共同的元素，则返回true 。
        List arrList = new ArrayList();
        arrList.add("9");arrList.add("2");
        arrList.add("3");arrList.add("4");

        List arrList2 = new ArrayList();
        arrList2.add("6");arrList2.add("7");
        arrList2.add("8");arrList2.add("9");

        boolean res = Collections.disjoint(arrList, arrList2);
        System.out.println(res);
        // fill(List list, T obj)用指定的元素代替指定列表的所有元素。
        Collections.fill(arrList, 1);
        arrList.forEach(s-> System.out.print(s + " "));


        //注意：填充后，不一定就是存在元素，如果这个集合原本就是空的，那么填充后size仍为0。如果原来有元素如上，就是把原来的元素填充为指定元素。
        ArrayList list = new ArrayList();
        Collections.fill(list, 3);
        list.forEach(t -> System.out.println(t + " "));
        System.out.println(list.size());
    }
    @Test
    public void test5(){
        // disjoint(Collection c1, Collection c2)如果两个指定的集合没有共同的元素，则返回true 。
        List arrList = new ArrayList();
        arrList.add(0, "9");
        arrList.add(0, "2");
        arrList.add(0, "3");
        arrList.add(0, "4");

        arrList.forEach(s-> System.out.print(s + " "));//4 3 2 9
    }
    @Test
    public void test6(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
/*        list.add(2);
        list.add(5);
        list.add(0);*/
        System.out.println(list);

        list.sort((t1, t2) -> t2 > t1 ? 1 : -1);
        System.out.println(list);
    }
    //list中使用流可以去重；
    @Test
    public void test7(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(0);
        list.add(0);
        System.out.println(list);
        //List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        list = list.stream().distinct().collect(Collectors.toList());

        System.out.println(list);
    }
    @Test
    public void test8(){
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> nums = new ArrayList<>();
        while (sc.hasNext()){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            nums.add(new int[]{t1, t2});
        }
        Collections.sort(nums, (int[] a, int[] b) -> (a[0] - b[0]));
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i)[0] + " " + nums.get(i)[1]);
        }
    }
}
