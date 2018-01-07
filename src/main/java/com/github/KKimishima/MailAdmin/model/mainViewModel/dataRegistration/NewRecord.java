package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewRecord extends DBRegisterDAO{

  public NewRecord(ViewStatus viewStatus){
    super(viewStatus);
  }

  @Override
  public Boolean DBRegister(ViewStatus viewStatus){
    return true;
  }
}
