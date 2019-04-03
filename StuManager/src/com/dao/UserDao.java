package com.dao;

public interface UserDao {

	boolean login(String userName,String passWord);
	boolean Register(String userName,String passWord);
}
