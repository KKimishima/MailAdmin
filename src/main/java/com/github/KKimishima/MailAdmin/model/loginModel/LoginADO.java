package com.github.KKimishima.MailAdmin.model.loginModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;

public class LoginADO implements LoginModel{

  public boolean loginCheck(String userID,String userPass){

    Connection con = null;
    PreparedStatement  smt = null;
    ResultSet  rs  = null;
    try{
      Class.forName("org.sqlite.JDBC");
    }catch (ClassNotFoundException e){
      return false;
    }

    try {
      con = DriverManager.getConnection("jdbc:sqlite::resource:db/db.sqlite3");
      smt = con.prepareStatement(
          "select * from loginUser where userID = ? and passWord = ?"
      );
      smt.setString(1,userID);
      smt.setString(2,userPass);
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
