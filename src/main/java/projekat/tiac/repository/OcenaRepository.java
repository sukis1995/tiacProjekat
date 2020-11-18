package projekat.tiac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekat.tiac.model.Ocena;
@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {

}
