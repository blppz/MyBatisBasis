package com.bl.myMyBatis.utils;

import com.bl.myMyBatis.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 21:42
 */
public class DataSourceUtil {

  /**
   * 获取连接，这里没有使用单例
   * @param cfg
   * @return
   */
  public static Connection getConnection(Configuration cfg) {
    try {
      Class.forName(cfg.getDriver());
      return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
