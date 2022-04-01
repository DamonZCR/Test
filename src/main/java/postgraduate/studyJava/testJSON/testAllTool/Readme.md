测试四种JOSN工具的打包和解包速度性能；
这4个JSON类库分别为：Gson，FastJson，Jackson，Json-lib；
测量结果将输出至控制台：

如序列化性能结果输出：

```Java
Benchmark  (count)  Mode  Cnt   Score   Error  Units
FastJson     1000    ss        0.267           s/op
FastJson    10000    ss        0.471           s/op
FastJson   100000    ss        0.970           s/op
Gson         1000    ss        0.299           s/op
Gson        10000    ss        0.288           s/op
Gson       100000    ss        1.664           s/op
Jackson      1000    ss        0.557           s/op
Jackson     10000    ss        0.360           s/op
Jackson    100000    ss        0.702           s/op
JsonLib      1000    ss        0.615           s/op
JsonLib     10000    ss        3.735           s/op
JsonLib    100000    ss       14.224           s/op
```

发序列化结果输出：

```Java
Benchmark  (count)  Mode  Cnt   Score   Error  Units
FastJson     1000    ss        0.386           s/op
FastJson    10000    ss        0.360           s/op
FastJson   100000    ss        1.224           s/op
Gson         1000    ss        0.261           s/op
Gson        10000    ss        0.271           s/op
Gson       100000    ss        1.075           s/op
Jackson      1000    ss        0.350           s/op
Jackson     10000    ss        0.594           s/op
Jackson    100000    ss        1.015           s/op
JsonLib      1000    ss        1.122           s/op
JsonLib     10000    ss        3.774           s/op
JsonLib    100000    ss       27.381           s/op
```

代码需要的依赖添加：

```Java
<dependency>
    <!--json转换使用-->
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.62</version>
</dependency>
<!-- Json libs-->
<dependency>
    <groupId>net.sf.json-lib</groupId>
    <artifactId>json-lib</artifactId>
    <version>2.2.3</version>
    <classifier>jdk15</classifier>
</dependency>
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.3.1</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.12.5</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.12.5</version>
</dependency>
<!--测试JSON打包性能时使用，用于输出日志JDK日志信息-->
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-core</artifactId>
    <version>1.34</version>
</dependency>
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-generator-annprocess</artifactId>
    <version>1.34</version>
    <scope>provided</scope>
</dependency>
```

