package com.github.KKimishima.MailAdmin.controller;

import javafx.scene.control.Alert;

public class Message {
  private Alert alert;
  private Alert sussed;
  public Message(){
    this.sussed = new Alert(Alert.AlertType.INFORMATION);
    this.alert = new Alert(Alert.AlertType.ERROR);
  }

  public void ErrorMessge(){
    alert.setTitle("エラータイトル");
    alert.setHeaderText("エラーヘッダー");
    alert.setContentText("エラーコンテンツ");
    alert.show();
  }

  public void SussedMessga(){
    sussed.setTitle("成功タイトル");
    sussed.setHeaderText("成功ヘッダー");
    sussed.setContentText("成功コンテンツ");
    sussed.show();
  }
}
