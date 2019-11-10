package com.bl.myMyBatis.io;

import java.io.InputStream;

public class Resources {
  /**
   * 获取inputStream
   * @param path
   * @return
   */
  public static InputStream getResourceAsStream(String path) {
    return Resources.class.getClassLoader().getResourceAsStream(path);
  }
}

