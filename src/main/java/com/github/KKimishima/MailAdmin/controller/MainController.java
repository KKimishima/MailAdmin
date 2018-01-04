package com.github.KKimishima.MailAdmin.controller;

import com.github.KKimishima.MailAdmin.app.App;
import com.github.KKimishima.MailAdmin.model.loginModel.LoginADO;
import com.github.KKimishima.MailAdmin.model.mainViewModel.*;
import com.github.KKimishima.MailAdmin.model.mainViewModel.ComboData;
import com.github.KKimishima.MailAdmin.model.mainViewModel.TableViewADO;
import com.github.KKimishima.MailAdmin.model.mainViewModel.ViewRecord;
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

public class MainController implements Initializable{
  // instance(シングルトン)
  private static MainController instance;
  // scenes(シングルトン)
  private static Scene SCENE;

  @FXML
  private TableView<ViewRecord> infoView;
  @FXML
  private TableColumn<ViewRecord,String> syainIDColumn;
  @FXML
  private TableColumn<ViewRecord,String> syainNameColumn;
  @FXML
  private TableColumn<ViewRecord,String> addressColumn;
  @FXML
  private TableColumn<ViewRecord,String> registerColumn;
  @FXML
  private TableColumn<ViewRecord,String> statusColumn;
  @FXML
  private TableColumn<ViewRecord,String> UserNameColumn;
  @FXML
  private Text loginUserTex;
  @FXML
  private Text syainIDTex;
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
// 実験  private ComboBox<Test> searchCom;

  private ObservableList<ViewRecord> data;
  private MainViewModel mainViewModel;
  private ArrayList<ViewRecord> list;
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
    mainViewModel = new TableViewADO();
    mainViewModel.setList();
    list = mainViewModel.getList();

    data = FXCollections.observableArrayList();
    infoView.setItems(data);
    syainIDColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("syainIDCol"));
    syainNameColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("syainNameCol"));
    addressColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("addressCol"));
    registerColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("registerCol"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("statusCol"));
    UserNameColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("UserNameCol"));

    viewStatus = new ViewStatus();
    infoView.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal) ->{
      //nullが出たら脱出
      if (newVal == null){return;}
      syainIDTex.setText(newVal.getSyainIDCol());
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
      viewStatus.setRegistType(false);

      viewStatus.setPrimaryAddressST(newVal.getPrimaryAddressID());
      viewStatus.setSecondaryAddressST(newVal.getSecondaryAddressID());

    });
    infoView.getItems().addAll(mainViewModel.getList());

    comboData = new ComboData();
    registerCom.getItems().addAll(comboData.registList());
    registerCom.getSelectionModel().select(0);
    registerCom.getSelectionModel().selectedIndexProperty().addListener((observable,oldVal,newVal) ->{
      if (newVal.intValue() == 1){
        syainIDTex.setText("");
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
      viewStatus.setPositionST(newVal.intValue() + 1);
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
    System.out.println("-- 変更可能な勤務地と役職の変更");
    System.out.println("場所" + viewStatus.getLocationST());
    System.out.println("役職" + viewStatus.getPositionST());
    System.out.println("主アドレス" + viewStatus.getPrimaryAddressST());
    System.out.println("社員番号" + syainIDTex.getText());

    System.out.println(" --登録情報系");
    System.out.println("ユーザID" + UserNameTex.getText());
    System.out.println("登録状態" +viewStatus.getStatusRegisterST());
    System.out.println("備考" + bikouTex.getText());

    System.out.println("登録タイプ" + viewStatus.getRegistType());
  }


}
