package com.yc.smms.service;

import java.util.List;
import java.util.Map;

import com.yc.smms.entity.Students;
import com.yc.smms.entity.StudentsBean;

public interface StudentsService {
 
	/**
	 * 获取所有的主题  获取所有的主题类型  获取所有的ID  获取新闻
	 * @param size
	 * @param page
	 * @return
	 */
    StudentsBean getPartStudents(String size , String page);
	
    Map<String,Object> getStudentsById(String id) ;

	Students getStudents(String id);

	boolean modifyStudents(Students n);

	boolean ArchiveStudents(String id);

	boolean addStudents(Students n);

	 
}
