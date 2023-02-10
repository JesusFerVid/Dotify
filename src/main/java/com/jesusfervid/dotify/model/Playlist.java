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
@Table(name = "playlist")
public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user", nullable = false)
	private User user;

	@ManyToMany
	@JoinTable(name = "contains",
		joinColumns = @JoinColumn(name = "playlist"),
		inverseJoinColumns = @JoinColumn(name = "song"))
	private Set<Song> songs = new LinkedHashSet<>();

}