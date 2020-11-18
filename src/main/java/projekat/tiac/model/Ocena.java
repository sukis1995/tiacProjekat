package projekat.tiac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Ocena {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Post post;
	@ManyToOne
	private Korisnik korisnik;
	@Min(1)@Max(5)
	private int vrednost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
		if(!post.getOcene().contains(this)) {
			post.getOcene().add(this);
		}
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
		if(!korisnik.getOcene().contains(this)) {
			korisnik.getOcene().add(this);
		}
	}
	public int getVrednost() {
		return vrednost;
	}
	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	
	

}
