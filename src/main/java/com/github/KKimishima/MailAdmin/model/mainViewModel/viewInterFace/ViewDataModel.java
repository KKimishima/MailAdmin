package com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace;

import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.ViewData;

import java.util.ArrayList;

public interface ViewDataModel {
  public abstract void setList();
  public abstract ArrayList<ViewData> getList();
  public abstract void cleanList();
}
