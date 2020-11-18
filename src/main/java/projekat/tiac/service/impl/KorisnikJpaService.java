package projekat.tiac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.tiac.model.Korisnik;
import projekat.tiac.repository.KorisnikRepository;
import projekat.tiac.service.KorisnikService;

@Service
public class KorisnikJpaService implements KorisnikService {
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Override
	public List<Korisnik> findAll() {
		// TODO Auto-generated method stub
		return korisnikRepository.findAll();
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		// TODO Auto-generated method stub
		return korisnikRepository.save(korisnik);
	}

	@Override
	public Korisnik findOne(Long id) {
		if(korisnikRepository.findById(id).isPresent()) {
			return korisnikRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public Korisnik findByUsername(String username) {
		// TODO Auto-generated method stub
		return korisnikRepository.findByUsername(username);
	}

}
