package com.github.KKimishima.MailAdmin.model.mainViewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComboData {
  public ObservableList<String> registList(){
    ObservableList<String> registData = FXCollections.observableArrayList(
        "変更",
        "新規"
    );
    return registData;
  }
  public ObservableList<String> searchList(){
    ObservableList<String> searchData = FXCollections.observableArrayList(
        "社員番号",
        "社員名",
        "メールアドレス",
        "更新日時",
        "登録状態",
        "登録者"

    );
    return searchData;
  }
   public ObservableList<String> getLocationCom(){
    ObservableList<String> x = FXCollections.observableArrayList(
        "tokyo",  //1
        "osak",           //2
        "ibaraki",        //3
        "saitama",        //4
        "shizuoka"        //5
    );
    return x;
  }
  public ObservableList<String> getPositionCom(){
    ObservableList<String> x = FXCollections.observableArrayList(
        "一般",  //1
        "管理職"           //2
    );
    return x;
  }
  public ObservableList<String> getStatusCom(){
    ObservableList<String> x = FXCollections.observableArrayList(
        "未登録",  //1
        "返信待ち",           //2
        "登録完了"           //3
    );
    return x;
  }
}
