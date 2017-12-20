package com.github.KKimishima.MailAdmin.controller;

import com.github.KKimishima.MailAdmin.app.App;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
  // instance(シングルトン)
  private static MainController instance;
  // scenes(シングルトン)
  private static Scene SCENE;

  // 画面生成
  // クラスが読み込まれ時に実行
  // コンストラクタより早く実行される
  static {
    FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("fxml/MainView.fxml"));
    try{
      fxmlLoader.load();
    }catch (IOException e){
      e.printStackTrace();
    }
    Parent parent = fxmlLoader.getRoot();
    Scene scene = new Scene(parent);
    SCENE = scene;
    instance = fxmlLoader.getController();
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    System.out.println("初期化実行");

  }

  // instance(シングルトン)を返す
  public static MainController getInstance(){
    return instance;
  }
  // 表示する
  public void show(){
    App.presentStage.setScene(SCENE);
  }
  public void onRegister(){
    System.out.println("登録ボタンが押されました");
  }
}
