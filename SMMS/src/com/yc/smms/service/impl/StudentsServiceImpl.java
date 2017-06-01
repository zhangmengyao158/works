package com.yc.smms.service.impl;
//进行逻辑处理  新闻的获取部分新闻
 
import java.util.List;
import java.util.Map;

import com.yc.smms.dao.StudentsDao;
import com.yc.smms.dao.impl.StudentsDaoImpl;
import com.yc.smms.dao.impl.StudentsDaoImpl;
import com.yc.smms.entity.Students;
import com.yc.smms.entity.StudentsBean;
import com.yc.smms.service.StudentsService;

public  class StudentsServiceImpl implements StudentsService {
	private StudentsDao studentsDao;
	
	public StudentsServiceImpl() {
		studentsDao = new StudentsDaoImpl();
 	}

	@Override
	public StudentsBean getPartStudents(String size, String page) {
		int currPage = 1; //默认当前页为第一页
		int pageSize = 30;  //默认页面条数为30
		if(size != null){
			pageSize =Integer.parseInt(size); //取到每页的数据条数
		}
		int totalPage = getTotalPage(pageSize); //计算数据总条数
		//取到当前页
		if(page != null){
			currPage = Integer.parseInt(page);
			if(currPage > totalPage){
				currPage = totalPage;
			}else if(currPage < 1){
				currPage = 1;
			}
		}

	List<Students> students = studentsDao.getPartStudents(pageSize,currPage);
	return new StudentsBean(currPage,totalPage,students , pageSize*totalPage );
	}
	
	private int getTotalPage(int pageSize) {
		return studentsDao.getTotalPage(pageSize);
	}

	//根据id获取学生信息
	@Override
	public Map<String, Object> getStudentsById(String id) {
		return studentsDao.getStudentsById(id);
	}
	 

	@Override
	public Students getStudents(String id) {  //获取具体的新闻信息
 
		return studentsDao.getStudentsById(id, Students.class);
	}

	@Override
	public boolean modifyStudents(Students n) {

		return studentsDao.updateStudents(n) > 0 ;
	}

	@Override
	public boolean ArchiveStudents(String id) {
		
		return studentsDao.ArchiveStudents(id) > 0 ;
	}

	@Override
	public boolean addStudents(Students n) {

		return studentsDao.insertStudents(n) > 0; 
	}
	 
}