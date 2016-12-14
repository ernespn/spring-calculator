package nestosoft.data.solr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nestosoft.data.solr.models.Candidate;
import nestosoft.data.solr.repositories.SolrCandidateRepository;


@RestController
public class SolrController {
	@Autowired
	private SolrCandidateRepository candidateRepository;    
		
    @CrossOrigin
    @RequestMapping("/solr/save")
    public void save() {
        candidateRepository.save(new Candidate("11","Ernesto"));
        candidateRepository.save(new Candidate("12","John"));
    }
    
    @CrossOrigin
    @RequestMapping("/solr/")
    public Iterable<Candidate> findAll() {
        Iterable<Candidate> candidates = candidateRepository.findAll();
        return candidates;
    }
}
