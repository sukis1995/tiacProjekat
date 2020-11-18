package projekat.tiac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projekat.tiac.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	@Query("Select k from Korisnik k where k.username=:username")
	public Korisnik findByUsername(@Param("username") String username);

}
