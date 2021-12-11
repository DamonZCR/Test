使用 ContextValueFilter 配置 JSON 转换
https://www.runoob.com/w3cnote/fastjson-intro.html
在某些场景下，对Value做过滤，需要获得所属JavaBean的信息，包括类型、字段、方法等。
在fastjson-1.2.9中，提供了ContextValueFilter，类似于之前版本提供的ValueFilter，只是多了BeanContext参数可用。

@Test
public void givenContextFilter_whenJavaObject_thanJsonCorrect() {
    ContextValueFilter valueFilter = new ContextValueFilter () {
        public Object process(
          BeanContext context, Object object, String name, Object value) {
            if (name.equals("DATE OF BIRTH")) {
                return "NOT TO DISCLOSE";
            }
            if (value.equals("John")) {
                return ((String) value).toUpperCase();
            } else {
                return null;
            }
        }
    };
    String jsonOutput = JSON.toJSONString(listOfPersons, valueFilter);
}
以上实例中我们隐藏了 DATE OF BIRTH 字段，并过滤名字不包含 John 的字段：

[
    {
        "FULL NAME":"JOHN DOE",
        "DATE OF BIRTH":"NOT TO DISCLOSE"
    }
]

使用 NameFilter 和 SerializeConfig
NameFilter: 序列化时修改 Key。
SerializeConfig：内部是个map容器主要功能是配置并记录每种Java类型对应的序列化类。
@Test
public void givenSerializeConfig_whenJavaObject_thanJsonCorrect() {
    NameFilter formatName = new NameFilter() {
        public String process(Object object, String name, Object value) {
            return name.toLowerCase().replace(" ", "_");
    }
};
    SerializeConfig.getGlobalInstance().addFilter(Person.class,  formatName);
    String jsonOutput =
      JSON.toJSONStringWithDateFormat(listOfPersons, "yyyy-MM-dd");
}
实例中我们声明了 formatName 过滤器使用 NameFilter 匿名类来处理字段名称。 新创建的过滤器与 Person 类相关联，然后添加到全局实例，它是 SerializeConfig 类中的静态属性。
现在我们可以轻松地将对象转换为JSON格式。
注意我们使用的是 toJSONStringWithDateFormat() 而不是 toJSONString() ，它可以更快速的格式化日期。
输出结果：

[  
    {  
        "full_name":"John Doe",
        "date_of_birth":"2016-07-21"
    },
    {  
        "full_name":"Janette Doe",
        "date_of_birth":"2016-07-21"
    }
]