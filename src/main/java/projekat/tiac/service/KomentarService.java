package projekat.tiac.service;

import java.util.List;
import java.util.Optional;

import projekat.tiac.model.Komentar;
import projekat.tiac.model.Post;

public interface KomentarService {
	
	public Komentar save (Long idPost, Komentar komentar);
	public Optional<Komentar> findOne(Long id);
	public List<Komentar> findByPost(Long idPost);
	public Komentar delete(Long id);
}
