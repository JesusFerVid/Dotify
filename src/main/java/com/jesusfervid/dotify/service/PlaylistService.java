package com.jesusfervid.dotify.service;

import com.jesusfervid.dotify.model.Playlist;
import com.jesusfervid.dotify.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
	private final PlaylistRepository repository;

	public PlaylistService(PlaylistRepository repository) {
		this.repository = repository;
	}

	public List<Playlist> findAll() {
		return repository.findAll();
	}

	public Optional<Playlist> findById(Long id){
		return repository.findById(id);
	}

	public List<Playlist> findByUsername(String username) {
		return repository.findByAccount_Username(username);
	}

	public List<Playlist> findByName(String name) {
		return repository.findByName(name);
	}
}
