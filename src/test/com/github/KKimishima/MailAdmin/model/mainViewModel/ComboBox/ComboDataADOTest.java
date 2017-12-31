package com.github.KKimishima.MailAdmin.model.mainViewModel.ComboBox;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ComboDataADOTest {
  @Test
  public void selectComboData() throws Exception {
    ComboDataADO comboDataADO = new ComboDataADO();
    ArrayList<String> list = comboDataADO.selectComboData("locationName" ,"location");
    for (String x:list){
      System.out.println(x);
    assertThat(list.get(0),is("tokyo"));
    assertThat(list.get(1),is("osak"));
    assertThat(list.get(2),is("ibaraki"));
    assertThat(list.get(3),is("saitama"));
    assertThat(list.get(4),is("shizuoka"));
    }
  }
}