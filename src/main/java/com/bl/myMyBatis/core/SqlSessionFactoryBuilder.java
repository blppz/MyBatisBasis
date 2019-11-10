package com.bl.myMyBatis.core;

import com.bl.myMyBatis.config.Configuration;
import com.bl.myMyBatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @Deacription 构建者模式 - 创建一个工厂（这里简单实现，具体应该有待斟酌）
 * @Author BarryLee
 * @Date 2019/11/10 16:49
 */
public class SqlSessionFactoryBuilder {
  public static SqlSessionFactory build(InputStream in){
    Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
    return new DefaultSqlSessionFactory(cfg);
  }
}
