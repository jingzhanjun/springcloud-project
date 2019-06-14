package com.blue.product.mapper;

import java.util.List;
import java.util.Map;

import com.example.common.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * 
CREATE TABLE `t_product` (
  `_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `_name` varchar(100) DEFAULT NULL,
  `_code` varchar(100) DEFAULT NULL,
  `_price` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 */
public interface ProductMapper {

    @Select("select * from t_product where _id=#{id} ")
    @Results({
            @Result(column = "_id", property = "id"),
            @Result(column = "_name", property = "name"),
            @Result(column = "_code", property = "code"),
            @Result(column = "_price", property = "price")
    })
    Product findById(Long id);

    @Select("select * from t_product order by _id desc ")
    @Results({
            @Result(column = "_id", property = "id"),
            @Result(column = "_name", property = "name"),
            @Result(column = "_code", property = "code"),
            @Result(column = "_price", property = "price")
    })
    List<Product> findAll();

    @Insert("insert into t_product(_name,_code,_price,_uid) values (#{name},#{code},#{price},#{uid})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "_id")
    Long insertObj(Product product);

    @Update("update t_product set _name=#{name},_code=#{code},_price=#{price} where _id=#{id})")
    Long update(Product product);

    @Delete("delete from t_product where _id=#{id}")
    void delete(Long id);

    @Select("select * from t_product where _uid=#{uid} order by _id desc ")
    @Results({
            @Result(column = "_id", property = "id"),
            @Result(column = "_name", property = "name"),
            @Result(column = "_code", property = "code"),
            @Result(column = "_price", property = "price")
    })
    List<Product> findByUser(Long uid);

    @Insert("insert into t_product(_name,_code) values (#{name},#{code})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "_id")
    Long insert(Map<String, Object> product);
}
