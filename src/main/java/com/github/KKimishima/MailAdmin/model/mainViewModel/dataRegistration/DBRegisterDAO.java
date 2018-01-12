package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum;
import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

import static com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum.NEW;
import static com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum.SUBNEW;

public abstract class DBRegisterDAO {
  private ViewStatus viewStatus;

  public DBRegisterDAO(ViewStatus viewStatus){
    this.viewStatus = viewStatus;
  }

  public abstract Boolean DBRegister(ViewStatus viewStatus);

  public Boolean Register(){
    if (!DataCheck()){
      return false;
    }
    if (!jdbcLoad()){
      return false;
    }
    if (!DBRegister(viewStatus)){
      return false;
    }
    // DBコネクト
    return true;
  }

  private boolean DataCheck(){
    Boolean flag = true;
    // サブアドレス登録の場合はここでチェック終わり
    if (viewStatus.getSyainID().equals("")) {flag = false;}
    String mailFormat = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
    if (!viewStatus.getAddress().matches(mailFormat)){flag = false;}
    if (viewStatus.getRegisterEnum().equals(SUBNEW)){return flag;}

    // 新規登録の場合は個々で終わり
    if (viewStatus.getStatusRegisterST() == 0){flag = false;}
    if (viewStatus.getPositionST() == 0){flag = false;}
    if (viewStatus.getLocationST() == 0){flag = false;}
    if (viewStatus.getRegisterEnum().equals(NEW)){return flag;}

    // 変更と削除はここで実行
    if (viewStatus.getPrimaryAddressST() == 0) {flag = false;}
    if (viewStatus.getSecondaryAddressST() == 0) {flag = false;}
    if (viewStatus.getName().equals("")){flag = false;}
    if (viewStatus.getLoginUser().equals("")){flag = false;}
    return flag;
  }
  private Boolean jdbcLoad(){
    try{
      Class.forName("org.sqlite.JDBC");
    }catch (ClassNotFoundException e){
      return false;
    }
    return true;
  }
}
