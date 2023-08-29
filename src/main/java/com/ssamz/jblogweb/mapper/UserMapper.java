package com.ssamz.jblogweb.mapper;

import com.ssamz.jblogweb.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("Insert into users(ID, USERNAME, PASSWORD, EMAIL) " +
            "Values((select max(id)+1 from users), #{username}, #{password}, #{email})")
    public void insertUser(User user);

    @Update("update users password = #{password}, email = #{email} where id = #{id}")
    public void updateUser(User user);

    @Delete("delete from users where id = #{id}")
    public void deleteUser(User user);

    @Select("select * from users where id = #{id}")
    public void getUser(User user);

    @Select("select * from users order by username desc")
    public List<User> getUserList();
}
