package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
	List<Playlist> findByName(String name);
	List<Playlist> findByAccount_Username(String username);

}