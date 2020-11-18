package projekat.tiac.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import projekat.tiac.dto.PostDTO;
import projekat.tiac.model.Korisnik;
import projekat.tiac.model.Post;
import projekat.tiac.service.KorisnikService;
import projekat.tiac.service.PostService;
import projekat.tiac.support.PostDTOToPost;
import projekat.tiac.support.PostToPostDTO;

@Controller
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private PostToPostDTO toDto;
	@Autowired
	private PostDTOToPost toPost;
	@Autowired
	private KorisnikService korisnikService;
	
	
	@PreAuthorize("hasAnyRole('USER')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PostDTO>> findAll(){
		List<Post> posts= postService.findAll();
		if(posts==null || posts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(toDto.convert(posts), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	public ResponseEntity<PostDTO> findOne(@PathVariable("id")Long id){
		Optional<Post> postOptional= postService.findOne(id);
		if(!postOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDto.convert(postOptional.get()), HttpStatus.OK);
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PostDTO> save (@RequestBody PostDTO dto, Principal principal){
		Korisnik korisnik=korisnikService.findByUsername(principal.getName());
		Post post = toPost.convert(dto);
		if(korisnik==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		post.setKorisnik(korisnik);
		Post saved = postService.save(post);
		if(saved==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public ResponseEntity<PostDTO> delete(@PathVariable("id") Long id, Principal principal){
		Korisnik korisnik=korisnikService.findByUsername(principal.getName());
		Optional<Post> post = postService.findOne(id);
		if(!post.isPresent() || !post.get().getKorisnik().equals(korisnik)){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Post deleted = postService.delete(id);
		if(deleted==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public ResponseEntity<PostDTO> update(@PathVariable("id") Long id, 
										@RequestBody PostDTO dto, Principal principal){
		
		Post postToUpdate= toPost.convert(dto);
		Korisnik korisnik= korisnikService.findByUsername(principal.getName());
		if(postToUpdate==null || !postToUpdate.getId().equals(id) ||
		((LocalDateTime.now().getMinute()-postToUpdate.getDatumVreme().getMinute())>5)
		 || !postToUpdate.getKorisnik().equals(korisnik)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Post upadated= postService.save(postToUpdate);
		if(upadated==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDto.convert(upadated), HttpStatus.OK);
	}

}
