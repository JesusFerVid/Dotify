package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
	List<Artist> findByName(String name);
}