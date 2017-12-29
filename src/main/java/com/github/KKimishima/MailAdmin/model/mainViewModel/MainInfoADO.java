package com.github.KKimishima.MailAdmin.model.mainViewModel;

import java.sql.*;
import java.util.ArrayList;

public class MainInfoADO implements MainViewModel{
  private ArrayList<SelectItem> list;

  public MainInfoADO(){
    list = new ArrayList<SelectItem>();
  }

  public void select() {
    try{
      Class.forName("org.sqlite.JDBC");
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }

    Connection con = null;
    try{
      con = DriverManager.getConnection("jdbc:sqlite::resource:db/db.sqlite3");
      PreparedStatement ps = con.prepareStatement(
          "-- syainInfoを中心に統合情報\n" +
              "select\n" +
              "    -- syainInfoテーブル\n" +
              "    syainID,\n" +
              "    syainName,\n" +
              "    -- locationテーブル\n" +
              "    \"locationName\",\n" +
              "    -- positionテーブル\n" +
              "    positionName,\n" +
              "    -- maillAdressテーブル\n" +
              "    address,\n" +
              "    -- register\"テーブル\n" +
              "    registerTime,\n" +
              "    bikou,\n" +
              "    -- statusRegisterテーブル\n" +
              "    \"statusName\",\n" +
              "    -- loginUserテーブル\n" +
              "    userName,\n" +
              "    passWord,\n" +
              "    loginUser.userID\n" +
              "    --userID\n" +
              "--select *\n" +
              "from \"syainInfo\"\n" +
              "-- 緊密テーブル\n" +
              "inner join  location\n" +
              "    on location.\"locationID\" = \"syainInfo\".locationID\n" +
              "inner join position\n" +
              "    on \"syainInfo\".\"positionID\" = position.\"positionID\"\n" +
              "-- 中密テーブル\n" +
              "inner join \"maillAddress\"\n" +
              "    on \"syainInfo\".primaryAddressID =\"maillAddress\".\"primaryAddressID\"\n" +
              "-- 疎密テーブル\n" +
              "inner join register\n" +
              "    on  register.registerID = \"maillAddress\".\"registerID\"\n" +
              "-- 最遠部テーブル\n" +
              "inner join \"loginUser\"\n" +
              "    on \"loginUser\".\"id\" = register.userID\n" +
              "inner join \"statusRegister\"\n" +
              "    on register.\"statusRegisterID\" = \"statusRegister\".\"statusRegisterID\"\n" +
              ";"
      );
      ResultSet rs = ps.executeQuery();
      while (rs.next()){
        list.add(new SelectItem(
            rs.getString("syainID"),
            rs.getString("syainName"),
            rs.getString("locationName"),
            rs.getString("positionName"),
            rs.getString("address"),
            rs.getString("registerTime"),
            rs.getString("bikou"),
            rs.getString("statusName"),
            rs.getString("userID"),
            rs.getString("userName")
        ));
      }
    }catch (SQLException e){
      e.printStackTrace();
    }finally {
      if(con != null){
        try{
          con.close();
        }catch (SQLException e){}
      }
    }
  }

  @Override
  public ArrayList<SelectItem> get() {
    return list;
  }

  @Override
  public void Clean(){
    list = null;
  }
}
