package com.jesusfervid.dotify.controller;

import com.jesusfervid.dotify.model.Song;
import com.jesusfervid.dotify.service.SongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/song")
public class SongRestController {
	private final SongService service;

	public SongRestController(SongService service) {
		this.service = service;
	}

	@Operation(summary = "Show all songs")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Song.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("all")
	public List<Song> getAll() {
		return service.findAll();
	}

	@Operation(summary = "Show all songs paged and sorted")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Song.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("all/paged")
	public List<Song> getAllPaged(
		@RequestParam Integer page,
		@RequestParam Integer size,
		@RequestParam(defaultValue = "id", required = false) String sortBy
	) {
		return service.findAll(page, size, sortBy);
	}

	@Operation(summary = "Show song by id")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Song.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("{id}")
	public Optional<Song> getById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@Operation(summary = "Show songs by title")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Song.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("title/{title}")
	public List<Song> getByName(@PathVariable("title") String title) {
		return service.findByTitle(title);
	}

	@Operation(summary = "Show songs by artist name")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Song.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("artist/{artistName}")
	public List<Song> getByArtistName(@PathVariable("artistName") String artistName){
		return service.findByArtistName(artistName);
	}

	@Operation(summary = "Show songs by album name")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Song.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("album/{albumName}")
	public List<Song> getByAlbumName(@PathVariable("albumName") String albumName){
		return service.findByAlbumName(albumName);
	}

	@Operation(summary = "Show longest song")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Song.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("longest")
	public Optional<Song> getLongest(){
		return service.findLongest();
	}
}
