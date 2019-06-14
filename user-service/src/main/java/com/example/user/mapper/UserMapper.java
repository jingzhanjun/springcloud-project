package com.example.user.mapper;

import java.util.List;

import com.example.common.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select * from t_user where _id=#{id} ")
    @Results({
            @Result(column = "_id", property = "id"),
            @Result(column = "_name", property = "name"),
            @Result(column = "_code", property = "code")
    })
    User findById(Long id);

    @Select("select * from t_user order by _id desc ")
    @Results({
            @Result(column = "_id", property = "id"),
            @Result(column = "_name", property = "name"),
            @Result(column = "_code", property = "code")
    })
    List<User> findAll();

    @Insert("insert into t_user(_name,_code) values (#{name},#{code})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "_id")
    Long insert(User product);

    @Update("update t_user set _name=#{name},_code=#{code} where _id=#{id})")
    Long update(User product);

    @Delete("delete from t_user where _id=#{id}")
    void delete(Long id);

}
