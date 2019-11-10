package com.bl.myMyBatis.core;

import com.bl.myMyBatis.config.Mapper;
import com.bl.myMyBatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/10 21:58
 */
public class MapperProxy implements InvocationHandler {
  private Map<String, Mapper> mappers;
  private Connection conn;
  public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
    this.mappers = mappers;
    this.conn = conn;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String className = method.getDeclaringClass().getName();
    String methodName = method.getName();
    String key = className + "." + methodName;
    Mapper mapper = mappers.get(key);
    if(mapper == null) {
      throw new IllegalArgumentException("传参有误");
    }

    // 调用工具类执行查询所有
    return new Executor().selectList(mapper,conn);
  }
}
