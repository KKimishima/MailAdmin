package com.github.KKimishima.MailAdmin.controller;

import com.github.KKimishima.MailAdmin.app.App;
import com.github.KKimishima.MailAdmin.model.mainViewModel.MainInfoADO;
import com.github.KKimishima.MailAdmin.model.mainViewModel.MainViewModel;
import com.github.KKimishima.MailAdmin.model.mainViewModel.SelectItem;
import com.github.KKimishima.MailAdmin.model.mainViewModel.ViewRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

  private ObservableList<ViewRecord> data;


  private MainViewModel mainViewModel;
  private ArrayList<SelectItem> list;

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
    mainViewModel = new MainInfoADO();
    mainViewModel.select();
    list = mainViewModel.get();

    data = FXCollections.observableArrayList();
    infoView.setItems(data);
    syainIDColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("syainIDCol"));
    syainNameColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("syainNameCol"));
    addressColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("addressCol"));
    registerColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("registerCol"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("statusCol"));
    UserNameColumn.setCellValueFactory(new PropertyValueFactory<ViewRecord, String>("UserNameCol"));

    for (SelectItem s:list) {
      infoView.getItems().add(new ViewRecord(
          s.getSyainID(),
          s.getSyainName(),
          s.getAddress(),
          s.getRegisterTime(),
          s.getStatusName(),
          s.getUserName()
      ));
    }
    //infoView.getItems().add(new ViewRecord(,));

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
    System.out.println("登録ボタンが押されました");
  }
}
