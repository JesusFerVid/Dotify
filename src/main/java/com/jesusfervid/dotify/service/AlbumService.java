package com.jesusfervid.dotify.service;

import com.jesusfervid.dotify.model.Album;
import com.jesusfervid.dotify.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
	private final AlbumRepository repository;

	public AlbumService(AlbumRepository repository) {
		this.repository = repository;
	}

	public List<Album> findAll() {
		return repository.findAll();
	}

	public Optional<Album> findById(Long id){
		return repository.findById(id);
	}

	public List<Album> findByName(String name) {
		return repository.findByName(name);
	}

	public List<Album> findByArtistName(String artistName) {
		return repository.findByArtist_Name(artistName);
	}
}
