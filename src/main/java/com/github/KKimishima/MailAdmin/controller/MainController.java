package com.github.KKimishima.MailAdmin.controller;

import com.github.KKimishima.MailAdmin.app.App;
import com.github.KKimishima.MailAdmin.model.loginModel.LoginADO;
import com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration.DBRegisterInterFace;
import com.github.KKimishima.MailAdmin.model.mainViewModel.dataRegistration.RegisterType;
import com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.github.KKimishima.MailAdmin.model.mainViewModel.viewInterFace.RegisterEnum.CHANGE;

public class MainController implements Initializable{
  // instance(シングルトン)
  private static MainController instance;
  // scenes(シングルトン)
  private static Scene SCENE;

  @FXML
  private TableView<ViewData> infoView;
  @FXML
  private TableColumn<ViewData,String> syainIDColumn;
  @FXML
  private TableColumn<ViewData,String> syainNameColumn;
  @FXML
  private TableColumn<ViewData,String> addressColumn;
  @FXML
  private TableColumn<ViewData,String> registerColumn;
  @FXML
  private TableColumn<ViewData,String> statusColumn;
  @FXML
  private TableColumn<ViewData,String> UserNameColumn;
  @FXML
  private Text loginUserTex;
  @FXML
  private TextField syainIDTex;
  @FXML
  private TextField addressTex;
  @FXML
  private TextField nameTex;
  @FXML
  private TextArea bikouTex;
  @FXML
  private ComboBox<String> locationCom;
  @FXML
  private ComboBox<String> statusCom;
  @FXML
  private Text UserNameTex;
  @FXML
  private ComboBox<String> positionCom;
  @FXML
  private  ComboBox<String> registerCom;
  @FXML
  private ComboBox<String> searchCom;

  private ObservableList<ViewData> data;
  private ViewDataModel viewDataModel;
  private ArrayList<ViewData> list;
  private ComboData comboData;
  private ViewStatus viewStatus;

  // 画面生成
  // クラスが読み込まれ時に実行
  // コンストラクタより早く実行される
  static {
    FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("fxml/MainView.fxml"));
    try{
      fxmlLoader.load();
    }catch (IOException e){
      e.printStackTrace();
    }
    Parent parent = fxmlLoader.getRoot();
    Scene scene = new Scene(parent);
    SCENE = scene;
    instance = fxmlLoader.getController();
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    loginUserTex.setText(LoginADO.getUserID());
    viewDataModel = new ViewDataDataADO();
    viewDataModel.setList();
    list = viewDataModel.getList();

    data = FXCollections.observableArrayList();
    infoView.setItems(data);
    syainIDColumn.setCellValueFactory(new PropertyValueFactory<ViewData, String>("syainIDCol"));
    syainNameColumn.setCellValueFactory(new PropertyValueFactory<ViewData, String>("syainNameCol"));
    addressColumn.setCellValueFactory(new PropertyValueFactory<ViewData, String>("addressCol"));
    registerColumn.setCellValueFactory(new PropertyValueFactory<ViewData, String>("registerCol"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<ViewData, String>("statusCol"));
    UserNameColumn.setCellValueFactory(new PropertyValueFactory<ViewData, String>("UserNameCol"));

    viewStatus = new ViewStatus();
    infoView.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal) ->{
      //nullが出たら脱出
      if (newVal == null){return;}
      syainIDTex.setText(newVal.getSyainIDCol());
      syainIDTex.setEditable(false);
      addressTex.setText(newVal.getAddressCol());
      nameTex.setText(newVal.getSyainNameCol());
      bikouTex.setText(newVal.getBikouCol());
      locationCom.setValue(newVal.getLocationCol());
      viewStatus.setLocationST(newVal.getLocationID());

      statusCom.setValue(newVal.getStatusCol());
      viewStatus.setStatusRegisterST(newVal.getStatusRegister());

      UserNameTex.setText(newVal.getUserNameCol());

      positionCom.setValue(newVal.getPositonCol());
      viewStatus.setPositionST(newVal.getPositionID());

      registerCom.getSelectionModel().select(0);
      viewStatus.setRegisterEnum(CHANGE);

      viewStatus.setPrimaryAddressST(newVal.getPrimaryAddressID());
      viewStatus.setSecondaryAddressST(newVal.getSecondaryAddressID());

    });
    infoView.getItems().addAll(viewDataModel.getList());

    comboData = new ComboData();
    registerCom.getItems().addAll(comboData.registList());
    registerCom.getSelectionModel().select(0);
    registerCom.getSelectionModel().selectedIndexProperty().addListener((observable,oldVal,newVal) ->{
      if (newVal.intValue() == 1){
        syainIDTex.setText("");
        syainIDTex.setEditable(true);
        addressTex.setText("");
        nameTex.setText("");
        bikouTex.setText("");
        locationCom.setValue("");
        statusCom.setValue("");
        UserNameTex.setText("");
        positionCom.setValue("");
        viewStatus.cleanStatus();
      }
    });
    searchCom.getItems().addAll(comboData.searchList());

    locationCom.getItems().addAll(comboData.getLocationCom());
    locationCom.getSelectionModel().selectedIndexProperty().addListener((observable,oldVal,newVal) -> {
      viewStatus.setLocationST(newVal.intValue() + 1);
    });

    positionCom.getItems().addAll(comboData.getPositionCom());
    positionCom.getSelectionModel().selectedIndexProperty().addListener((observable,oldVal,newVal) ->{
      viewStatus.setPositionST(newVal.intValue() + 1);
    });
    statusCom.getItems().addAll(comboData.getStatusCom());
    statusCom.getSelectionModel().selectedIndexProperty().addListener((observable,oldVal,newVal) ->{
      viewStatus.setStatusRegisterST(newVal.intValue() + 1);
    });
  }

  // instance(シングルトン)を返す
  public static MainController getInstance(){
    return instance;
  }
  // 表示する
  public void show(){
    App.presentStage.setScene(SCENE);
  }
  public void onRegister(){
    viewStatus.setSyainID(syainIDTex.getText());
    viewStatus.setUserName(UserNameTex.getText());
    viewStatus.setBikou(bikouTex.getText());
    viewStatus.setAddress(addressTex.getText());
    viewStatus.setName(nameTex.getText());
    viewStatus.setLoginUser(loginUserTex.getText());

    DBRegisterInterFace dbRegisterInterFace = new RegisterType(viewStatus);
    if (!dbRegisterInterFace.Register()){
      Message message = new Message();
      message.ErrorMessge();
      return;
    }else {
      Message message = new Message();
      message.SussedMessga();
      refresh();
    }
  }
  public void onRefresh(){
    refresh();
  }
  private void refresh(){
    infoView.getItems().clear();
    viewDataModel.cleanList();
    viewDataModel.setList();
    infoView.getItems().addAll(viewDataModel.getList());
  }
}
