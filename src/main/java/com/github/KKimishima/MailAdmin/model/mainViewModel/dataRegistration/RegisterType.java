package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

import static com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum.*;

public class RegisterType implements DBRegisterInterFace{
  private ViewStatus viewStatus;
  private Boolean flag;

  public RegisterType(ViewStatus viewStatus){
    this.viewStatus = viewStatus;
    this.flag = null;
  }

  public Boolean Register(){
    System.out.println("RegisterTypeの実行");
    if (viewStatus.getRegisterEnum().equals(DEFAULT)){
      return false;
    }
    if (viewStatus.getRegisterEnum().equals(CHANGE)){
      DBRegisterDAO dbRegisterDAO = new ChangeRecord(viewStatus);
      flag = dbRegisterDAO.Register();
    }else if (viewStatus.getRegisterEnum().equals(NEW)){
      DBRegisterDAO dbRegisterDAO = new NewRecord(viewStatus);
      flag = dbRegisterDAO.Register();
    }else if (viewStatus.getRegisterEnum().equals(DEL)){
      DBRegisterDAO dbRegisterDAO = new DeleteRecord(viewStatus);
      flag = dbRegisterDAO.Register();
    }
    return flag;
  }
}


