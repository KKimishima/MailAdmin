package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecord extends DBRegisterDAO{
  public DeleteRecord(ViewStatus viewStatus){
    super(viewStatus);
  }

  @Override
  public Boolean DBRegister(ViewStatus viewStatus){
    Connection con = null;
    try {
      con = DriverManager.getConnection("jdbc:sqlite::resource:db/db.sqlite3");

      StringBuffer syain = new StringBuffer();
      syain.append("delete from maillAddress ");
      syain.append("where address = ?;");

      PreparedStatement smt = con.prepareStatement(syain.toString());
      smt.setString(1,viewStatus.getAddress());
      smt.executeUpdate();
      smt.close();
    }catch (SQLException e) {
      e.printStackTrace();
      return false;
    }finally {
      if (con != null){
        try {
          con.close();
        }catch (SQLException e){
          e.printStackTrace();
          return false;
        }
      }
    }
    return true;
  }
}
