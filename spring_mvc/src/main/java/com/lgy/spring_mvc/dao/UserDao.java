package com.lgy.spring_mvc.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserDao {
	public String findById(String id);
	
	
}
