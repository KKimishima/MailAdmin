package com.github.KKimishima.MailAdmin.model.mainViewModel.tableView;

import com.github.KKimishima.MailAdmin.model.mainViewModel.MainViewModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;


public class TableViewADO implements MainViewModel {
  private ArrayList<SelectItem> list;

  public TableViewADO(){
    this.list = new ArrayList<>();
  }

  public HashSet<String> getLoction(){
    HashSet<String> hashSet = new HashSet<>();
    for (SelectItem s:list) {
      hashSet.add(s.getLocationName());
    }
    return hashSet;
  }

   public HashSet<String> getPostion(){
    HashSet<String> hashSet = new HashSet<>();
    for (SelectItem s:list) {
      hashSet.add(s.getPositionName());
    }
    return hashSet;
  }

    public HashSet<String> getStatus(){
    HashSet<String> hashSet = new HashSet<>();
    for (SelectItem s:list) {
      hashSet.add(s.getStatusName());
    }
    return hashSet;
  }

  @Override
  public ArrayList<SelectItem> getList() {
    return list;
  }

  @Override
  public  void cleanList(){
    this.list.clear();
  }

  @Override
  public void setList() {
    ArrayList<SelectItem> list = new ArrayList<>();
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
   this.list = list;
  }
}
