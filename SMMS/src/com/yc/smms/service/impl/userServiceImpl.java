package com.yc.smms.service.impl;

import java.util.List;

import com.yc.smms.dao.UserDao;
import com.yc.smms.dao.impl.UserDaoImpl;
import com.yc.smms.entity.User;
import com.yc.smms.entity.UserBean;
import com.yc.smms.service.UserService;

public class userServiceImpl implements UserService {
	private UserDao userDao;
	
	public userServiceImpl() {
		userDao = new UserDaoImpl();
	}
		@Override
		public boolean login(String username,String password){
			return userDao.findUserbyNP(username,password)!= null;
		}
		@Override
		public UserBean getAllUsers(String size, String page) {
 
			int currPage1 = 1; //默认当前页为第一页
			int pageSize1 = 30;  //默认页面条数为30
			if(size != null){
				pageSize1 =Integer.parseInt(size); //取到每页的数据条数
			}
			int totalPage = getTotalPage(pageSize1); //计算数据总条数
			//取到当前页
			if(page != null){
				currPage1 = Integer.parseInt(page);
				if(currPage1 > totalPage){
					currPage1 = totalPage;
				}else if(currPage1 < 1){
					currPage1 = 1;
				}
			}

		List<User> users = userDao.getAllUsers(pageSize1,currPage1);
		return new UserBean(currPage1,totalPage,users , pageSize1*totalPage );
		
		}
		private int getTotalPage(int pageSize) {

			 return userDao.getTotalPage(pageSize);
		}
		@Override
		public boolean ArchiveUsers(String id) {

			return userDao.ArchiveUsers(id) > 0;
		}
		@Override
		public User getUser(String id) {

			return userDao.getUserById(id, User.class);
		}
		@Override
		public boolean modifyUser(User u) {

			return userDao.updateUser(u) > 0 ;
		}
		@Override
		public boolean addUser(User u) {
 			return userDao.addUser(u) > 0;
		}
		 
		 

}
	
 
