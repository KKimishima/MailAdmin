package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum;
import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChangeRecordTest {
  @Test
  public void DBRegister() throws Exception {
    ViewStatus viewStatus = new ViewStatus();
    viewStatus.setLoginUser("0000");
    viewStatus.setName("hogehoge");
    viewStatus.setAddress("hogehoge@hoge.com");
    viewStatus.setBikou(null);
    viewStatus.setUserName("test");
    viewStatus.setSyainID("1111");
    viewStatus.setLocationST(1);
    viewStatus.setPositionST(1);
    viewStatus.setRegisterEnum(RegisterEnum.CHANGE);
    viewStatus.setPrimaryAddressST(1);
    viewStatus.setSecondaryAddressST(1);
    viewStatus.setStatusRegisterST(1);

    DBRegisterDAO dbRegisterDAO = new ChangeRecord(viewStatus);
    //assertThat(dbRegisterDAO.Register(),is(true));
  }

}