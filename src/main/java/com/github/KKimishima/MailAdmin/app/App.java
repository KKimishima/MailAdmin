package com.github.KKimishima.MailAdmin.app;

import com.github.KKimishima.MailAdmin.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application{
  public static Stage presentStage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    // 共有StageObjectに引き渡し
    this.presentStage = primaryStage;

    primaryStage.setTitle("メールアドレス登録管理");
    //Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginView.fxml"));
    //空のScene差癖
    Scene scene = new Scene(new Pane());
    primaryStage.setScene(scene);

    // 最初のログイン画面にセット
    LoginController.getInstance().show();

    // アプリスタート
    primaryStage.show();
  }
}
