package com.myapp.server.restservices.dao;

import com.myapp.server.restservices.entities.File;
import com.myapp.server.restservices.entities.FileStatistic;
import com.myapp.server.restservices.entities.LineStatistic;

import java.util.List;

public interface FileStatisticDao {
	List<File> getAllFiles();
	List<FileStatistic> getFileStatisticById(int fileId);
	List<LineStatistic> getLinesStatisticByByFileId(int fileId);
}
