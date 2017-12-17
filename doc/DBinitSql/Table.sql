-- テーブルの作成
/*
    ログイン用テーブル作成
    id      連番番号     数値  主キー,連番,null禁止
    userID  ログイン用ID テキスト    null禁止
    pass    パスワード   テキスト    null禁止
*/

create table loginUser(
    id integer primary key AUTOINCREMENT NOT NULL,
    userID text not null,
    userName text not null,
    pass text not null
);

-- テストユーザ
insert into loginUser(userID,userName,pass) values("0000","admin","hogehoge");
insert into loginUser(userID,userName,pass) values("0001","user1","foofoo");
insert into loginUser(userID,userName,pass) values("0000","user2","barbar");

-- 勤務地テーブル
/*
    勤務地テーブル
    locationID      勤務地ID   数値      主キー,null禁止
    locationNmae    勤務地名   テキスト  null禁止
*/
create table location(
    locationID integer primary key not null,
    locationName text not null
);

-- テスト勤務地
insert into location(locationID,locationName) values(1,"tokyo");
insert into location(locationID,locationName) values(2,"osak");
insert into location(locationID,locationName) values(3,"ibaraki");
insert into location(locationID,locationName) values(4,"saitama");
insert into location(locationID,locationName) values(5,"shizuoka");

/*
    登録進行状況
    statusRegisterID    登録進行状態ID    数値    数値 主キー,null禁止
    statusName          進行状態名称      テキスト null禁止
*/
-- 登録進行状況
create table statusRegister(
    statusRegisterID integer primary key not null,
    statusName text not null
);

-- テストステータス
insert into statusRegister(statusRegisterID,statusName) values(1,"未登録");
insert into statusRegister(statusRegisterID,statusName) values(2,"返信待ち");
insert into statusRegister(statusRegisterID,statusName) values(3,"登録完了");

/*
    * 複合キーテーブル
    8件
    メールアドレス
    primaryAddressID    アドレスの基準ID   数値  主キー,null禁止
    maillAddressID      追加するアドレスID 数値  主キー,null禁止
    address テキスト null禁止
*/
-- メールアドレス
create table maillAddress(
    primaryAddressID integer not null,
    secondaryAddressID text not null,
    address text not null,
    primary key (primaryAddressID,secondaryAddressID)
);

--- テストメールアドレス
insert into maillAddress(primaryAddressID,secondaryAddressID,address) values(1,1,"hogehoge@hogehoge.com");
insert into maillAddress(primaryAddressID,secondaryAddressID,address) values(2,1,"foofoo@foofoo.com");
insert into maillAddress(primaryAddressID,secondaryAddressID,address) values(3,1,"barbar@barbar.com");
insert into maillAddress(primaryAddressID,secondaryAddressID,address) values(4,1,"poapoa@poopoo.com");
insert into maillAddress(primaryAddressID,secondaryAddressID,address) values(4,2,"poapoa2@poopoo.com");
insert into maillAddress(primaryAddressID,secondaryAddressID,address) values(5,1,"bakabaka@bakabaka.com");
insert into maillAddress(primaryAddressID,secondaryAddressID,address) values(6,1,"poopoo@poopoo.com");
insert into maillAddress(primaryAddressID,secondaryAddressID,address) values(6,2,"poopoo@poopoo.com");

/*
    役職
    positionID 数値 主キー、null禁止
    positionName テキスト null禁止
*/
-- 役職

create table position(
  positionID integer primary key not null,
  positionName text not null
);

insert into position(positionID,positionName) values(1,"一般職")
insert into position(positionID,positionName) values(2,"管理職")

/*
    社員情報
    syainID  テキスト 主キー,null禁止
    syainName  テキスト null禁止
    locacitonID 数値 null禁止 外部locationテーブル参照
    prinariyAdressID 数値 null禁止 外部maillAddressテーブル参照
    subAdressID 数値 nullあり 外部maillAddressテーブル参照
    position 数値 null禁止
*/
-- 社員番号ユーザ
create table syainInfo(
    syainID text primary key not null,
    syainName text not null,
    locationID integer not null,
    primariyAddressID integer not null,
    positionID integer not null,
    foreign key (locationID) references location(locationID),
    foreign key (primariyAddressID) references maillAddres(primariyAddressID),
    foreign key (positionID) references position(positionID)
);
-- "11111","hogehoge",tokyo,hogehoge@...,,"なし"一般
-- "11112","foofoo",osaka,foofoo@..,,管理職
-- osaka,barbar@..1
insert into syainInfo(syainID,syainName,locationID,primariyAddressID,positionID) values("11111","hogehoge",1,1,1);
insert into syainInfo(syainID,syainName,locationID,primariyAddressID,positionID) values("11112","foofoo",2,2,2);
insert into syainInfo(syainID,syainName,locationID,primariyAddressID,positionID) values("11113","barbar",3,1,3);
insert into syainInfo(syainID,syainName,locationID,primariyAddressID,positionID) values("11114","poapoa",1,1,4);


/* -- 作業テーブル
create table register(
    userID, -- 登録ユーザ
    syainID --社員番号
    maillAddressID --メールアドレスID
    statusRegisterID --進行状況
    locationID -- 勤務地あて
    TIMESTAMP
)
*/
