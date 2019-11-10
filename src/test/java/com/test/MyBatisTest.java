package com.test;

import com.bl.dao.IUserMapper;
import com.bl.domain.User;
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
 * @Date 2019/11/10 12:33
 */
public class MyBatisTest {

  /**
   * 测试一个简单的XML案例
   * 这是第一个案例，各种包按照比较规范的方式摆放，后面都放在一个包里面，方便进行区分而不是创建多个项目
   */

  @Test
  public void test1() throws IOException {
    // 读取配置文件 -- 反射
    InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
    // 获取工厂 -- 构建者模式
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
    // 使用工厂获取session -- 工厂模式
    SqlSession session = factory.openSession();
    // 使用sqlSession创建接口的代理对象 -- 代理模式
    IUserMapper mapper = session.getMapper(IUserMapper.class);
    // 然后就可以执行了
    List<User> users = mapper.queryAll();
    for(User user: users) {
      System.out.println(user);
    }
  }
}
