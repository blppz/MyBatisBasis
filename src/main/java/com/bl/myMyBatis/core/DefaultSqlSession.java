package com.bl.myMyBatis.core;

import com.bl.myMyBatis.config.Configuration;
import com.bl.myMyBatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 20:56
 */
public class DefaultSqlSession implements SqlSession {

  private Configuration cfg;
  private Connection conn;

  public DefaultSqlSession(Configuration cfg) {
    this.cfg = cfg;
    // 根据配置(driver,url,username,password,mappers)获取一个连接
    conn = DataSourceUtil.getConnection(cfg);
  }

  public <T> T getMapper(Class<T> daoInterfaceClass) {
    return (T) Proxy.newProxyInstance(
        daoInterfaceClass.getClassLoader(),
        new Class[]{daoInterfaceClass},
        new MapperProxy(cfg.getMappers(), conn)
    );
  }
}
