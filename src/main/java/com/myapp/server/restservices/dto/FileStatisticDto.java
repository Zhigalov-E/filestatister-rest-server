package com.myapp.server.restservices.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("FileStatistic")
public class FileStatisticDto {
	private int Id;
	private int longestWord;
	private int shortestWord;
	private int linesLength;
	private double averageWordLength;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getLongestWord() {
		return longestWord;
	}

	public void setLongestWord(int longestWord) {
		this.longestWord = longestWord;
	}

	public int getShortestWord() {
		return shortestWord;
	}

	public void setShortestWord(int shortestWord) {
		this.shortestWord = shortestWord;
	}

	public int getLinesLength() {
		return linesLength;
	}

	public void setLinesLength(int linesLength) {
		this.linesLength = linesLength;
	}

	public double getAverageWordLength() {
		return averageWordLength;
	}

	public void setAverageWordLength(double averageWordLength) {
		this.averageWordLength = averageWordLength;
	}
}
