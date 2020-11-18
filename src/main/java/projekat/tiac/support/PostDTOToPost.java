package projekat.tiac.support;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.tiac.dto.PostDTO;
import projekat.tiac.model.Post;
import projekat.tiac.service.KorisnikService;
import projekat.tiac.service.PostService;
@Component
public class PostDTOToPost implements Converter<PostDTO, Post> {
	@Autowired
	private PostService postService;
	

	@Override
	public Post convert(PostDTO dto) {
		Post post;
		
		if(dto.getId()!=null && (postService.findOne(dto.getId())).isPresent()) {
			post= postService.findOne(dto.getId()).get();
			
		}else {
		post=new Post();
		post.setDatumVreme(LocalDateTime.now());
		}
		
		post.setTekst(dto.getTekst());
		return post;
	}

}
