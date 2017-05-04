package com.v2.myskeleton.MyBatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.v2.myskeleton.REST.MessagesEntity;

//textやidといったカラムは、schema.sqlを起動時にインポートしているので作られている

@Mapper
public interface MyBatisMapper {
	@Select("SELECT text FROM myskeletonv2table ORDER BY id")
	List<MessagesEntity> findAll();

	@Insert("INSERT INTO myskeletonv2table(text) VALUES(#{text})")
	int create(MessagesEntity message);
}
