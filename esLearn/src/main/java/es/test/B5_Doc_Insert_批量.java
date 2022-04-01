package es.test;
/**
 * 批量插入数据
 *
 * 和批量删除相同，都是使用了bulk()方法来执行打包请求；
 * 将多个请求放进bulk中去执行；
 * 注意：它和单次插入的不同，单次插入时，source方法内放的是request对象和JOSN格式要求；
 * 批量插入放的是不限个数的 Object对象；
 */

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class B5_Doc_Insert_批量 {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("47.103.2.86", 9200, "http"))
        );

        // 批量插入数据
        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("user").id("10111").source(XContentType.JSON, "name", "ZLQ", "age",30,"sex","女"));
        request.add(new IndexRequest().index("user").id("10132").source(XContentType.JSON, "name", "ZLW", "age",23,"sex","男"));
        request.add(new IndexRequest().index("user").id("10143").source(XContentType.JSON, "name", "wxl", "age",23,"sex","女"));
        request.add(new IndexRequest().index("user").id("10154").source(XContentType.JSON, "name", "wu2", "age",50,"sex","男"));
        request.add(new IndexRequest().index("user").id("10165").source(XContentType.JSON, "name", "Damon", "age",50,"sex","男"));
        request.add(new IndexRequest().index("user").id("10176").source(XContentType.JSON, "name", "Daonzlw", "age",60,"sex","男"));
        request.add(new IndexRequest().index("user").id("10187").source(XContentType.JSON, "name", "胡佳凡", "age",60,"sex","男"));
        request.add(new IndexRequest().index("user").id("10198").source(XContentType.JSON, "name", "文昭", "age",60,"sex","男"));

        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());//打印花费时间
        System.out.println(response.getItems());//多个插入的每一个插入结果状态

        esClient.close();
    }
}
