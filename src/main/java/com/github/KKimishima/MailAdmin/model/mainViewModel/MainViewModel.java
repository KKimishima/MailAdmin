package com.github.KKimishima.MailAdmin.model.mainViewModel;

import com.github.KKimishima.MailAdmin.model.mainViewModel.tableView.SelectItem;

import java.util.ArrayList;

public interface MainViewModel {
  public abstract ArrayList<SelectItem>  selectTableView();
//  public abstract ArrayList<String> selectComboData(String dataField,String dataTable);
}
