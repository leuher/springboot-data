package com.kimzing.data.repository.impl;

import com.kimzing.data.domain.po.UserPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据存储.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/1/31 13:12
 */
@Mapper
public interface MySqlUserRepository {

    @Insert("INSERT INTO `user`(username, password, age, gender) VALUES(#{username}, #{password}, #{age}, #{gender});")
    Integer save(UserPO userPO);

    @Delete("DELETE FROM `user` WHERE id = #{id}")
    void remove(Long id);

    @Update("<script>UPDATE `user` <set>" +
            "<if test='username!=null'>username = #{username},</if>" +
            "<if test='password!=null'>password = #{password},</if>" +
            "<if test='age!=null'>age = #{age},</if>" +
            "<if test='gender!=null'>gender = #{gender},</if>" +
            "</set></script>")
    void update(UserPO userPO);

    @Select("SELECT * FROM `user` WHERE id = #{id}")
    @Results({
            @Result(property = "address", column = "id",
                    one = @One(select = "com.kimzing.data.repository.AddressRepository.findAddressByUserId")),
            @Result(property = "cars", column = "id",
                    many = @Many(select = "com.kimzing.data.repository.CarRepository.findCarsByUserId")),
            @Result(property = "id", column = "id")
    })
    UserPO find(Long id);


    @Select("SELECT * FROM `user`")
    List<UserPO> list();

}
