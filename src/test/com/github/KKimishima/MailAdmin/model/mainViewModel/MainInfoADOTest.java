package com.github.KKimishima.MailAdmin.model.mainViewModel;

import com.github.KKimishima.MailAdmin.model.mainViewModel.tableView.SelectItem;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MainInfoADOTest {
  @Test
  public void selectTest検索でエラーで落ちないか確認() throws Exception {
    MainInfoADO mainInfoADO = new MainInfoADO();
    mainInfoADO.select();
  }


  @Test
  public void getTest取得されたアイテムの() throws Exception {
    MainInfoADO mainInfoADO = new MainInfoADO();
    mainInfoADO.select();
    ArrayList<SelectItem> list = mainInfoADO.get();
   assertThat(list.get(0).getSyainID(),is("11111"));
   assertThat(list.get(0).getSyainName(),is("hogehoge"));
   assertThat(list.get(0).getLocationName(),is("tokyo"));
   assertThat(list.get(0).getPositionName(),is("一般職"));
   assertThat(list.get(0).getAddress(),is("hogehoge@hogehoge.com"));
   assertThat(list.get(0).getRegisterTime(),is("2017-12-23 18:34:16"));
   assertThat(list.get(0).getBikou(),is("一番目"));
   assertThat(list.get(0).getStatusName(),is("未登録"));
   assertThat(list.get(0).getUserName(),is("admin"));
   assertThat(list.get(0).getUserID(),is("0000"));

   assertThat(list.get(1).getSyainID(),is("11112"));
   assertThat(list.get(1).getSyainName(),is("foofoo"));
   assertThat(list.get(1).getLocationName(),is("osak"));
   assertThat(list.get(1).getPositionName(),is("管理職"));
   assertThat(list.get(1).getAddress(),is("foofoo@foofoo.com"));
   assertThat(list.get(1).getRegisterTime(),is("2017-12-23 18:34:16"));
   assertThat(list.get(1).getBikou(),is("二番目"));
   assertThat(list.get(1).getStatusName(),is("返信待ち"));
   assertThat(list.get(1).getUserName(),is("user1"));
   assertThat(list.get(1).getUserID(),is("0001"));
  }

  @Test
  public void cleanTestアイテムのなかみがnullかk民() throws Exception {
    MainInfoADO mainInfoADO = new MainInfoADO();
    mainInfoADO.select();
    ArrayList<SelectItem> list = mainInfoADO.get();
    mainInfoADO.Clean();
    assertEquals(mainInfoADO.get(),null);
  }

}