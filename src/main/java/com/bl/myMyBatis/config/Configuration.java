package com.bl.myMyBatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 17:40
 */
public class Configuration {
  private String driver;
  private String url;
  private String username;
  private String password;
  private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

  public Map<String, Mapper> getMappers() {
    return mappers;
  }

  public void setMappers(Map<String, Mapper> mappers) {
    this.mappers.putAll(mappers);
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
