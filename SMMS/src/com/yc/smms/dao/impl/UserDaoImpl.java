package com.yc.smms.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.yc.smms.dao.UserDao;
import com.yc.smms.entity.Students;
import com.yc.smms.entity.User;
import com.yc.smms.util.DbHelper;
//登录的处理
public class UserDaoImpl implements UserDao {
	
	/**
	 * 通过用户名和密码找到用户  返回的是user 对象
	 */
	@Override
	public Object findUserbyNP(String username, String password) {

		
		String sql="select * from smms_user where uname=? and upwd=?";
		try {
			return DbHelper.findSingleObject(sql, username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  null;
	}

	@Override
	public List<User> getAllUsers(int pageSize1, int currPage1) {

		 try {
			 String sql = "select usid,uname,upwd,sex,tel,user_drop from smms_USER where user_drop='General'";
			 return DbHelper.list(User.class,sql);
		  }catch (SQLException e) {
	 		e.printStackTrace();
		  }
		  return null;
 	}

	@Override
	public int getTotalPage(int pageSize1) {

		try {
        	String sql=String.format("select ceil(count(1)/%d) tp from smms_user", pageSize1);
			return ((BigDecimal)(DbHelper.findSingleObject(sql).get("TP"))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int ArchiveUsers(String id) {
		User u =  getUserById(id,User.class);
		//先插入再删除
		String sql01 ="insert into smms_archive select* from smms_user where usid = ?";
		String sql02= "delete from smms_user where usid = ?";
		List<String> sqls = Arrays.asList(sql01,sql02); //事务操作  同时成功 同时失败
		
		try {
			return DbHelper.doUpdate(sqls, new String[]{id}, new String[]{id});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
 
	@Override
	public User getUserById(String id, Class<User> clazz) {
		String sql = "select * from smms_USER where usid ="+id;
		try {
			return DbHelper.get(clazz,sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateUser(User u) {
		String sql="update smms_USER set uname=?,upwd=?,sex=?,tel=?,user_drop=? where usid=?";
		return DbHelper.doUpdate(sql, u.getUname() , u.getUpwd() , u.getSex(),u.getTel() , u.getUser_drop(),u.getUsid());
	}

	@Override
	public int addUser(User u) {
		String sql="insert into smms_user values(seq_usid.nextval,?,?,?,?,?)";
		return DbHelper.doUpdate(sql,u.getUname(),u.getUpwd(),u.getSex(),u.getTel(),u.getUser_drop() );	
	}

	 

}
