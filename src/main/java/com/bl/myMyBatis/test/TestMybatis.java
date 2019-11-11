package com.bl.myMyBatis.test;

//import com.bl.dao.IUserMapper;

import com.bl.domain.User;
import com.bl.myMyBatis.core.SqlSession;
import com.bl.myMyBatis.core.SqlSessionFactory;
import com.bl.myMyBatis.core.SqlSessionFactoryBuilder;
import com.bl.myMyBatis.io.Resources;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Deacription 测试自定义的mybatis
 * @Author BarryLee
 * @Date 2019/11/10 22:36
 *
 * 思路：
 * 写一个Resources类，有一个能获取到xml文件的inputStream的方法
 * SqlSessionFactoryBuilder根据这个inputStream可以构建一个SqlSessionFactory
 * 传入的参数是一个Configuration，这个cfg来源是根据inputStream利用XPath的解析XML技术进行封装的
 * 这个cfg里面的参数包括driver,username,password,url,mappers
 * 其中mappers是一个HashMap，key是类全名+id，value是具体的sql语句
 * 这个配置文件cfg将通过构造传参的方式传给SqlSessionFactory
 * SqlSessionFactory可以生产的是SqlSession，所以他也会将cfg通过构造继续往下传
 * 然后就来到了SqlSession类，现在它手上有一个cfg，而它的职责是作为一个连接可以操作数据库
 * 所以他要将这个cfg拿去给工具类转换为一个Connection conn，这个在构造的时候就完成了
 * SqlSession类的方法是getMapper，它接收一个接口的Class，返回这个接口的实现类对象，其实是一个
 * 代理类而已，这个代理类做的事情就是先根据用户所调用的方法Method获取到类全名和方法名，因为
 * 方法名是和sql的id一致的，所以也就获取到了具体的一个key，再根据这个key拿到一个具体的mapper
 * 然后根据这个mapper和conn就可以获取到返回值了
 *
 * 这就实现了不需要具体的实现类也能获取到查询结果的功能
 *
 */
public class TestMybatis {
  @Test
  public void test() {
    InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
    SqlSessionFactory factory = SqlSessionFactoryBuilder.build(in);
    SqlSession session = factory.openSession();
    IUserDao dao = session.getMapper((IUserDao.class));
    List<User> users = dao.queryAll();
    for(User user: users) {
      System.out.println(user);
    }
  }

  @Test
  public void test2() {
    Map<String, String> map = new HashMap<String, String>();
    map.forEach((k, v) -> System.out.println());
  }
}
