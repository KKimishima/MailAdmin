package com.github.KKimishima.MailAdmin.model.mainViewModel.ComboBox;

import com.github.KKimishima.MailAdmin.model.mainViewModel.MainViewModel;

import java.sql.*;
import java.util.ArrayList;

//public class ComboDataADO implements MainViewModel{
public class ComboDataADO{
  public ComboDataADO(){
    try{
      Class.forName("org.sqlite.JDBC");
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }
  }
  public ArrayList<String> selectComboData(String dataField,String dataTable){
    Connection con = null;
    ArrayList<String> list = new ArrayList<>();
    try{
      con = DriverManager.getConnection("jdbc:sqlite::resource:db/db.sqlite3");
      PreparedStatement ps = con.prepareStatement(
          //"select ? from location;"
          "select "+dataField+ " from "+dataTable+";"
      );
      ResultSet rs = ps.executeQuery();
      while (rs.next()){
        list.add(rs.getString(dataField));
      }
    }catch (SQLException e){
      e.printStackTrace();
    }finally {
      if(con != null){
        try {
          con.close();
        }catch (SQLException e){e.printStackTrace();}
      }
    }
    return list;
  }
}
