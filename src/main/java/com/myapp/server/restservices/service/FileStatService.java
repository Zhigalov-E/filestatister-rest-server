package com.myapp.server.restservices.service;

import com.myapp.server.restservices.entities.File;
import com.myapp.server.restservices.entities.FileStatistic;
import com.myapp.server.restservices.entities.LineStatistic;

import java.util.List;

public interface FileStatService {
	List<File> getAllFiles();
	List<FileStatistic> getFileStatisticById(int fileId);
	List<LineStatistic> getLinesStatisticByFileId(int fileId);
}
