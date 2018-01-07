package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeRecord extends DBRegisterDAO{

  public ChangeRecord(ViewStatus viewStatus){
    super(viewStatus);
  }

  @Override
  public Boolean DBRegister(ViewStatus viewStatus){
        Connection con = null;
    try {

      con = DriverManager.getConnection("jdbc:sqlite::resource:db/db.sqlite3");
      con.setAutoCommit(false);

      // 社員情報更新
      StringBuffer syainUpdate = new StringBuffer();
      syainUpdate.append("update syainInfo");
      syainUpdate.append("  set locationID = ?,");
      syainUpdate.append("      positionID = ?,");
      syainUpdate.append("      primaryAddressID = ?");
      syainUpdate.append("where syainID=?;");

      PreparedStatement smt1 = con.prepareStatement(syainUpdate.toString());
      smt1.setInt(1,viewStatus.getLocationST());
      smt1.setInt(2,viewStatus.getPositionST());
      smt1.setInt(3,viewStatus.getPrimaryAddressST());
      smt1.setString(4,viewStatus.getSyainID());
      smt1.executeUpdate();
      smt1.close();

      // 履歴追加
      StringBuffer registerStr = new StringBuffer();
      registerStr.append("insert into register(");
      registerStr.append("  userID,");
      registerStr.append("  statusRegisterID,");
      registerStr.append("  bikou,");
      registerStr.append("  registerTime) ");
      registerStr.append("values((select id from loginUser where userID = ?),");
      registerStr.append("?,?,datetime('now', 'localtime'));");

      PreparedStatement smt2 = con.prepareStatement(registerStr.toString());
      smt2.setString(1,viewStatus.getLoginUser());
      smt2.setInt(2,viewStatus.getStatusRegisterST());
      smt2.setString(3,viewStatus.getBikou());
      smt2.executeUpdate();
      smt1.close();

      // メールアドレス変更
      StringBuffer addressStr = new StringBuffer();
      addressStr.append("update maillAddress ");
      addressStr.append("set address = ?,");
      addressStr.append("registerID = (select MAX(registerID) from register) ");
      addressStr.append("where primaryAddressID =? and secondaryAddressID =?;");

      PreparedStatement smt3 = con.prepareStatement(addressStr.toString());
      smt3.setString(1,viewStatus.getAddress());
      smt3.setInt(2,viewStatus.getPrimaryAddressST());
      smt3.setInt(3,viewStatus.getSecondaryAddressST());
      smt3.executeUpdate();
      smt3.close();

      con.commit();
    }catch (SQLException e){
      try {
        e.printStackTrace();
        con.rollback();
        return false;
      }catch (SQLException e2){
        e2.printStackTrace();
        return false;
      }finally {
        try {
          if (con != null){
            con.close();
          }
        }catch (SQLException e3){
          e3.printStackTrace();
          return false;
        }
      }
    }
    return true;
  }

}
