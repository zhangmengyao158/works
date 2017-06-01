package com.yc.smms.service;

import java.util.List;
import java.util.Map;
import com.yc.smms.entity.Grade;
 
public interface GradeService {

 
	boolean modifyGrade(Grade t);

	Map<String, Object> getGradeById(String id);

	Grade getGrade(String id);

	boolean ArchiveGrade(String id);

	boolean addGrade(Grade t);

	List<Grade> getAllGrade();

 
 
  
}
