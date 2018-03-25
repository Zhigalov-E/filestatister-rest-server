package com.myapp.server.restservices.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("LineStatistic")
public class LineStatisticDto {
	private int Id;
	private int lineNumber;
	private int longestWord;
	private int shortestWord;
	private int lineLength;
	private double averageWordLength;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
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

	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	public double getAverageWordLength() {
		return averageWordLength;
	}

	public void setAverageWordLength(double averageWordLength) {
		this.averageWordLength = averageWordLength;
	}
}
