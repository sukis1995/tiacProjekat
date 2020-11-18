package projekat.tiac.dto;

public class OcenaDTO {
	
	private Long id;
	private Long idPost;
	private Long idKorisnik;
	private String imeKorisnik;
	private int vrednost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public Long getIdKorisnik() {
		return idKorisnik;
	}
	public void setIdKorisnik(Long idKorisnik) {
		this.idKorisnik = idKorisnik;
	}
	public String getImeKorisnik() {
		return imeKorisnik;
	}
	public void setImeKorisnik(String imeKorisnik) {
		this.imeKorisnik = imeKorisnik;
	}
	public int getVrednost() {
		return vrednost;
	}
	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	
	

}
