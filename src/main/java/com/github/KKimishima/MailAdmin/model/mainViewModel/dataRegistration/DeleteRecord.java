package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

public class DeleteRecord extends DBRegisterDAO{
  public DeleteRecord(ViewStatus viewStatus){
    super(viewStatus);
  }

  @Override
  public Boolean DBConnect(ViewStatus viewStatus){
    System.out.println("DeleteRecordを実行trueを返す");
    return true;
  }
}
