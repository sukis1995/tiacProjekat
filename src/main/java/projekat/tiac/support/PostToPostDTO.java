package projekat.tiac.support;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.tiac.dto.PostDTO;
import projekat.tiac.model.Post;
@Component
public class PostToPostDTO implements Converter<Post, PostDTO>{
	public static DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
	@Override
	public PostDTO convert(Post post) {
		PostDTO dto= new PostDTO();
		dto.setDatumVreme(dtf.format(post.getDatumVreme()));
		dto.setId(post.getId());
		dto.setIdKorsnik(post.getKorisnik().getId());
		dto.setImeKorisnik(post.getKorisnik().getUsername());
		dto.setSrednjaOcena(post.getSrednjaOcena());
		dto.setTekst(post.getTekst());
		dto.setBrojKomentara(post.getKomentari().size());
	
		return dto;
	}
	
	
	public List<PostDTO> convert(List<Post>postovi){
		List<PostDTO> dtos= new ArrayList<PostDTO>();
		for (Post post : postovi) {
			PostDTO dto= convert(post);
			dtos.add(dto);
		}
		
		return dtos;
	}
	

}
