package es.test;
/**
 * 获取一个条数据
 * 注意是获取一条数据，所以需要指定ID；
 */

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class B3_Doc_GetOne {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("47.103.2.86", 9200, "http"))
        );

        // 查询数据
        GetRequest request = new GetRequest();
        request.index("user1").id("1001");
        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);

        System.out.println(response.getSourceAsString());
        esClient.close();
    }
}
