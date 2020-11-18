package projekat.tiac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import projekat.tiac.model.Uloga;
@Repository
public interface UlogaRepositroy extends JpaRepository<Uloga, Long> {
	
	@Query("Select u from Uloga u where u.uloga=:uloga")
	public Uloga findByNaziv(@Param("uloga") String uloga);

}
