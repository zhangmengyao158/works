package com.yc.smms.dao.impl;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.yc.smms.dao.StudentsDao;
import com.yc.smms.entity.Students;
import com.yc.smms.util.DbHelper;

/**
 * 获取当前页新闻
 * 获取总页数
  * 根据ID获取新闻
 * 删除新闻
 * @author zmy
 *
 */
public class StudentsDaoImpl implements StudentsDao {
 
	//获取所有的新闻
	@Override
    public List<Students> getPartStudents(int pageSize , int currPage){
		  try {
			  String sql ="select sno,clname,sname,ssex,bornDate,tel,address,ru_date from student";
			return DbHelper.list(Students.class,sql);
		  }catch (SQLException e) {
	 		e.printStackTrace();
		  }
		  return null;
    }
    //获取所有的页数
	@Override
    public int getTotalPage(int pageSize){
    	try {
        	String sql=String.format("select ceil(count(1)/%d) tp from student", pageSize);
			return ((BigDecimal)(DbHelper.findSingleObject(sql).get("TP"))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
    	return 0;
    }
 
    //int...ntids 表示一个数组
    //获取所有的id
	@Override
    public Map<String,Object> getStudentsById(String id){
 	  String sql = "select * from student where sno = "+ id;
  	  try {
		return DbHelper.findSingleObject(sql);
	} catch (SQLException e) {
 		e.printStackTrace();
	}
  	  return null;
  }
 

	@Override
	public int ArchiveStudents(String id) {
		Students n = getStudentsById(id,Students.class);
		//先插入再删除
		String sql01 ="insert into students_archive select sno,clname,sname,ssex,bornDate,tel,address,ru_date from student where sno = ?";
		String sql02= "delete from student where sno = ?";
		List<String> sqls = Arrays.asList(sql01,sql02); //事务操作  同时成功 同时失败
		
		try {
			return DbHelper.doUpdate(sqls, new String[]{id}, new String[]{id});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Students getStudentsById(String id, Class<Students> clazz) {
		String sql = "select * from student where sno ="+id;
		try {
			return DbHelper.get(clazz,sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int updateStudents(Students n) {
		String sql="update student set clname=? ,sname=? ,ssex=?,tel=?,address=? where sno=?";
		return DbHelper.doUpdate(sql, n.getClname(),n.getSname(),n.getSsex(),n.getTel(),n.getAddress(),n.getSno());
	}
	
	@Override
	public int insertStudents(Students n){
		String sql = "insert into student values(seq_sno.nextval,?,?,?,sysdate,?,?,sysdate)";
			return DbHelper.doUpdate(sql,n.getClname(),n.getSname(),n.getSsex(),n.getTel(),n.getAddress());
 
	}
 	 
	
}
