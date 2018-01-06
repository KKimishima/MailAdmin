package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;
import org.junit.Test;

import static com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum.NEW;

public class DBRegisterInterFaceTest {
  @Test
  public void register() throws Exception {
    ViewStatus viewStatus = new ViewStatus();
    viewStatus.setRegisterEnum(NEW);

    DBRegisterInterFace dbRegisterInterFace = new RegisterType(viewStatus);
    dbRegisterInterFace.Register();
  }

}