package com.yc.smms.dao;

import java.util.List;
import java.util.Map;

import com.yc.smms.entity.Students;
 import com.yc.smms.entity.Grade;

public interface GradeDao {

	List<Grade> getAllGrade(int pageSize, int currPage);

	int updateGrade(Grade t);

	Grade getGradeById(String id, Class<Grade> class1);
	
	 Map<String,Object> getGradeById(String id);

	int getTotalPage(int pageSize);

	List<Grade> getAllGrade();

	int ArchiveGrade(String id);
 
	int insertGrade(Grade t);

 
 	 
 
	 
}
     