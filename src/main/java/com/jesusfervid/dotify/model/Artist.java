package com.jesusfervid.dotify.model;

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
	private Set<Song> songs = new LinkedHashSet<>();

	@OneToMany(mappedBy = "artist", orphanRemoval = true)
	private Set<Album> albums = new LinkedHashSet<>();

}