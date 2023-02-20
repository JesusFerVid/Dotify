package com.jesusfervid.dotify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "birthday")
	private LocalDate birthday;

	@Column(name = "registry_date", nullable = false)
	private LocalDate registryDate;

	@Column(name = "is_superuser", nullable = false)
	private Boolean isSuperuser = false;

	@OneToMany(mappedBy = "account", orphanRemoval = true)
	private Set<Playlist> playlists = new LinkedHashSet<>();

}