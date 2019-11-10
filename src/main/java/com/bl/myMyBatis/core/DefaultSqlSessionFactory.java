package com.bl.myMyBatis.core;

import com.bl.myMyBatis.config.Configuration;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 20:57
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
  private Configuration cfg;
  public DefaultSqlSessionFactory(Configuration cfg) {
    this.cfg = cfg;
  }
  public SqlSession openSession() {
    return new DefaultSqlSession(cfg);
  }
}
