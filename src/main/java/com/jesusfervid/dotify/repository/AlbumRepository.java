package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
	List<Album> findByName(String name);
	List<Album> findByArtist_Name(String name);
}