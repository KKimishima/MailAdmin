package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

public class ChangeRecord extends DBRegisterDAO{

  public ChangeRecord(ViewStatus viewStatus){
    super(viewStatus);
  }

  @Override
  public Boolean DataCheck(ViewStatus viewStatus){
    System.out.println("ChangeRedordのメソッド実行:trueで返す");
    return true;
  }

}
