package projekat.tiac.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.tiac.model.Komentar;
import projekat.tiac.model.Post;
import projekat.tiac.repository.KomentarRepository;
import projekat.tiac.service.KomentarService;
import projekat.tiac.service.PostService;

@Service
public class KomentarJpaService implements KomentarService {
	@Autowired
	private KomentarRepository komentarRepositroy;
	@Autowired
	private PostService postService;

	
	@Override
	public Komentar save(Long idPost, Komentar komentar) {
		Optional<Post> post=  postService.findOne(idPost);
		if(!post.isPresent()) {
			return null;
		}
		komentar.setPost(post.get());
		Komentar saved=komentarRepositroy.save(komentar);
		postService.save(post.get());
		return saved;
	}


	@Override
	public Optional<Komentar> findOne(Long id) {
		// TODO Auto-generated method stub
		return komentarRepositroy.findById(id);
	}


	@Override
	public List<Komentar> findByPost(Long idPost) {
		Optional<Post> post= postService.findOne(idPost);
		if(!post.isPresent()) {
			return null;
		}
		return komentarRepositroy.findByPost(post.get());
	}


	@Override
	public Komentar delete(Long id) {
		Optional<Komentar> komentarOptional=findOne(id);
		if(!komentarOptional.isPresent()) {
			return null;
		}
		komentarRepositroy.deleteById(id);
		return komentarOptional.get();
		
	}
	
	

}
