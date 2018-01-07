package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

public class NewRecord extends DBRegisterDAO{

  public NewRecord(ViewStatus viewStatus){
    super(viewStatus);
  }

  @Override
  public Boolean DBConnect(ViewStatus viewStatus){
    System.out.println("NewRecord実行trueの返す");
    return true;
  }
}
