package projekat.tiac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.tiac.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
