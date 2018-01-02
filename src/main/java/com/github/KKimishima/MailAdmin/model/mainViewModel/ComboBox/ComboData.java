package com.github.KKimishima.MailAdmin.model.mainViewModel.ComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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
}
