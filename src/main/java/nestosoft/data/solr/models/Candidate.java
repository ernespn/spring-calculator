package nestosoft.data.solr.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "collection1")
public class Candidate{
	private @Id @Indexed String id;
	private @Indexed("NAME_FIELD_NAME") String name;
	
	public Candidate(String id, String name){
		this.id = id;
		this.name = name;
	}
}
