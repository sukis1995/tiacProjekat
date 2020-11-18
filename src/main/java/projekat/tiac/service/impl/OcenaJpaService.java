package projekat.tiac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.tiac.model.Ocena;
import projekat.tiac.model.Post;
import projekat.tiac.repository.OcenaRepository;
import projekat.tiac.service.OcenaService;
import projekat.tiac.service.PostService;

@Service
public class OcenaJpaService implements OcenaService {
	@Autowired
	private OcenaRepository ocenaRepository;
	@Autowired
	private PostService postService;
	@Override
	public Ocena save(Long idPost,Ocena ocena) {
		Post post=null;
		if(postService.findOne(idPost).isPresent()) {
			post = postService.findOne(idPost).get();
		}else {
			return null;
		}
		if(ocena.getKorisnik().equals(post.getKorisnik())) {
			return null;
		}
		Ocena saved = ocenaRepository.save(ocena);
		postService.save(post);
		return saved;
	}
	
	

}
