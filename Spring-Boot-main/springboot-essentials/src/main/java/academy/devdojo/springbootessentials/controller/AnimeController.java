package academy.devdojo.springbootessentials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.devdojo.springbootessentials.domain.Anime;
import academy.devdojo.springbootessentials.request.AnimePostRequestBody;
import academy.devdojo.springbootessentials.request.AnimePostRequestBody;
import academy.devdojo.springbootessentials.request.AnimePostRequestBody;
import academy.devdojo.springbootessentials.request.AnimePostRequestBody;
import academy.devdojo.springbootessentials.service.AnimeService;
import academy.devdojo.springbootessentials.util.DateUtil;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("animes")
@Log4j2
public class AnimeController {

	@Autowired
	private DateUtil dateUtil;
	
	@Autowired
	private AnimeService animeService;
	 
	@GetMapping
	public ResponseEntity<List<Anime>> 	list(){
		// log.info(dateUtil.formatLocalDateTimeDatabaseStringStyle(LocalDateTime.now()));
		return ResponseEntity.ok(animeService.listAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable Long id){
		// log.info(dateUtil.formatLocalDateTimeDatabaseStringStyle(LocalDateTime.now()));
		return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
	}
	
	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody Anime anime) {
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
