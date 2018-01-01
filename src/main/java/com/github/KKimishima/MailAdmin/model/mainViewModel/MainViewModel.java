package com.github.KKimishima.MailAdmin.model.mainViewModel;

import com.github.KKimishima.MailAdmin.model.mainViewModel.tableView.SelectItem;

import java.util.ArrayList;

public interface MainViewModel {
  //public abstract ArrayList<SelectItem>  selectTableView();
  public abstract void setList();
  public abstract ArrayList<SelectItem> getList();
  public abstract void cleanList();
}
