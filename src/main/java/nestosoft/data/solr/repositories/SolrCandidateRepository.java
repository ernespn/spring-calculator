package nestosoft.data.solr.repositories;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;
import org.springframework.stereotype.Repository;

import nestosoft.data.solr.models.Candidate;

@Repository
public interface SolrCandidateRepository extends SolrCrudRepository<Candidate, String>{
	
}



