package projekat.tiac.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import projekat.tiac.dto.OcenaDTO;
import projekat.tiac.model.Ocena;
import projekat.tiac.service.KorisnikService;
import projekat.tiac.service.PostService;

@Component
public class OcenaDTOToOcena implements Converter<OcenaDTO, Ocena> {
	
	
	@Autowired
	private PostService postService;
	@Override
	public Ocena convert(OcenaDTO dto) {
		Ocena ocena= new Ocena();
		ocena.setVrednost(dto.getVrednost());
		ocena.setPost(postService.findOne(dto.getIdPost()).get());
		return ocena;
	}

}
