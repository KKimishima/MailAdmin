package com.github.KKimishima.MailAdmin.model.loginModel;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginADOTest {
    /**
   *
   * @throws Exception
   */
  @Test
  public void loginCheckTestユーザIDとユーザPassを与えて成功させる() throws Exception {
    LoginADO loginADO = new LoginADO();
    String userID = "0000";
    String userPass = "PassAdmin";
    assertEquals(true,loginADO.loginCheck(userID,userPass));
  }
  @Test
  public void loginCheckTest失敗させる() throws Exception{
    LoginADO loginADO = new LoginADO();
    String userID = "failID";
    String userPass = "failPass";
    assertEquals(false,loginADO.loginCheck(userID,userPass));
  }

}