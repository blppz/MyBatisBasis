package com.bl.myMyBatis.config;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 20:04
 */
public class Mapper {
  private String queryString; // sql
  private String resultType;

  @Override
  public String toString() {
    return "Mapper{" +
        "queryString='" + queryString + '\'' +
        ", resultType='" + resultType + '\'' +
        '}';
  }

  public String getQueryString() {
    return queryString;
  }

  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }

  public String getResultType() {
    return resultType;
  }

  public void setResultType(String resultType) {
    this.resultType = resultType;
  }
}
