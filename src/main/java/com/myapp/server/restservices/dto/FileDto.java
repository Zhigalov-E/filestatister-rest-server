package com.myapp.server.restservices.dto;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("File")
public class FileDto {
	private int Id;
	private String name;
	private String path;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
