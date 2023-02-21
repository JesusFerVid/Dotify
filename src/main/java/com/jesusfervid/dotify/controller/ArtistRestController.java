package com.jesusfervid.dotify.controller;

import com.jesusfervid.dotify.model.Artist;
import com.jesusfervid.dotify.service.ArtistService;
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
@RequestMapping("api/artist")
public class ArtistRestController {
	private final ArtistService service;

	public ArtistRestController(ArtistService service) {
		this.service = service;
	}

	@Operation(summary = "Show all artists")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Artist.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("all")
	public List<Artist> getAll() {
		return service.findAll();
	}

	@Operation(summary = "Show artist by id")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Artist.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("{id}")
	public Optional<Artist> getById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@Operation(summary = "Show artists by name")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Correct",
			content = { @Content(
				mediaType = "application/json" ,
				schema = @Schema(implementation = Artist.class)
			)}
		),
		@ApiResponse(responseCode = "403", description = "Forbidden"),
		@ApiResponse(responseCode = "404", description = "Not found"),
		@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@GetMapping("name/{name}")
	public List<Artist> getByName(@PathVariable("name") String name) {
		return service.findByName(name);
	}
}
