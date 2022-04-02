package es.test;
//查看某一个索引
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class A3_Index_Search {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("47.103.2.86", 9200, "http"))
        );
        // 查询索引
        GetIndexRequest request = new GetIndexRequest("user1");

        GetIndexResponse getIndexResponse =
                esClient.indices().get(request, RequestOptions.DEFAULT);
        // 响应状态
        System.out.println(getIndexResponse.getAliases());//索引别名
        System.out.println(getIndexResponse.getMappings());//索引的结构映射
        System.out.println(getIndexResponse.getSettings());//索引的设置，了解

        esClient.close();
    }
}
