package com.github.KKimishima.MailAdmin.model.mainViewModel;

import java.util.ArrayList;

public interface MainViewModel {
  public abstract void  select();
  public abstract ArrayList<SelectItem>  get();
  public abstract void Clean();
}
