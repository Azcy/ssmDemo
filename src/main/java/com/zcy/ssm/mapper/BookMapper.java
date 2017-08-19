package com.zcy.ssm.mapper;

import java.util.List;

import com.zcy.ssm.domain.Book;
import org.apache.ibatis.annotations.Select;


/**
 * BookMapper接口
 * */
public interface BookMapper {

	/**
	 * 查询所有图书
	 * @return 图书对象集合
	 * */
	@Select(" select * from tb_book ")
	List<Book> findAll();
	
}
