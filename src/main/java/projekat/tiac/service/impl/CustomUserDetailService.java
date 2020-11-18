package projekat.tiac.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import projekat.tiac.model.CustomUserDetails;
import projekat.tiac.model.Korisnik;
import projekat.tiac.service.KorisnikService;
@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private KorisnikService korisnikService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik korisnik  = korisnikService.findByUsername(username);
		
		if(korisnik!=null) {
			return new CustomUserDetails(korisnik);
		}else {
			throw new UsernameNotFoundException("Username not found");
		}
	}

}
