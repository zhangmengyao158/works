package com.yc.smms.dao;

import java.util.List;
import java.util.Map;

import com.yc.smms.entity.Students;
import com.yc.smms.entity.StudentsBean;
/**
 * 获取当前页新闻
 * 获取总页数
 * 获取新闻类型125
 * 根据ID获取新闻
 * @author zmy
 *
 */
public  interface StudentsDao {
 
     List<Students> getPartStudents(int pageSize , int currPage);
	
     int getTotalPage(int pageSize);
		
     Map<String,Object> getStudentsById(String id);
 
	 Students getStudentsById(String id, Class<Students> clazz);
  
	int updateStudents(Students n);

	int ArchiveStudents(String id);

	int insertStudents(Students n);

 	
	 
}
