package academy.devdojo.springbootessentials.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.devdojo.springbootessentials.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
