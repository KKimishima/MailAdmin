package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

public abstract class DBRegisterDAO {
  private ViewStatus viewStatus;

  public DBRegisterDAO(ViewStatus viewStatus){
    this.viewStatus = viewStatus;
  }

  public abstract Boolean DBConnect(ViewStatus viewStatus);

  public Boolean Register(){
    System.out.println("DBRegisterDAO実行:trueを返す");
    if (DataCheck()){
      return true;
    }
    // DBコネクト
    return true;
  }

  private boolean DataCheck(){
    System.out.println("テストメソッド");
    return true;
  }

}
