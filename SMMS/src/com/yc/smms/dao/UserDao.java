package com.yc.smms.dao;

import java.util.List;

import com.yc.smms.entity.User;

public interface UserDao {

	Object findUserbyNP(String username, String password);
	
	List<User> getAllUsers(int pageSize1, int currPage1);

	int getTotalPage(int pageSize);
 
	int ArchiveUsers(String id);

	User getUserById(String id, Class<User> class1);

	int updateUser(User u);

	int addUser(User u);

}
