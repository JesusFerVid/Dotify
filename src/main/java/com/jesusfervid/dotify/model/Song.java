package com.jesusfervid.dotify.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.time.LocalTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "song")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "duration")
	private LocalTime duration;

	@ManyToOne
	@JoinColumn(name = "artist")
	@JsonIncludeProperties({"id", "name"})
	private Artist artist;

	@ManyToOne
	@JoinColumn(name = "album")
	@JsonIncludeProperties({"id", "name"})
	private Album album;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Song song = (Song) o;
		return id != null && Objects.equals(id, song.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}