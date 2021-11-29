package postgraduate.studyJava.testCollection;
/*
*测试使用Arrays的内部方法：
* ① Arrays.sort() 排序从小到大排序。
* ② Arrays.sort(Object[] array, int from, int to)对数组元素指定范围进行排序（排序范围是从元素下标为from,到下标为to-1的元素进行排序）
* ③ Arrays.fill(Object[] array,Object object) 可以为数组元素填充相同的值
* ④ Arrays.fill(Object[] array,int from,int to,Object object) 对数组的部分元素填充一个值,从起始位置到结束位置，取头不取尾
* ⑤ Arrays.toString(Object[] array) 返回数组的字符串形式
* ⑥ Arrays.deepToString(Object[][] arrays) 返回多维数组的字符串形式
* ⑦ Arrays.copyOf(原数组, 空数组长度) 数组的拷贝，数组长度给的过长则后面加0.给的过短只复制前几位。
* ⑧ Arrays.binarySerch(目标数组, 值) 二分查找，找到则定位返回元素下标.(数组必须经过sort排序，即已经是从小到大，
*   如果未排序，则结果未定义。如果数组包含多个具有指定值的元素，则无法保证找到哪个元素。)
* ⑨ Arrays.equals(nums, nums1) 比较两个数组是否相等，可能类似于ArrayList,对于自己定义的对象需要重写equals()方法。
 */
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTest {

    @Test
    public void test1(){
        int[] nums = {2, 5, 1, -15, 12, 6};

        //方法一：sort() 排序从小到大排序。
        Arrays.sort(nums);
        for (int i :nums){
            System.out.print(i+" ");
        }
        int[] nums2 = {2, 5, 1, -15, 3, 6};

        //方法二：sort(Object[] array, int from, int to)
        Arrays.sort(nums2, 0, 4);//取头不取尾
        System.out.print("\n");
        for(int i :nums2){
            System.out.print(i+" ");
        }
    }
    @Test
    public void test2(){
        int[] nums = {2, 5, 1, -15, 12, 6};

        //Arrays.fill(Object[] array,Object object)
        Arrays.fill(nums, 1);
        for (int i :nums){
            System.out.print(i+" ");
        }

        int[] nums2 = {2, 5, 1, -15, 12, 6};

        //Arrays.fill(Object[] array,Object object)
        Arrays.fill(nums2, 0, 4, 1);
        System.out.print("\n");
        for (int i :nums2){
            System.out.print(i+" ");
        }
    }
    @Test
    public void test3(){
        int[] nums = {2, 5, 1, -15, 12, 6};

        //Arrays.toString(Object[] array) 返回数组的字符串形式
        System.out.println(Arrays.toString(nums));

        int[][] nums2 = {{2, 5, 1}, {-15, 12, 6}};

        //Arrays.deepToString(Object[][] arrays)返回多维数组的字符串形式
        System.out.println(Arrays.deepToString(nums2));
    }
    @Test
    public void test4(){
        int[] nums = {2, 5, 1, -15, 12, 6};
        int[] nums1 = null;
        //Arrays.copyOf(原数组, 空数组长度) 数组的拷贝
        nums1 = Arrays.copyOf(nums, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {2, 5, 1, -15, 12, 6};

        //Arrays.binarySerch(目标数组, 值) 二分查找，找到则定位返回元素下标
        System.out.println(Arrays.binarySearch(nums2, 12));
    }
    @Test
    public void test5(){
        int[] nums = {2, 5, 1, -15, 12, 6};
        int[] nums1 = {2, 5, 1, -15, 4, 6};

        //Arrays.equals(nums, nums1) 比较两个数组是否相等。
        boolean bb = Arrays.equals(nums, nums1);
        System.out.println(bb);

    }

    @Test
    public void test6(){
        // 将数字数组转为List。JDK8及以上中专用。
        int[] nums = {2, 5, 1, -15, 12, 6};
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.print(" " + it.next());
        }
    }
    @Test
    public void test7(){
        // 仅使用字符串数组
        String[] nums = {"中","dddd","zlw"};
        List<String> list = Arrays.asList(nums);
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.print(" " + it.next());
        }
    }
    @Test
    public void test8(){
        // 整数数组转为List对象
        // 使用Integer 声明可以直接转换
        Integer[] num = {1, 2, 3, 4};
        List list = Arrays.asList(num);

        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.print(" " + it.next());
        }
    }

    @Test
    public void test9(){
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
    public void test9_2(){
        // test9 的正确形式，应该使用新的不是Arrays内部类得ArrayList 进行重新定义。
        String[] array = {"1","2","3","4","5"};
        List<String> list = Arrays.asList(array);
        List arrList = new ArrayList(list);
        arrList.add("6");
    }
}

