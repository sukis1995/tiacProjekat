package projekat.tiac.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Korisnik implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  CustomUserDetails(final Korisnik korisnik) {
		super(korisnik);
	}

	@Override
	public String getUsername() {
		
		return super.getUsername();
		
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> authorities=super.getUloge().stream()
				.map(m-> new SimpleGrantedAuthority(m.getUloga())).collect(Collectors.toList());
		
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
