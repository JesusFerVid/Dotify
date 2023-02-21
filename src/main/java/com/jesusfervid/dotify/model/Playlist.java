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
@Table(name = "playlist")
public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "account", nullable = false)
	@JsonIncludeProperties({"id", "username"})
	private Account account;

	@ManyToMany
	@JoinTable(name = "playlist_song",
		joinColumns = @JoinColumn(name = "playlist"),
		inverseJoinColumns = @JoinColumn(name = "song"))
	private Set<Song> songs = new LinkedHashSet<>();

}