package com.github.KKimishima.MailAdmin.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Message {
  private Alert alert;
  private Alert sussed;
  private Alert confirmation;
  public Message(){
    this.sussed = new Alert(Alert.AlertType.INFORMATION);
    this.alert = new Alert(Alert.AlertType.ERROR);
    this.confirmation = new Alert(Alert.AlertType.CONFIRMATION);
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
  public void ConfirmationMessage(){
    confirmation.setTitle("確認タイトル");
    confirmation.setHeaderText("確認ヘッダー");
    confirmation.setContentText("確認コンテンツ");
    confirmation.show();
  }
}
