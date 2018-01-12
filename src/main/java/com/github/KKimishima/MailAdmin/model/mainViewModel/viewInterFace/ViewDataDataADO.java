package com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace;

import java.sql.*;
import java.util.ArrayList;


public class ViewDataDataADO implements ViewDataModel {
  private ArrayList<ViewData> list;

  public ViewDataDataADO(){
    this.list = new ArrayList<>();
  }

  @Override
  public ArrayList<ViewData> getList() {
    return list;
  }

  @Override
  public  void cleanList(){
    this.list.clear();
  }

  @Override
  public void setList() {
    ArrayList<ViewData> list = new ArrayList<>();

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
              "    location.locationID,\n"+
              "    \"locationName\",\n" +
              "    -- positionテーブル\n" +
              "    position.positionID,\n" +
              "    positionName,\n" +
              "    -- maillAdressテーブル\n" +
              "    address,\n" +
              "    \"maillAddress\".\"primaryAddressID\",\n"+
              "    secondaryAddressID,\n" +
              "    -- register\"テーブル\n" +
              "    registerTime,\n" +
              "    bikou,\n" +
              "    -- statusRegisterテーブル\n" +
              "    statusRegister.statusRegisterID,\n"+
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
        list.add(new ViewData(
            rs.getInt("primaryAddressID"),
            rs.getInt("secondaryAddressID"),
            rs.getInt("locationID"),
            rs.getInt("positionID"),
            rs.getInt("statusRegisterID"),
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
   this.list = list;
  }
}
