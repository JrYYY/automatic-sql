package com.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatisOu.mysql.generation.MybatisBaseRepository;
import org.mybatisOu.mysql.model.BaseModel;

import java.util.List;

@Mapper
public interface TestMapper extends MybatisBaseRepository<User> {

    @Select("<script>SELECT emailName, password, nickname\n" +
            "FROM user\n" +
            "JOIN user_info b on user.ID = b.userId\n" +
            "WHERE (b.username in<foreach collection='data.username' item='data.username' index='index'  open='(' separator=',' close=')' > #{data.username}</foreach>)</script>")
    List<User> findUserByData(BaseModel<User> data);
}


