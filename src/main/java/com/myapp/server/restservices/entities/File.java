package com.myapp.server.restservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "FILE")
public class File implements Serializable {
	private int Id;
	private String name;
	private String path;
	private Set<FileStatistic> fileStatistic;
	private Set<LineStatistic> lineStatistics;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PATH", nullable = false, length = 1023)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<FileStatistic> getFileStatistic() {
		return fileStatistic;
	}

	public void setFileStatistic(Set<FileStatistic> fileStatistic) {
		this.fileStatistic = fileStatistic;
	}

	@OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<LineStatistic> getLineStatistics() {
		return lineStatistics;
	}

	public void setLineStatistics(Set<LineStatistic> lineStatistics) {
		this.lineStatistics = lineStatistics;
	}
}
