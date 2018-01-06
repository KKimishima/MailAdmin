package com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace;

import javax.swing.text.View;

import static com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum.DEFAULT;
import static com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum.NEW;

public class ViewStatus {
  private int primaryAddressST;
  private int secondaryAddressST;
  private int locationST;
  private int positionST;
  private int statusRegisterST;
  private RegisterEnum registerEnum;
  private String syainID;
  private String userName;
  private String bikou;

  public ViewStatus(){
    this.primaryAddressST = 0;
    this.secondaryAddressST = 0;
    this.locationST = 0;
    this.positionST = 0;
    this.statusRegisterST =0;
    this.registerEnum = DEFAULT;
    this.syainID = null;
    this.userName = null;
    this.bikou = null;
  }

  public void cleanStatus(){
    this.primaryAddressST = 0;
    this.secondaryAddressST = 0;
    this.locationST = 0;
    this.positionST = 0;
    this.statusRegisterST =0;
    this.registerEnum = NEW;
    this.syainID = null;
    this.userName = null;
    this.bikou = null;
  }

  public String getUserName() {
    return userName;
  }

  public String getSyainID() {
    return syainID;
  }

  public String getBikou() {
    return bikou;
  }


  public RegisterEnum getRegisterEnum() {
    return registerEnum;
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

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setSyainID(String syainID) {
    this.syainID = syainID;
  }

  public void setBikou(String bikou) {
    this.bikou = bikou;
  }

  public void setRegisterEnum(RegisterEnum registerEnum) {
    this.registerEnum = registerEnum;
  }

}
