package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

public abstract class DBRegisterDAO {
  private ViewStatus viewStatus;

  public DBRegisterDAO(ViewStatus viewStatus){
    this.viewStatus = viewStatus;
  }

  public abstract Boolean DBConnect(ViewStatus viewStatus);

  public Boolean Register(){
    if (!DataCheck()){
      return false;
    }
    // DBコネクト
    return true;
  }

  private boolean DataCheck(){
    Boolean flag = true;
    if (viewStatus.getSyainID().equals("")) {flag = false;}
    if (viewStatus.getPrimaryAddressST() == 0) {flag = false;}
    if (viewStatus.getSecondaryAddressST() == 0) {flag = false;}
    if (viewStatus.getStatusRegisterST() == 0){flag = false;}
    if (viewStatus.getPositionST() == 0){flag = false;}
    if (viewStatus.getLocationST() == 0){flag = false;}

    String mailFormat = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
    if (!viewStatus.getAddress().matches(mailFormat)){flag = false;}

    if (viewStatus.getName().equals("")){flag = false;}
    if (viewStatus.getLoginUser().equals("")){flag = false;}
    return flag;
  }

}
