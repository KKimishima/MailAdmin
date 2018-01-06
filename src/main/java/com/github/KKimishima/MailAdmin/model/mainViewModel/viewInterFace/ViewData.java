package com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace;

public class ViewData {
  private int primaryAddressID;
  private int secondaryAddressID;
  private int locationID;
  private int positionID;
  private int statusRegister;
  private String  syainIDCol;
  private String  syainNameCol;
  private String  addressCol;
  private String  registerCol;
  private String  positonCol;
  private String  statusCol;
  private String  UserNameCol;
  private String  bikouCol;
  private String  locationCol;
  private String  userIDCol;

  public ViewData(
      int primaryAddressID,
      int secondaryAddressID,
      int locationID,
      int positionID,
      int statusRegister,
      String syainIDCol,
      String syainNameCol,
      String locationCol,
      String positonCol,
      String addressCol,
      String registerCol,
      String bikouCol,
      String statusCol,
      String userIDCol,
      String UserNameCol
      ){
    this.primaryAddressID = primaryAddressID;
    this.secondaryAddressID = secondaryAddressID;
    this.locationID = locationID;
    this.positionID = positionID;
    this.statusRegister = statusRegister;
    this.syainIDCol = syainIDCol;
    this.syainNameCol = syainNameCol;
    this.addressCol = addressCol;
    this.registerCol = registerCol;
    this.statusCol = statusCol;
    this.UserNameCol = UserNameCol;
    this.bikouCol = bikouCol;
    this.locationCol = locationCol;
    this.positonCol = positonCol;
    this.primaryAddressID = primaryAddressID;
    this.userIDCol = userIDCol;
  }

  public void setUserIDCol(String userIDCol) {
    this.userIDCol = userIDCol;
  }

  public void setLocationID(int locationID) {
    this.locationID = locationID;
  }

  public void setPositionID(int positionID) {
    this.positionID = positionID;
  }

  public void setSecondaryAddressID(int secondaryAddressID) {
    this.secondaryAddressID = secondaryAddressID;
  }

  public void setStatusRegister(int statusRegister) {
    this.statusRegister = statusRegister;
  }

  public int getSecondaryAddressID() {
    return secondaryAddressID;
  }

  public void setPrimaryAddressID(int primaryAddressID) {
    this.primaryAddressID = primaryAddressID;
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

  public String getUserIDCol() {
    return userIDCol;
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

  public int getPrimaryAddressID() {
    return primaryAddressID;
  }

  public int getLocationID() {
    return locationID;
  }

  public int getPositionID() {
    return positionID;
  }

  public int getStatusRegister() {
    return statusRegister;
  }
}
