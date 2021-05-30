package postgraduate.studyJava;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamTest {

    @Test
    public void test1(){
        // 方式一：使用集合实例化

        // 创建一个顺序流
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();
        // 创建一个并行流
        Stream<Integer> integerStream = list.parallelStream();
    }

    @Test
    public void test2(){

        // flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        List<String> list2 = Arrays.asList("aa", "bb", "cc", "dd");
        // flatMap 把所有的流变为统一的一个流。
        Stream<Character> characterStream = list2.stream().flatMap(StreamTest::fromStringToStream);
        characterStream.forEach(System.out::println);
    }
    public static Stream<Character> fromStringToStream(String str){//aa
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test(){
        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        // filter 内部使用lambda表达式，筛选出为True的条件。
        // forEach 的参数是一个消费者，应该使用方法引用。
        stream.filter(x-> x > 2).forEach(System.out::println);
        int n=1;
    }

    @Test
    public void test3(){
        // 收集操作中，有可以将字符串连接起来的方法。
        String[] ss = {"aa", "bb", "cc", "dd"};
        Stream<String> stream = Arrays.stream(ss);
        String collect = stream.collect(Collectors.joining());
        System.out.println(collect);

        // 还有计算整数平均值、求和的方法。
    }

}
