package com.github.KKimishima.MailAdmin.model.mainViewModel.tableView;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TableViewADOTest {
  @Test
  public void getLoction() throws Exception {
    TableViewADO tableViewADO = new TableViewADO();
    tableViewADO.setList();
    HashSet<String> hashSet = new HashSet<>();
    hashSet.add("tokyo");
    hashSet.add("ibaraki");
    hashSet.add("osak");
    assertThat(tableViewADO.getLoction(),is(hashSet));
  }

  @Test
  public void getPostion() throws Exception {
    TableViewADO tableViewADO = new TableViewADO();
    tableViewADO.setList();
    HashSet<String> hashSet = new HashSet<>();
    hashSet.add("管理職");
    hashSet.add("一般職");
    assertThat(tableViewADO.getPostion(),is(hashSet));
  }

  @Test
  public void getStatus() throws Exception {
    TableViewADO tableViewADO = new TableViewADO();
    tableViewADO.setList();
    HashSet<String> hashSet = new HashSet<>();
    hashSet.add("返信待ち");
    hashSet.add("未登録");
    hashSet.add("登録完了");
    assertThat(tableViewADO.getStatus(),is(hashSet));
  }


  @Test
  public void setListTestでSQLで落ちないか確認() throws Exception {
    TableViewADO mainInfoADO = new TableViewADO();
    mainInfoADO.setList();
  }
  @Test
  public void getList() throws Exception {
    TableViewADO tableViewADO = new TableViewADO();
    tableViewADO.setList();
    ArrayList<SelectItem> list = new ArrayList();
    list = tableViewADO.getList();
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
  public void cleanList() throws Exception {
    TableViewADO tableViewADO = new TableViewADO();
    tableViewADO.setList();
    tableViewADO.cleanList();
    assertEquals(true,tableViewADO.getList().isEmpty());
  }
}