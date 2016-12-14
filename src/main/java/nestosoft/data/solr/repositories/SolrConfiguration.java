package nestosoft.data.solr.repositories;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages={"nestosoft.data.solr"}, multicoreSupport=true)
public class SolrConfiguration {
	 static final String SOLR_HOST = "solr.host";

	  @Resource private Environment environment;

	  @Bean
	    public SolrClient solrServerFactoryBean() {
		  String solrhost = environment.getRequiredProperty(SOLR_HOST); 
		  return new HttpSolrClient(solrhost);
	    }
}
