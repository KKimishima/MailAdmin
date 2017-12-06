package com.github.KKimishima.MailAdmin.model.loginModel;

public interface LoginModel {
  abstract public boolean loginCheck(String userID,String userPass);
}
