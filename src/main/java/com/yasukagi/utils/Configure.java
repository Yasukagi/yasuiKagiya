package com.yasukagi.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * プロパティファイルを読み込んで，値を取得するためのクラス
 * 標準のライブラリだとインプットストリーム開いたり面倒な作業があるので，クラスにまとめた
 */
public class Configure {
  private Properties properties;
  private static final Logger logger = LogManager.getLogger(Configure.class);

  /**
   * 読み込むプロパティファイルを渡す
   * @param file ファイル名
   */
  public Configure(String file) {
    properties = new Properties();
    try {
      InputStream inputStream = Configure.class.getClassLoader().getResourceAsStream(file);
      properties.load(inputStream);
      inputStream.close();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * プロパティのキーから値を取り出す
   * @param key キー
   * @return キーに対応する値
   */
  public String getStringConfig(String key) {
    return properties.getProperty(key);
  }
  public Integer getIntConfig(String key) {
    return Integer.parseInt(properties.getProperty(key));
  }
  public Long getLongConfig(String key) {
    return Long.parseLong(properties.getProperty(key));
  }
}
