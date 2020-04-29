package com.java.spider.Repository.impl;

import com.java.spider.Repository.SolrRepository;
import com.java.spider.entity.Page;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: spider
 * @description:    solr数据访问层
 * @author: Jojo.Lee
 * @create: 2020-04-17 21:17
 **/

@Repository
public class SolrRepositoryImpl implements SolrRepository {

    @Autowired
    private SolrClient solrClient;

    @Override
    public Integer delById(Integer id) throws IOException, SolrServerException {

        UpdateResponse updateResponse =  solrClient.deleteById("spider",id.toString());
        solrClient.commit("spider");
        return updateResponse.getStatus();
    }

    @Override
    public void insert(Page page) {
        UpdateResponse updateResponse = null;
        try {
            updateResponse = solrClient.addBean("spider",page);
            int status = updateResponse.getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<String, Object> selectByParse(Page page, Integer start, Integer pageSiza) throws IOException, SolrServerException {

        SolrQuery solrQuery = new SolrQuery();
//        if (StringUtils.isNotBlank(page.getId().toString())){
//            solrQuery.addHighlightField(page.getId().toString());
//            solrQuery.set("id:"+page.getId());
//        }
        if (StringUtils.isNotBlank(page.getName())){
            solrQuery.set("name:"+page.getName());
            solrQuery.addHighlightField(page.getName());
        }

        if (StringUtils.isNotBlank(page.getCountry())) {
            solrQuery.set("country:"+page.getCountry());
            solrQuery.addHighlightField(page.getCountry());//需要添加的高亮显示的字段
        }
        if (StringUtils.isNotBlank(page.getLanguage())){
            solrQuery.set("language:"+page.getLanguage());
            solrQuery.addHighlightField(page.getLanguage());
        }
//        if (StringUtils.isNotBlank(page.getType())){
//            solrQuery.set("type:"+page.getType());
//            solrQuery.addHighlightField(page.getType());
//        }

        solrQuery.set("df","t_product_keywords");//复制域查询
        solrQuery.setStart(start);
        solrQuery.setRows(pageSiza);
        solrQuery.setHighlight(true);//启用高亮查询
        solrQuery.setHighlightSimplePre("<font color='red'>");//高亮前缀
        solrQuery.setHighlightSimplePost("</font>");//高亮后缀

        QueryResponse queryResponse = solrClient.query("spider", solrQuery);
        //获取数据总行数
        long numFound = queryResponse.getResults().getNumFound();
        System.out.println("总共获取多少条数据"+numFound);
        //获取普通结果
        List<Page> paegList = queryResponse.getBeans(Page.class);
        //获取高亮结果
        Map<String, Map<String, List<String>>> highlighting= queryResponse.getHighlighting();

        //将普通结果中的字段name替换为高亮后的值
        for (Page data : paegList){
            //获取高亮结果
            String name_high = highlighting.get(data.getId()).get("name").get(0);
            //替换
            data.setName(name_high);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("numFound",numFound);
        map.put("list",paegList);
        return map;
    }

    @Override
    public List selectAll() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();

        //设置查询条件
        query.setQuery("*:*");
        query.setStart(0);
        query.setRows(250);
        query.set("df","t_product_keywords");//复制域查询
        //执行查询
        QueryResponse response = solrClient.query(query);
        System.out.println(response);
        //取查询结果
        SolrDocumentList list = response.getResults();

        System.out.println("总共获取多少条数据"+list.getNumFound());
        return list;
    }

    //查询solr库



    public void testQueryFromSolr() throws IOException, SolrServerException {

        //        String keyword = "t_product_name:手机"; //指定字段查询
        //复制域查询
        String  keyword = "恋恋笔记本";
        //创建查询对象
        SolrQuery query = new SolrQuery();
        //往对象中设置参数
        query.set("df","t_product_keywords");//复制域查询
        query.setQuery(keyword);
        query.setStart(0);
        query.setRows(10);
        //高亮
//        query.addHighlightField("name");
//        query.setHighlight(true);
//        query.setHighlightSimplePre("<span style='color:red'>");
//        query.setHighlightSimplePost("</span>");
        //执行查询.得到响应结果
        QueryResponse response = solrClient.query(query);
        //        System.out.println(response);
        //封装结果集==> List<TProductSearchDTO>



        List<Page> products = new ArrayList<>();



        SolrDocumentList results = response.getResults();
        System.out.println(results);

//        for (SolrDocument document : results) {
//
//            Page product = new Page();
//
//            Integer id =document.getFieldValue("id"));
//
//            product.setId(id);
//
//            String t_product_name = (String) document.getFieldValue("t_product_name");
//
//            product.setName(t_product_name);
//
//            Float t_product_sale_price = (Float) document.getFieldValue("t_product_sale_price");
//
//            product.settProductSalePrice(new BigDecimal(t_product_sale_price));
//
//            String t_product_pimage = (String) document.getFieldValue("t_product_pimage");
//
//            product.settProductPimage(t_product_pimage);
//
//            String t_product_pdesc = (String) document.getFieldValue("t_product_pdesc");
//
//            product.settProductPdesc(t_product_pdesc);
//
//
//
//            products.add(product);
//
//
//
//        }
        System.out.println(products);

    }
}
