package com.yc.smms.service;

import com.yc.smms.entity.User;
import com.yc.smms.entity.UserBean;



public interface UserService {

boolean login(String uname, String upwd);

UserBean getAllUsers(String size, String page);

boolean ArchiveUsers(String id);

User getUser(String id);

boolean modifyUser(User u);

boolean addUser(User u);

}
