package com.github.KKimishima.MailAdmin.model.mainViewModel.tableView;

public class SelectItem {
  private int primaryAddressID;
  private int secondaryAddressID;
  private int index;
  private String syainID;
  private String syainName;
  private String locationName;
  private String positionName;
  private String address;
  private String registerTime;
  private String bikou;
  private String statusName;
  private String userName;
  private String userID;

  public SelectItem(
      int index,
      int primaryAddressID,
      int secondaryAddressID,
      String syainID,
      String syainName,
      String locationName,
      String positionName,
      String address,
      String registerTime,
      String bikou,
      String statusName,
      String userID,
      String userName
  ){
    this.index = index;
    this.primaryAddressID = primaryAddressID;
    this.secondaryAddressID = secondaryAddressID;
    this.syainID = syainID;
    this.syainName = syainName;
    this.locationName = locationName;
    this.positionName = positionName;
    this.address = address;
    this.registerTime = registerTime;
    this.bikou = bikou;
    this.statusName = statusName;
    this.userName = userName;
    this.userID = userID;
  }

  public int getSecondaryAddressID() {
    return secondaryAddressID;
  }

  public int getPrimaryAddressID() {
    return primaryAddressID;
  }

  public int getIndex() {
    return index;
  }

  public String getAddress() {
    return address;
  }

  public String getBikou() {
    return bikou;
  }

  public String getLocationName() {
    return locationName;
  }

  public String getPositionName() {
    return positionName;
  }

  public String getRegisterTime() {
    return registerTime;
  }

  public String getStatusName() {
    return statusName;
  }

  public String getSyainID() {
    return syainID;
  }

  public String getSyainName() {
    return syainName;
  }

  public String getUserID() {
    return userID;
  }

  public String getUserName() {
    return userName;
  }

}
