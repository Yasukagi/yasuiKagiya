package com.yasukagi.tools;

import java.awt.image.BufferStrategy;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
データベースセットアップスクリプト
説明 ： 必要なデータベースを任意のユーザに対して生成する．yasukagiServletの初回セットアップ時には必ず実行しましょう．

Database setup script
overview : set up needed database for yasukagiServlet. make sure launching this script before first start.

超簡易版（今後開発）
**/
public class SetupDb {
    public static void main(String[] args) {
        Properties config = new Properties();
        String rootDir = System.getProperty("user.dir");
        try {
            InputStream inputStream = new FileInputStream(new File(rootDir + "/src/main/resources/database.properties"));
            config.load(inputStream);
            inputStream.close();

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
                    config.getProperty("dbUserName"),
                    config.getProperty("dbUserPass"));
            Statement smt = con.createStatement();

            String sql = "CREATE DATABASE IF NOT EXISTS " + config.getProperty("dbName");
            //データベース作成
            smt.executeUpdate(sql);
            sql = "USE " + config.getProperty("dbName");
            //データベース選択
            smt.executeUpdate(sql);

            //resourcesディレクトリ以下のsqlを全て実行する
            File[] dir = new File(rootDir + "/src/main/resources/").listFiles();
            for(File file : dir) {
                if(!file.getName().endsWith(".sql"))
                    continue;
                FileInputStream fi = new FileInputStream(file);
                byte[] b = new byte[(int)file.length()];
                fi.read(b);
                sql = new String(b);
                smt.executeUpdate(sql);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e){
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }
}
