package es.test;
/**
 * 插入数据
 * 向ES中插入一个数据，ES支持插入的是JSON格式，所以Java插入想要对象附属性，
 * 然后通过json工具打包成JSON；
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class B1_Doc_Insert {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("47.103.2.86", 9200, "http"))
        );

        // 插入数据
        IndexRequest request = new IndexRequest();
        //request.index("user1").id("1001");//自定义一个主键
        request.index("user");//系统生成主键

        //封装数据
        User user = new User();
        user.setName("wangwu333");
        user.setAge(23);
        user.setSex("男");

        // 向ES插入数据，必须将数据转换为JSON格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        //将数据封装到request请求中，指定类型为JSON格式；
        request.source(userJson, XContentType.JSON);
        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());

        esClient.close();
    }
}
