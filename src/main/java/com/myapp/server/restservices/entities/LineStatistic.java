package com.myapp.server.restservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "FILE_LINE_STATISTIC")
public class LineStatistic {
	private int Id;
	private int lineNumber;
	private int longestWord;
	private int shortestWord;
	private int lineLength;
	private double averageWordLength;
	private File file;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Column(name = "LINE_NUMBER", nullable = false)
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	@Column(name = "LONGEST_WORD", nullable = false)
	public int getLongestWord() {
		return longestWord;
	}

	public void setLongestWord(int longestWord) {
		this.longestWord = longestWord;
	}

	@Column(name = "SHORTEST_WORD", nullable = false)
	public int getShortestWord() {
		return shortestWord;
	}

	public void setShortestWord(int shortestWord) {
		this.shortestWord = shortestWord;
	}

	@Column(name = "LINE_LENGTH", nullable = false)
	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	@Column(name = "AVERAGE_WORD_LENGTH", nullable = false)
	public double getAverageWordLength() {
		return averageWordLength;
	}

	public void setAverageWordLength(double averageWordLength) {
		this.averageWordLength = averageWordLength;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILE_ID", nullable = false)
	@JsonIgnore
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
