package com.github.KKimishima.MailAdmin.controller;

import javafx.scene.control.Alert;

public class Message {
  private Alert alert;
  public Message(){
    this.alert = new Alert(Alert.AlertType.ERROR);
  }

  public void ErrorMessge(){
    alert.setTitle("エラータイトル");
    alert.setHeaderText("エラーヘッダー");
    alert.setContentText("エラーコンテンツ");
    alert.show();
  }
}
