package com.bl.annotation;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 14:54
 */
public class TestAnno {

  /**
   * 这里简单测试使用注解是如何玩的
   * 竟然不需要定义如何返回
   */

  @Test
  public void test1() throws IOException {
    InputStream in = Resources.getResourceAsStream("annotationSqlMapConfig.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
    SqlSession session = factory.openSession();
    IUserDao mapper = session.getMapper(IUserDao.class);
    List<User> users = mapper.queryAll();
    for(User user: users) {
      System.out.println(user);
    }
  }
}
