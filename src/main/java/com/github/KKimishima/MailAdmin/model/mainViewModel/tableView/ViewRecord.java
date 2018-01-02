package com.github.KKimishima.MailAdmin.model.mainViewModel.tableView;

public class ViewRecord {
  private String  syainIDCol;
  private String  syainNameCol;
  private String  addressCol;
  private String  registerCol;
  private String  positonCol;
  private String  statusCol;
  private String  UserNameCol;
  private String  bikouCol;
  private String  locationCol;
  private String index;

  public ViewRecord(
      String index,
      String syainIDCol,
      String syainNameCol,
      String addressCol,
      String registerCol,
      String statusCol,
      String UserNameCol,
      String bikouCol,
      String locationCol,
      String positonCol
      ){
    this.index = index;
    this.syainIDCol = syainIDCol;
    this.syainNameCol = syainNameCol;
    this.addressCol = addressCol;
    this.registerCol = registerCol;
    this.statusCol = statusCol;
    this.UserNameCol = UserNameCol;
    this.bikouCol = bikouCol;
    this.locationCol = locationCol;
    this.positonCol = positonCol;
  }

  public void setIndex(String index) {
    this.index = index;
  }


  public void setPositonCol(String positonCol) {
    this.positonCol = positonCol;
  }

  public void setLocationCol(String locationCol) {
    this.locationCol = locationCol;
  }

  public void setBikouCol(String bikouCol) {
    this.bikouCol = bikouCol;
  }

  public void setAddressCol(String addressCol) {
    this.addressCol = addressCol;
  }

  public void setRegisterCol(String registerCol) {
    this.registerCol = registerCol;
  }

  public void setStatusCol(String statusCol) {
    this.statusCol = statusCol;
  }

  public void setUserNameCol(String userNameCol) {
    UserNameCol = userNameCol;
  }

  public void setSyainIDCol(String syainIDCol){
    this.syainIDCol = syainIDCol;
  }

  public void setSyainNameCol(String syainNameCol) {
    this.syainNameCol = syainNameCol;
  }


  public String getIndex() {
    return index;
  }

  public String getAddressCol() {
    return addressCol;
  }

  public String getRegisterCol() {
    return registerCol;
  }

  public String getStatusCol() {
    return statusCol;
  }

  public String getUserNameCol() {
    return UserNameCol;
  }

  public String getSyainIDCol() {
    return syainIDCol;
  }

  public String getSyainNameCol() {
    return syainNameCol;
  }

  public String getBikouCol() {
    return bikouCol;
  }

  public String getLocationCol() {
    return locationCol;
  }

  public String getPositonCol() {
    return positonCol;
  }
}
