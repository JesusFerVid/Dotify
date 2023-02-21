package com.jesusfervid.dotify.service;

import com.jesusfervid.dotify.model.Song;
import com.jesusfervid.dotify.repository.SongRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
	private final SongRepository repository;

	public SongService(SongRepository repository) {
		this.repository = repository;
	}

	public List<Song> findAll() {
		return repository.findAll();
	}

	public List<Song> findAll(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Song> page = repository.findAll(pageable);
		if (page.hasContent())
			return page.getContent();
		return null;
	}

	public Optional<Song> findById(Long id){
		return repository.findById(id);
	}

	public List<Song> findByTitle(String title) {
		return repository.findByTitle(title);
	}

	public List<Song> findByArtistName(String artistName) {
		return repository.findByArtist_Name(artistName);
	}

	public List<Song> findByAlbumName(String albumName) {
		return repository.findByAlbum_Name(albumName);
	}

	public Optional<Song> findLongest() {
		return repository.findFirstByOrderByDurationDesc();
	}
}
