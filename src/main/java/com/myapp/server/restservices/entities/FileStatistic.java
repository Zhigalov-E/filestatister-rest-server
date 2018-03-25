package com.myapp.server.restservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "FILE_AGGREGATION_STATISTIC")
public class FileStatistic {
	private int Id;
	private int longestWord;
	private int shortestWord;
	private int linesLength;
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

	@Column(name = "LINES_LENGTH", nullable = false)
	public int getLinesLength() {
		return linesLength;
	}

	public void setLinesLength(int linesLength) {
		this.linesLength = linesLength;
	}

	@Column(name = "AVERAGE_WORD_LENGTH", nullable = false)
	public double getAverageWordLength() {
		return averageWordLength;
	}

	public void setAverageWordLength(double averageWordLength) {
		this.averageWordLength = averageWordLength;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILE_ID")
	@JsonIgnore
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
