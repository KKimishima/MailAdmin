package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum;
import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NewRecordTest {

  @Test
  public void DBRegister() throws Exception {
    ViewStatus viewStatus = new ViewStatus();
    viewStatus.setLoginUser("0000");
    viewStatus.setName("javajva");
    viewStatus.setAddress("javajvaj@javaasdgf.com");
    viewStatus.setBikou("新規登録テスト");
    viewStatus.setUserName("test");
    viewStatus.setSyainID("123rgeg4");
    viewStatus.setLocationST(1);
    viewStatus.setPositionST(1);
    viewStatus.setRegisterEnum(RegisterEnum.NEW);
    viewStatus.setPrimaryAddressST(1);
    viewStatus.setSecondaryAddressST(1);
    viewStatus.setStatusRegisterST(1);

    DBRegisterDAO dbRegisterDAO = new NewRecord(viewStatus);
 //   assertThat(dbRegisterDAO.Register(),is(true));
  }

}