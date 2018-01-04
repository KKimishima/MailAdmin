package com.github.KKimishima.MailAdmin.model.mainViewModel;

import java.util.ArrayList;
import java.util.HashSet;

public interface MainViewModel {
  public abstract void setList();
  public abstract ArrayList<ViewRecord> getList();
  public abstract void cleanList();
  public abstract HashSet<String> getLoction();
  public abstract HashSet<String> getPostion();
  public abstract HashSet<String> getStatus();
}
