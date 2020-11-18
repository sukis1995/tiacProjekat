package projekat.tiac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekat.tiac.model.Uloga;
import projekat.tiac.repository.UlogaRepositroy;
import projekat.tiac.service.UlogaService;
@Service
public class UlogaJpaService implements UlogaService {
	@Autowired
	private UlogaRepositroy ulogaRepository;

	@Override
	public Uloga save(Uloga uloga) {
		// TODO Auto-generated method stub
		return ulogaRepository.save(uloga);
	}

	@Override
	public Uloga findByNaziv(String uloga) {
		// TODO Auto-generated method stub
		return ulogaRepository.findByNaziv(uloga);
	}

}
