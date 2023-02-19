package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}