package com.github.KKimishima.MailAdmin.model;

import java.io.IOException;
import java.sql.*;

public class JdbcTest {
  public boolean sqlCheck(){
    Connection con = null;
    PreparedStatement  smt = null;
    ResultSet  rs  = null;
    try{
      Class.forName("org.sqlite.JDBC");
    }catch (ClassNotFoundException e){
      return false;
    }

    try {
      String jdbcStr = "jdbc:sqlite:" + getClass().getResource("/db/db.sqlite3").getPath();
      con = DriverManager.getConnection(jdbcStr);
      smt = con.prepareStatement(
              "select * from loginUser where pass = ?;"
      );
      smt.setString(1,"hoeghoge");
      rs = smt.executeQuery();
      if(rs.next()){
        return true;
      }
        return false;
    }catch (SQLException e){
      e.printStackTrace();
      return false;
    }finally {
      if (con != null){
        try{
          con.close();
        }catch (SQLException e){}
      }
    }
  }
}
