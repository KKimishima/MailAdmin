package com.github.KKimishima.MailAdmin.model.mainViewModel.tableView;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewDataDataADO;
import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewData;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TableViewADOTest {
  @Test
  public void getLoction() throws Exception {
    ViewDataDataADO viewDataADO = new ViewDataDataADO();
    viewDataADO.setList();
    HashSet<String> hashSet = new HashSet<>();
    hashSet.add("tokyo");
    hashSet.add("ibaraki");
    hashSet.add("osak");
    assertThat(viewDataADO.getLoction(),is(hashSet));
  }

  @Test
  public void getPostion() throws Exception {
    ViewDataDataADO viewDataADO = new ViewDataDataADO();
    viewDataADO.setList();
    HashSet<String> hashSet = new HashSet<>();
    hashSet.add("管理職");
    hashSet.add("一般職");
    assertThat(viewDataADO.getPostion(),is(hashSet));
  }

  @Test
  public void getStatus() throws Exception {
    ViewDataDataADO viewDataADO = new ViewDataDataADO();
    viewDataADO.setList();
    HashSet<String> hashSet = new HashSet<>();
    hashSet.add("返信待ち");
    hashSet.add("未登録");
    hashSet.add("登録完了");
    assertThat(viewDataADO.getStatus(),is(hashSet));
  }


  @Test
  public void setListTestでSQLで落ちないか確認() throws Exception {
    ViewDataDataADO mainInfoADO = new ViewDataDataADO();
    mainInfoADO.setList();
  }
  @Test
  public void getList() throws Exception {
    ViewDataDataADO viewDataADO = new ViewDataDataADO();
    viewDataADO.setList();
    ArrayList<ViewData> list = new ArrayList();
    list = viewDataADO.getList();
    assertThat(list.get(0).getLocationID(),is(1));
    assertThat(list.get(0).getSecondaryAddressID(),is(1));
    assertThat(list.get(0).getLocationID(),is(1));
    assertThat(list.get(0).getPositionID(),is(1));
    assertThat(list.get(0).getStatusRegister(),is(1));
   assertThat(list.get(0).getSyainIDCol(),is("11111"));
   assertThat(list.get(0).getSyainNameCol(),is("hogehoge"));
   assertThat(list.get(0).getLocationCol(),is("tokyo"));
   assertThat(list.get(0).getPositonCol(),is("一般職"));
   assertThat(list.get(0).getAddressCol(),is("hogehoge@hogehoge.com"));
   assertThat(list.get(0).getRegisterCol(),is("2017-12-23 18:34:16"));
   assertThat(list.get(0).getBikouCol(),is("一番目"));
   assertThat(list.get(0).getStatusCol(),is("未登録"));
   assertThat(list.get(0).getUserNameCol(),is("admin"));
   assertThat(list.get(0).getUserIDCol(),is("0000"));

//   assertThat(list.get(1).getSyainID(),is("11112"));
//   assertThat(list.get(1).getSyainName(),is("foofoo"));
//   assertThat(list.get(1).getLocationName(),is("osak"));
//   assertThat(list.get(1).getPositionName(),is("管理職"));
//   assertThat(list.get(1).getAddress(),is("foofoo@foofoo.com"));
//   assertThat(list.get(1).getRegisterTime(),is("2017-12-23 18:34:16"));
//   assertThat(list.get(1).getBikou(),is("二番目"));
//   assertThat(list.get(1).getStatusName(),is("返信待ち"));
//   assertThat(list.get(1).getUserName(),is("user1"));
//   assertThat(list.get(1).getUserID(),is("0001"));
  }
  @Test
  public void cleanList() throws Exception {
    ViewDataDataADO viewDataADO = new ViewDataDataADO();
    viewDataADO.setList();
    viewDataADO.cleanList();
    assertEquals(true, viewDataADO.getList().isEmpty());
  }
}