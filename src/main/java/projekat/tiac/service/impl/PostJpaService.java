package projekat.tiac.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.tiac.model.Post;
import projekat.tiac.repository.PostRepository;
import projekat.tiac.service.PostService;

@Service
public class PostJpaService implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public Optional<Post> findOne(Long id) {
		
		return postRepository.findById(id);
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}

	@Override
	public Post delete(Long id) {
		Optional<Post> deleted=findOne(id);
		if(deleted.isPresent()) {
			postRepository.delete(deleted.get());
			return deleted.get();
		}
		return null;
		
	}

}
