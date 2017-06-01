package com.yc.smms.service.impl;

import java.util.List;
import java.util.Map;

import com.yc.smms.dao.GradeDao;
import com.yc.smms.dao.impl.GradeDaoImpl;
import com.yc.smms.entity.Grade;
import com.yc.smms.service.GradeService;

public class GradeServiceImpl implements GradeService {
	
	private GradeDao gradeDao;
	public GradeServiceImpl() {
      gradeDao = new GradeDaoImpl();
	}
	 
	@Override
	public boolean modifyGrade(Grade t) {

		return gradeDao.updateGrade(t) > 0 ;
	}
	@Override
	public Map<String, Object> getGradeById(String id) {

		return gradeDao.getGradeById(id);
	}
	@Override
	public Grade getGrade(String id) {

		return gradeDao.getGradeById(id, Grade.class);
	}
	@Override
	public List<Grade> getAllGrade() {

//		int currPage = 1; //默认当前页为第一页
//		int pageSize = 30;  //默认页面条数为30
//		if(size != null){
//			pageSize =Integer.parseInt(size); //取到每页的数据条数
//		}
//		int totalPage = getTotalPage(pageSize); //计算数据总条数
//		//取到当前页
//		if(page != null){
//			currPage = Integer.parseInt(page);
//			if(currPage > totalPage){
//				currPage = totalPage;
//			}else if(currPage < 1){
//				currPage = 1;
//			}
//		}

//	List<Topic> topics = topicDao.getAllTopic(pageSize,currPage);
//	return new TopicBean(currPage,totalPage,topics , pageSize*totalPage );
		return gradeDao.getAllGrade();
 	}

	@Override
	public boolean ArchiveGrade(String id) {

		return  gradeDao.ArchiveGrade(id) > 0; 
	}

	@Override
	public boolean addGrade(Grade t) {

		return gradeDao.insertGrade(t) > 0;
	}
 

}
