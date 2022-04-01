package postgraduate.studyJava.testJSON.testAllTool;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import postgraduate.studyJava.testJSON.testAllTool.model.FullName;
import postgraduate.studyJava.testJSON.testAllTool.model.Person;
import postgraduate.studyJava.testJSON.testAllTool.utils.FastJsonUtil;
import postgraduate.studyJava.testJSON.testAllTool.utils.GsonUtil;
import postgraduate.studyJava.testJSON.testAllTool.utils.JacksonUtil;
import postgraduate.studyJava.testJSON.testAllTool.utils.JsonLibUtil;

import java.util.*;
import java.util.concurrent.TimeUnit;

/** 将对象序列化
 * Benchmark                                           (count)  Mode  Cnt   Score   Error  Units
 * studyJava.testJSON.testAllTool.PushToJson.FastJson     1000    ss        0.267           s/op
 * studyJava.testJSON.testAllTool.PushToJson.FastJson    10000    ss        0.471           s/op
 * studyJava.testJSON.testAllTool.PushToJson.FastJson   100000    ss        0.970           s/op
 * studyJava.testJSON.testAllTool.PushToJson.Gson         1000    ss        0.299           s/op
 * studyJava.testJSON.testAllTool.PushToJson.Gson        10000    ss        0.288           s/op
 * studyJava.testJSON.testAllTool.PushToJson.Gson       100000    ss        1.664           s/op
 * studyJava.testJSON.testAllTool.PushToJson.Jackson      1000    ss        0.557           s/op
 * studyJava.testJSON.testAllTool.PushToJson.Jackson     10000    ss        0.360           s/op
 * studyJava.testJSON.testAllTool.PushToJson.Jackson    100000    ss        0.702           s/op
 * studyJava.testJSON.testAllTool.PushToJson.JsonLib      1000    ss        0.615           s/op
 * studyJava.testJSON.testAllTool.PushToJson.JsonLib     10000    ss        3.735           s/op
 * studyJava.testJSON.testAllTool.PushToJson.JsonLib    100000    ss       14.224           s/op
 */
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class PushToJson {
    /**
     * 序列化次数参数
     */
    @Param({"1000", "10000", "100000"})
    private int count;

    private Person p;

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(PushToJson.class.getSimpleName())
                .forks(1)
                .warmupIterations(0)
                .build();
        Collection<RunResult> results =  new Runner(opt).run();
        System.out.println(results);
    }

    @Benchmark
    public void JsonLib() {
        for (int i = 0; i < count; i++) {
            JsonLibUtil.bean2Json(p);
        }
    }

    @Benchmark
    public void Gson() {
        for (int i = 0; i < count; i++) {
            GsonUtil.bean2Json(p);
        }
    }

    @Benchmark
    public void FastJson() {
        for (int i = 0; i < count; i++) {
            FastJsonUtil.bean2Json(p);
        }
    }

    @Benchmark
    public void Jackson() {
        for (int i = 0; i < count; i++) {
            JacksonUtil.bean2Json(p);
        }
    }

    @Setup
    public void prepare() {
        List<Person> friends=new ArrayList<Person>();
        friends.add(createAPerson("小明",null));
        friends.add(createAPerson("Tony",null));
        friends.add(createAPerson("陈小二",null));
        p=createAPerson("邵同学",friends);
    }

    @TearDown
    public void shutdown() {
    }

    private Person createAPerson(String name,List<Person> friends) {
        Person newPerson=new Person();
        newPerson.setName(name);
        newPerson.setFullName(new FullName("zjj_first", "zjj_middle", "zjj_last"));
        newPerson.setAge(24);
        List<String> hobbies=new ArrayList<String>();
        hobbies.add("篮球");
        hobbies.add("游泳");
        hobbies.add("coding");
        newPerson.setHobbies(hobbies);
        Map<String,String> clothes=new HashMap<String, String>();
        clothes.put("coat", "Nike");
        clothes.put("trousers", "adidas");
        clothes.put("shoes", "安踏");
        newPerson.setClothes(clothes);
        newPerson.setFriends(friends);
        return newPerson;
    }
}