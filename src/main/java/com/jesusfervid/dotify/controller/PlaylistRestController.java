package com.jesusfervid.dotify.controller;

import com.jesusfervid.dotify.model.Playlist;
import com.jesusfervid.dotify.service.PlaylistService;
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
@RequestMapping("api/playlist")
public class PlaylistRestController {
	private final PlaylistService service;

	public PlaylistRestController(PlaylistService service) {
		this.service = service;
	}

	@Operation(summary = "Show all playlists")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Playlist.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("all")
	public List<Playlist> getAll() {
		return service.findAll();
	}

	@Operation(summary = "Show playlist by id")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Playlist.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("{id}")
	public Optional<Playlist> getById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@Operation(summary = "Show playlists by name")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Playlist.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("name/{name}")
	public List<Playlist> getByName(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@Operation(summary = "Show playlists by user")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Playlist.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("user/{username}")
	public List<Playlist> getByUsername(@PathVariable("username") String username) {
		return service.findByUsername(username);
	}
}
