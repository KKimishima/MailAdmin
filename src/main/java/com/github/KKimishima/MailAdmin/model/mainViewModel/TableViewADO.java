package com.github.KKimishima.MailAdmin.model.mainViewModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;


public class TableViewADO implements MainViewModel {
  private ArrayList<ViewRecord> list;

  public TableViewADO(){
    this.list = new ArrayList<>();
  }

  public HashSet<String> getLoction(){
    HashSet<String> hashSet = new HashSet<>();
    for(ViewRecord s:list){
      hashSet.add(s.getLocationCol());
    }
    return hashSet;
  }

   public HashSet<String> getPostion(){
    HashSet<String> hashSet = new HashSet<>();
     for(ViewRecord s:list){
      hashSet.add(s.getPositonCol());
    }
    return hashSet;
  }

    public HashSet<String> getStatus(){
    HashSet<String> hashSet = new HashSet<>();
      for (ViewRecord s:list){
        hashSet.add(s.getStatusCol());
    }
    return hashSet;
  }

  @Override
  public ArrayList<ViewRecord> getList() {
    return list;
  }

  @Override
  public  void cleanList(){
    this.list.clear();
  }

  @Override
  public void setList() {
    ArrayList<ViewRecord> list = new ArrayList<>();

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
        list.add(new ViewRecord(
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
