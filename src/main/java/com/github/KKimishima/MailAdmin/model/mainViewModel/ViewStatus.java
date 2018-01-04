package com.github.KKimishima.MailAdmin.model.mainViewModel;

import javax.swing.text.View;

public class ViewStatus {
  private int primaryAddressST;
  private int secondaryAddressST;
  private int locationST;
  private int positionST;
  private int statusRegisterST;
  private Boolean registType;

  public ViewStatus(){
    this.primaryAddressST = 0;
    this.secondaryAddressST = 0;
    this.locationST = 0;
    this.positionST = 0;
    this.statusRegisterST =0;
    this.registType = null;

  }

  public void cleanStatus(){
    this.primaryAddressST = 0;
    this.secondaryAddressST = 0;
    this.locationST = 0;
    this.positionST = 0;
    this.statusRegisterST =0;
    this.registType = true;
  }

  public Boolean getRegistType() {
    return registType;
  }

  public int getLocationST() {
    return locationST;
  }

  public int getPositionST() {
    return positionST;
  }

  public int getPrimaryAddressST() {
    return primaryAddressST;
  }

  public int getSecondaryAddressST() {
    return secondaryAddressST;
  }

  public int getStatusRegisterST() {
    return statusRegisterST;
  }

  public void setLocationST(int locationST) {
    this.locationST = locationST;
  }

  public void setPositionST(int positionST) {
    this.positionST = positionST;
  }

  public void setPrimaryAddressST(int primaryAddressST) {
    this.primaryAddressST = primaryAddressST;
  }

  public void setSecondaryAddressST(int secondaryAddressST) {
    this.secondaryAddressST = secondaryAddressST;
  }

  public void setStatusRegisterST(int statusRegisterST) {
    this.statusRegisterST = statusRegisterST;
  }

  public void setRegistType(Boolean registType) {
    this.registType = registType;
  }
}
