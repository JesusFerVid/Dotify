package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}