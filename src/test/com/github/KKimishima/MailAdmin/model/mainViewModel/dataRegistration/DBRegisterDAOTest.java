package com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum;
import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewStatus;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DBRegisterDAOTest {
  @Test
  public void DBConnect() throws Exception {

  }

  @Test
  public void registerTestチェックを成功させいる() throws Exception {
    ViewStatus viewStatus = new ViewStatus();
    viewStatus.setLoginUser("11111");
    viewStatus.setName("hogehoge");
    viewStatus.setAddress("hogehoge@hoge.com");
    viewStatus.setBikou(null);
    viewStatus.setUserName("1111");
    viewStatus.setSyainID("aaa");
    viewStatus.setLocationST(1);
    viewStatus.setPositionST(1);
    viewStatus.setRegisterEnum(RegisterEnum.CHANGE);
    viewStatus.setPrimaryAddressST(1);
    viewStatus.setSecondaryAddressST(1);
    viewStatus.setStatusRegisterST(1);

    DBRegisterDAO dbRegisterDAO = new ChangeRecord(viewStatus);
    assertThat(dbRegisterDAO.Register(),is(true));
  }
  @Test
  public void registerTestメールアドレスの失敗させる() throws Exception {
    ViewStatus viewStatus = new ViewStatus();
    viewStatus.setLoginUser("11111");
    viewStatus.setName("hogehoge");
    viewStatus.setAddress("hogehogehoge.com");
    viewStatus.setBikou(null);
    viewStatus.setUserName("1111");
    viewStatus.setSyainID("aaa");
    viewStatus.setLocationST(1);
    viewStatus.setPositionST(1);
    viewStatus.setRegisterEnum(RegisterEnum.CHANGE);
    viewStatus.setPrimaryAddressST(1);
    viewStatus.setSecondaryAddressST(1);
    viewStatus.setStatusRegisterST(1);

    DBRegisterDAO dbRegisterDAO = new ChangeRecord(viewStatus);
    assertThat(dbRegisterDAO.Register(), is(false));
  }
    @Test
  public void registerTest文字列のトリムテスト() throws Exception {
      ViewStatus viewStatus = new ViewStatus();
      viewStatus.setLoginUser("11111 ");
      viewStatus.setName(" hogehoge ");
      viewStatus.setAddress("hogehogehoge.com");
      viewStatus.setBikou(null);
      viewStatus.setUserName("1111\n");
      viewStatus.setSyainID("　　aaa　");
      viewStatus.setLocationST(1);
      viewStatus.setPositionST(1);
      viewStatus.setRegisterEnum(RegisterEnum.CHANGE);
      viewStatus.setPrimaryAddressST(1);
      viewStatus.setSecondaryAddressST(1);
      viewStatus.setStatusRegisterST(1);

      assertThat(viewStatus.getLoginUser(),is("11111"));
      assertThat(viewStatus.getName(),is("hogehoge"));
      assertThat(viewStatus.getUserName(),is("1111"));
      assertThat(viewStatus.getSyainID(),is("aaa"));

    }
    @Test
    public void registerTest数値で失敗するか確認() throws Exception {
      ViewStatus viewStatus = new ViewStatus();
      viewStatus.setLoginUser("11111 ");
      viewStatus.setName(" hogehoge ");
      viewStatus.setAddress("hogehogehoge.com");
      viewStatus.setBikou(null);
      viewStatus.setUserName("1111\n");
      viewStatus.setSyainID("　　aaa　");
      viewStatus.setLocationST(0);
      viewStatus.setPositionST(0);
      viewStatus.setRegisterEnum(RegisterEnum.CHANGE);
      viewStatus.setPrimaryAddressST(0);
      viewStatus.setSecondaryAddressST(0);
      viewStatus.setStatusRegisterST(0);


      DBRegisterDAO dbRegisterDAO = new ChangeRecord(viewStatus);
      assertThat(dbRegisterDAO.Register(), is(false));
  }
}