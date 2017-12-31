package com.github.KKimishima.MailAdmin.model.mainViewModel.ComboBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ComboData {
  private HashMap<String,ArrayList<String>> combMap;
  public ComboData(){
    combMap = new HashMap<String, ArrayList<String>>();
    ArrayList<String> list = new ArrayList<>();
    list.add("東京");
    list.add("大阪");
    list.add("仙台");
    combMap.put("loc",list);
  }
  public HashMap<String,ArrayList<String>> getCombMap(){
    return combMap;
  }
}
