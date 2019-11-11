package com.bl.myMyBatis.test;

import com.bl.domain.User;
import com.bl.myMyBatis.annotation.Select;

import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/11 10:20
 */
public interface IUserDao {
  @Select("select * from user")
  List<User> queryAll();
}
