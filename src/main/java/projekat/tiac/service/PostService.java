package projekat.tiac.service;

import java.util.List;
import java.util.Optional;

import projekat.tiac.model.Post;

public interface PostService {
	
	public List<Post> findAll();
	public Optional<Post> findOne(Long id);
	public Post save (Post post);
	public Post delete (Long id);
	
	

}
