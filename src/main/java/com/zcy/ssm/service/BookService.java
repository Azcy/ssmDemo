package com.zcy.ssm.service;

import com.zcy.ssm.domain.Book;

import java.util.List;



/**
 * Book服务层接口
 * */
public interface BookService {
	
	/**
	 * 查找所有图书
	 * @return Book对象集合
	 * */
	List<Book> getAll();

}
