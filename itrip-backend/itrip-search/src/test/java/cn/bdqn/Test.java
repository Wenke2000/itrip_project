package cn.bdqn;

import cn.bdqn.pojo.Hotel;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.List;

/**
 * Created by shang-pc on 2017/7/3.
 */
public class Test {

    public static String url = "http://127.0.0.1:8088/solr/test1/";

    public static void main(String[] args) {
        //初始化HttpSolrClient
        HttpSolrClient httpSolrClient = new HttpSolrClient(url);

        httpSolrClient.setParser(new XMLResponseParser()); //设置响应解析器
        httpSolrClient.setConnectionTimeout(500); // 建立连接的最长时间

        //初始化SolrQuery
        SolrQuery solrQuery = new SolrQuery("*:*");
        solrQuery.setSort("id", SolrQuery.ORDER.desc);
        //一页显示多少条
        solrQuery.setStart(0);
        solrQuery.setRows(10);

        QueryResponse queryResponse = null;
        try {
            queryResponse = httpSolrClient.query(solrQuery);
            //从响应对象中取出数据
            List<Hotel> list = queryResponse.getBeans(Hotel.class);
            for (Hotel hotel:list){
                System.out.println(hotel);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
