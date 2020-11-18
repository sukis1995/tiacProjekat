package projekat.tiac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projekat.tiac.model.Komentar;
import projekat.tiac.model.Post;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {
	@Query("Select k from Komentar k where k.post=:post ")
	public List<Komentar> findByPost(@Param("post") Post post);

}
