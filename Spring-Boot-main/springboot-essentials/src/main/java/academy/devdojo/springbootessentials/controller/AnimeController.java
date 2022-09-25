package academy.devdojo.springbootessentials.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.service.AnimeService;

@RestController
@RequestMapping("animes")
// @Log4j2
public class AnimeController {

	
	// private final DateUtil dateUtil;

	private final AnimeService animeService;
	
	public AnimeController(AnimeService animeService) {
		super();
		this.animeService = animeService;
	}

	// http://localhost:8080/animes?size=5&page=1
	@GetMapping
	public ResponseEntity<Page<Anime>> list(Pageable pageable){
		// log.info(dateUtil.formatLocalDateTimeDatabaseStringStyle(LocalDateTime.now()));
		return ResponseEntity.ok(animeService.list(pageable));
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Anime>> listAll(){
		// log.info(dateUtil.formatLocalDateTimeDatabaseStringStyle(LocalDateTime.now()));
		return ResponseEntity.ok(animeService.listAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable Long id){
		return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
	}
	

	@GetMapping(path = "/find")
	public ResponseEntity<List<Anime>> findByName(@RequestParam (required = false) String name){
		return ResponseEntity.ok(animeService.findByName(name));
	}
	
	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody @Valid Anime anime) {
		return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);	
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		animeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody Anime anime){
		animeService.replace(anime);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
