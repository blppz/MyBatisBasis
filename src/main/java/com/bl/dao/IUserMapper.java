package com.bl.dao;

import com.bl.domain.User;

import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 12:02
 */
public interface IUserMapper {
  List<User> queryAll();
}
