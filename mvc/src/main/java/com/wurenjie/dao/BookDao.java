package com.wurenjie.dao;

import java.util.Map;

import com.wurenjie.model.Book;

public interface BookDao {

	public Book selectBookForName(Map name);
	public Book myThird(String name);
}
