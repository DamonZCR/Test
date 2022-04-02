package es.test;
/**
 * 批量删除数据
 *
 * 和批量插入相同，都是使用了bulk()方法来执行打包请求；
 * 将多个请求放进bulk中去执行；
 */
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class B5_Doc_Delete_批量 {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("47.103.2.86", 9200, "http"))
        );

        // 批量删除数据
        BulkRequest request = new BulkRequest();

        request.add(new DeleteRequest().index("user").id("1001"));
        request.add(new DeleteRequest().index("user").id("1002"));
        request.add(new DeleteRequest().index("user").id("1003"));

        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());//执行时间
        System.out.println(response.getItems());//每条的执行结果

        esClient.close();
    }
}
