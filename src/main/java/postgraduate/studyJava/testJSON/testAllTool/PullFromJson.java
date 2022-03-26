package postgraduate.studyJava.testJSON.testAllTool;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import postgraduate.studyJava.testJSON.testAllTool.model.Person;
import postgraduate.studyJava.testJSON.testAllTool.utils.FastJsonUtil;
import postgraduate.studyJava.testJSON.testAllTool.utils.GsonUtil;
import postgraduate.studyJava.testJSON.testAllTool.utils.JacksonUtil;
import postgraduate.studyJava.testJSON.testAllTool.utils.JsonLibUtil;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Benchmark                                             (count)  Mode  Cnt   Score   Error  Units
 * studyJava.testJSON.testAllTool.PullFromJson.FastJson     1000    ss        0.386           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.FastJson    10000    ss        0.360           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.FastJson   100000    ss        1.224           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.Gson         1000    ss        0.261           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.Gson        10000    ss        0.271           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.Gson       100000    ss        1.075           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.Jackson      1000    ss        0.350           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.Jackson     10000    ss        0.594           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.Jackson    100000    ss        1.015           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.JsonLib      1000    ss        1.122           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.JsonLib     10000    ss        3.774           s/op
 * studyJava.testJSON.testAllTool.PullFromJson.JsonLib    100000    ss       27.381           s/op
 */
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class PullFromJson {
    /**
     * 反序列化次数参数
     */
    @Param({"1000", "10000", "100000"})
    private int count;

    private String jsonStr;

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(PullFromJson.class.getSimpleName())
                .forks(1)
                .warmupIterations(0)
                .build();
        Collection<RunResult> results =  new Runner(opt).run();
        System.out.println(results);
    }

    @Benchmark
    public void JsonLib() {
        for (int i = 0; i < count; i++) {
            JsonLibUtil.json2Bean(jsonStr, Person.class);
        }
    }

    @Benchmark
    public void Gson() {
        for (int i = 0; i < count; i++) {
            GsonUtil.json2Bean(jsonStr, Person.class);
        }
    }

    @Benchmark
    public void FastJson() {
        for (int i = 0; i < count; i++) {
            FastJsonUtil.json2Bean(jsonStr, Person.class);
        }
    }

    @Benchmark
    public void Jackson() {
        for (int i = 0; i < count; i++) {
            JacksonUtil.json2Bean(jsonStr, Person.class);
        }
    }

    @Setup
    public void prepare() {
        jsonStr= "{\"name\":\"邵同学\",\"fullName\":{\"firstName\":\"zjj_first\",\"middleName\":\"zjj_middle\",\"lastName\":\"zjj_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":[{\"name\":\"小明\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null},{\"name\":\"Tony\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null},{\"name\":\"陈小二\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null}]}";
    }

    @TearDown
    public void shutdown() {
    }
}
