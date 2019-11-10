package com.bl.myMyBatis.core;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 16:51
 */
public interface SqlSession {
  /**
   * @param daoInterfaceClass
   * @param <T> dao 接口字节码
   * @return
   */
  <T> T getMapper(Class<T> daoInterfaceClass);
}
