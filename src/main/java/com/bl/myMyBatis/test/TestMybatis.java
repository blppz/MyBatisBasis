package com.bl.myMyBatis.test;

import com.bl.dao.IUserMapper;
import com.bl.domain.User;
import com.bl.myMyBatis.core.SqlSession;
import com.bl.myMyBatis.core.SqlSessionFactory;
import com.bl.myMyBatis.core.SqlSessionFactoryBuilder;
import com.bl.myMyBatis.io.Resources;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Deacription 测试自定义的mybatis
 * @Author BarryLee
 * @Date 2019/11/10 22:36
 */
public class TestMybatis {
  @Test
  public void test() {
    InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory factory = SqlSessionFactoryBuilder.build(in);
    SqlSession session = factory.openSession();
    IUserMapper mapper = session.getMapper(IUserMapper.class);
    List<User> users = mapper.queryAll();
    for(User user: users) {
      System.out.println(user);
    }
  }
}
