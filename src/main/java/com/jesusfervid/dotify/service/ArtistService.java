package com.jesusfervid.dotify.service;

import com.jesusfervid.dotify.model.Artist;
import com.jesusfervid.dotify.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
	private final ArtistRepository repository;

	public ArtistService(ArtistRepository repository) {
		this.repository = repository;
	}

	public List<Artist> findAll() {
		return repository.findAll();
	}

	public Optional<Artist> findById(Long id){
		return repository.findById(id);
	}

	public List<Artist> findByName(String name) {
		return repository.findByName(name);
	}
}
