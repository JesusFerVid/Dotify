package com.jesusfervid.dotify.model;

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
@Table(name = "album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "artist")
	@JsonIncludeProperties({"id", "name"})
	private Artist artist;

	@OneToMany(mappedBy = "album", orphanRemoval = true)
	@JsonIncludeProperties({"id", "title", "duration"})
	private Set<Song> songs = new LinkedHashSet<>();

}