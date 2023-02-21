package com.jesusfervid.dotify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "artist", orphanRemoval = true)
	@JsonIgnore
	private Set<Song> songs = new LinkedHashSet<>();

	@OneToMany(mappedBy = "artist", orphanRemoval = true)
	@JsonIncludeProperties({"id", "name"})
	private Set<Album> albums = new LinkedHashSet<>();

}