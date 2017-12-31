package com.github.KKimishima.MailAdmin.model.loginModel;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LoginADOTest {

  @Test
  public void cleanLogin() throws Exception {
    String userID = "0000";
    String userPass = "PassAdmin";
    LoginADO loginADO = new LoginADO(userID,userPass);
    loginADO.loginCheck();
    loginADO.cleanLogin();
    assertThat(null,is(loginADO.getUserID()));
  }


  /**
   *
   * @throws Exception
   */
  @Test
  public void loginCheckTestユーザIDとユーザPassを与えて成功させる() throws Exception {
    String userID = "0000";
    String userPass = "PassAdmin";
    LoginADO loginADO = new LoginADO(userID,userPass);
    assertEquals(true,loginADO.loginCheck());
  }
  @Test
  public void loginCheckTest失敗させる() throws Exception{
    String userID = "failID";
    String userPass = "failPass";
    LoginADO loginADO = new LoginADO(userID,userPass);
    assertEquals(false,loginADO.loginCheck());
  }
}