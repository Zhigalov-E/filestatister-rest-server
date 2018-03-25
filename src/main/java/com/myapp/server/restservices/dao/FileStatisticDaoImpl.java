package com.myapp.server.restservices.dao;

import com.myapp.server.restservices.entities.File;
import com.myapp.server.restservices.entities.FileStatistic;
import com.myapp.server.restservices.entities.LineStatistic;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FileStatisticDaoImpl implements FileStatisticDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<File> getAllFiles() {
		CriteriaQuery<File> criteria = entityManager.getCriteriaBuilder().createQuery(File.class);
		criteria.select(criteria.from(File.class));
		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<FileStatistic> getFileStatisticById(int fileId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<FileStatistic> query = criteriaBuilder.createQuery(FileStatistic.class);
		Root<FileStatistic> root = query.from(FileStatistic.class);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("file"), fileId));
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public List<LineStatistic> getLinesStatisticByByFileId(int fileId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LineStatistic> query = criteriaBuilder.createQuery(LineStatistic.class);
		Root<LineStatistic> root = query.from(LineStatistic.class);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("file"), fileId));
		return entityManager.createQuery(query).getResultList();
	}
}
