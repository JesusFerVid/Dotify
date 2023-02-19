package com.jesusfervid.dotify.repository;

import com.jesusfervid.dotify.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}