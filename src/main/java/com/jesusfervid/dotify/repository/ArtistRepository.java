package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}