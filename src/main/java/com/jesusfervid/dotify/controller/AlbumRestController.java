package com.jesusfervid.dotify.controller;

import com.jesusfervid.dotify.model.Album;
import com.jesusfervid.dotify.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/album")
public class AlbumRestController {
	private final AlbumService service;

	public AlbumRestController(AlbumService service) {
		this.service = service;
	}

	@Operation(summary = "Show all albums")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Album.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("all")
	public List<Album> getAll() {
		return service.findAll();
	}

	@Operation(summary = "Show album by id")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Album.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("{id}")
	public Optional<Album> getById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@Operation(summary = "Show albums by name")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Album.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("name/{name}")
	public List<Album> getByName(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@Operation(summary = "Show albums by artist name")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Album.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("artist/{artistName}")
	public List<Album> getByArtistName(@PathVariable("artistName") String artistName){
		return service.findByArtistName(artistName);
	}
}
