package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

import java.sql.*;

public class SubNewRecord extends DBRegisterDAO{

  public SubNewRecord(ViewStatus viewStatus){
    super(viewStatus);
  }

  @Override
  public Boolean DBRegister(ViewStatus viewStatus) {
    if (!CheckSyainID(viewStatus)){
      return false;
    }
    return SubAddresRegister(viewStatus);
  }

  private Boolean CheckSyainID(ViewStatus viewStatus) {
    Connection con = null;
    Boolean flag = null;
    try {

      con = DriverManager.getConnection("jdbc:sqlite::resource:db/db.sqlite3");

      StringBuilder checkSyain = new StringBuilder();
      checkSyain.append("select syainID from syainInfo ");
      checkSyain.append("where syainID = ?;");

      PreparedStatement ps = con.prepareStatement(checkSyain.toString());
      ps.setString(1,viewStatus.getSyainID());
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        flag = true;
      } else {
        flag = false;
      }
      ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return flag;
  }

  private Boolean SubAddresRegister(ViewStatus viewStatus){
    Connection con = null;
    try{
      con = DriverManager.getConnection("jdbc:sqlite::resource:db/db.sqlite3");
      con.setAutoCommit(false);

      // 登録情報
      StringBuffer intoRegister = new StringBuffer();
      intoRegister.append("insert into register(");
      intoRegister.append("  userID,");
      intoRegister.append("  statusRegisterID,");
      intoRegister.append("  bikou,");
      intoRegister.append("  registertime) ");
      intoRegister.append("values((select id from loginUser where userID = ?),");
      intoRegister.append(" ?,?,datetime('now', 'localtime'));");

      PreparedStatement smt1 = con.prepareStatement(intoRegister.toString());
      smt1.setString(1,viewStatus.getLoginUser());
      smt1.setInt(2,viewStatus.getStatusRegisterST());
      smt1.setString(3,viewStatus.getBikou());
      smt1.executeUpdate();
      smt1.close();

      // 新規アドレス
      // 新規だけと想定
      StringBuffer intoAddress = new StringBuffer();
      intoAddress.append("insert into maillAddress(");
      intoAddress.append("  primaryAddressID,");
      intoAddress.append("  secondaryAddressID,");
      intoAddress.append("  address,");
      intoAddress.append("  registerID) ");
      intoAddress.append("values((select primaryAddressID from syainInfo where syainID = ?),");
      intoAddress.append("(select MAX(secondaryAddressID) +1 from maillAddress),");
      intoAddress.append("?,");
      intoAddress.append("(select MAX(registerID) from register));");

      PreparedStatement smt2 = con.prepareStatement(intoAddress.toString());
      smt2.setString(1,viewStatus.getSyainID());
      smt2.setString(2,viewStatus.getAddress());
      smt2.executeUpdate();
      smt2.close();
      con.commit();
    }catch (SQLException e){
      e.printStackTrace();
      try {
        con.rollback();
        return false;
      }catch (SQLException e2){
        e2.printStackTrace();
        return false;
      }finally {
        try {
          if(con != null){
            con.close();
          }
        }catch (SQLException e3){
          e.printStackTrace();
          return false;
        }
      }
    }
    return true;
  }
}
