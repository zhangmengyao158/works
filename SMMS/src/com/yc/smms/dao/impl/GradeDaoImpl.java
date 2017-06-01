package com.yc.smms.dao.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.yc.smms.dao.GradeDao;
import com.yc.smms.entity.Students;
import com.yc.smms.entity.Grade;
import com.yc.smms.util.DbHelper;
import com.yc.smms.dao.GradeDao;
import com.yc.smms.entity.Grade;

public class GradeDaoImpl implements GradeDao {

	@Override
	public List<Grade> getAllGrade() {
		String sql = "select * from grade";
		try {
 			return DbHelper.list(Grade.class, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateGrade(Grade t) {
		String sql="update grade set sno=?,cno=?,score=? where gid=?";
		return DbHelper.doUpdate(sql,t.getSno(),t.getCno(), t.getScore(),t.getGid() );
 	}
 
	 public Map<String,Object> getGradeById(String id){
	 	  String sql = "select * from grade where gid = "+ id;
	  	  try {
			return DbHelper.findSingleObject(sql);
		} catch (SQLException e) {
	 		e.printStackTrace();
		}
	  	  return null;
	  }
	 
	 @Override
		public Grade getGradeById(String id, Class<Grade> clazz) {
			String sql = "select * from grade where gid ="+id;
			try {
				return DbHelper.get(clazz,sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
 
	@Override
	public int ArchiveGrade(String id) {
		Grade t = getGradeById(id,Grade.class);
		//先插入再删除
		String sql01 ="insert into grade_archive select * from grade where gid = ?";
		String sql02= "delete from grade where gid = ?";
		List<String> sqls = Arrays.asList(sql01,sql02); //事务操作  同时成功 同时失败
		
		try {
			return DbHelper.doUpdate(sqls, new String[]{id}, new String[]{id});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
  
	@Override
	public int insertGrade(Grade t) {
		String sql="insert into grade values(seq_gid.nextval,?,?,?)";
		return DbHelper.doUpdate(sql,t.getSno(),t.getCno(),t.getScore() );		 
	}

	@Override
	public List<Grade> getAllGrade(int pageSize, int currPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalPage(int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}

 

 
 

}
