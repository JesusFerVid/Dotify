package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
	List<Song> findByTitle(String title);
	List<Song> findByArtist_Name(String name);
	List<Song> findByAlbum_Name(String name);
	Optional<Song> findFirstByOrderByDurationDesc();
}