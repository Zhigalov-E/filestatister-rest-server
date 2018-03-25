package com.myapp.server.restservices.service;

import com.myapp.server.restservices.dao.FileStatisticDao;
import com.myapp.server.restservices.entities.File;
import com.myapp.server.restservices.entities.FileStatistic;
import com.myapp.server.restservices.entities.LineStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FileStatServiceImpl implements FileStatService {

	@Autowired
	private FileStatisticDao fileStatisticDao;

	@Override
	public List<File> getAllFiles() {
		return fileStatisticDao.getAllFiles();
	}

	@Override
	public List<FileStatistic> getFileStatisticById(int fileId) {
		return fileStatisticDao.getFileStatisticById(fileId);
	}

	@Override
	public List<LineStatistic> getLinesStatisticByFileId(int fileId) {
		return fileStatisticDao.getLinesStatisticByByFileId(fileId);
	}
}
