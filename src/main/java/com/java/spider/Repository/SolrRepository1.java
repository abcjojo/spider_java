package com.java.spider.Repository;

import com.java.spider.entity.Page;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface SolrRepository1 extends SolrCrudRepository<Page,Integer> {

}
