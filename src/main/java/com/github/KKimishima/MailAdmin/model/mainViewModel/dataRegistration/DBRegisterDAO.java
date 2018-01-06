package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

public abstract class DBRegisterDAO {
  private ViewStatus viewStatus;

  public DBRegisterDAO(ViewStatus viewStatus){
    this.viewStatus = viewStatus;
  }

  public abstract Boolean DataCheck(ViewStatus viewStatus);

  public Boolean Register(){
    System.out.println("DBRegisterDAO実行:trueを返す");
    if (DataCheck(viewStatus)){
      return true;
    }
    // DBコネクト
    return true;
  }

}
