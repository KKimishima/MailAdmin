package com.github.KKimishima.MailAdmin.model.mainViewModel;

import com.github.KKimishima.MailAdmin.model.mainViewModel.tableView.SelectItem;

import java.util.ArrayList;
import java.util.HashSet;

public interface MainViewModel {
  //public abstract ArrayList<SelectItem>  selectTableView();
  public abstract void setList();
  public abstract ArrayList<SelectItem> getList();
  public abstract void cleanList();
  public abstract HashSet<String> getLoction();
  public abstract HashSet<String> getPostion();
  public abstract HashSet<String> getStatus();
}
