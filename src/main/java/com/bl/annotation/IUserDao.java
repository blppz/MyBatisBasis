package com.bl.annotation;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 14:53
 */
public interface IUserDao {
  @Select("select * from user")
  List<User> queryAll();
}
