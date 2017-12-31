package com.github.KKimishima.MailAdmin.controller;

import com.github.KKimishima.MailAdmin.app.App;
import com.github.KKimishima.MailAdmin.model.loginModel.LoginADO;
import com.github.KKimishima.MailAdmin.model.loginModel.LoginModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sun.applet.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class LoginController {
  LoginModel loginModel;
  // instance(シングルトン)
  private static LoginController instance;
  // scenes(シングルトン)
  private static Scene SCENE;

  // データのバインディング
  @FXML
  TextField userIDTex;
  @FXML
  TextField userPassTex;
  @FXML
  Text LoginFailTex;

  // 画面生成
  // クラスが読み込まれ時に実行
  // コンストラクタより早く実行される
  static {
    FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("fxml/LoginView.fxml"));
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

  // instance(シングルトン)を返す
  public static LoginController getInstance(){
    return instance;
  }
  // 表示する
  public void show(){
    App.presentStage.setScene(SCENE);
  }
  @FXML
  public void onLogin(){
    loginModel = new LoginADO(userIDTex.getText(),userPassTex.getText());
    if (loginModel.loginCheck()){
      MainController.getInstance().show();
    }else{
      loginModel = null;
      userIDTex.clear();
      userPassTex.clear();
      LoginFailTex.setText("ログイン失敗");
    }
  }
}
