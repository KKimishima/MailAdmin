-- テーブルの作成
/*
    ログイン用テーブル作成
    id      数値 主キー,連番,null禁止
    userID  テキスト
    pass    テキスト
*/
create table loginUser(id integer primary key AUTOINCREMENT NOT NULL, userID text, userName text, pass text);
-- テーブル構図確認
-- .mode lineに切り替えておく
select * from sqlite_master;
-- テーブル削除
drop table テーブル名

-- ログインユーザ作成
insert into loginUser(userID,userName,pass) values("0000","admin","hogehoge");
insert into loginUser(userID,userName,pass) values("0001","user1","foofoo");
insert into loginUser(userID,userName,pass) values("0000","user2","barbar");

-- 勤務地テーブル
create table location(
    locationID integer primary key not null,
    locationName text not null
);

insert into location(locationID,locationName) values(1,"tokyo");
insert into location(locationID,locationName) values(2,"osak");
insert into location(locationID,locationName) values(3,"ibaraki");
insert into location(locationID,locationName) values(4,"saitama");
insert into location(locationID,locationName) values(5,"shizuoka");

-- 登録進行状況
create table statusRegister(
    statusRegisterID integer primary key not null,
    statusName text not null
);
insert into statusRegister(statusRegisterID,statusName) values(1,"未登録");
insert into statusRegister(statusRegisterID,statusName) values(2,"テスト送信済み");
insert into statusRegister(statusRegisterID,statusName) values(3,"返信待ち");
insert into statusRegister(statusRegisterID,statusName) values(4,"返信受信");
insert into statusRegister(statusRegisterID,statusName) values(5,"登録完了");

-- maillAddress
create table maillAddres(
    maillAddressID integer primary key not null,
    address text not null
);
insert into maillAddres(maillAddressID,address) values(1,"hogehoge@hogehoge.com");
insert into maillAddres(maillAddressID,address) values(2,"foofoo@foofoo.com");
insert into maillAddres(maillAddressID,address) values(3,"barbar@barbar.com");
insert into maillAddres(maillAddressID,address) values(4,"poapoa@poopoo.com");
insert into maillAddres(maillAddressID,address) values(5,"bakabaka@bakabaka.com");
insert into maillAddres(maillAddressID,address) values(6,"poopoo@poopoo.com");

-- 社員番号ユーザ
create table syainInfo(
    syainID text primary key not null,
    syinaName tex not null
);

insert into syainInfo(syainID,syinaName) values("11111","hogehoge");
insert into syainInfo(syainID,syinaName) values("11112","foofoo");
insert into syainInfo(syainID,syinaName) values("11113","barbar");
insert into syainInfo(syainID,syinaName) values("11114","poapoa");
insert into syainInfo(syainID,syinaName) values("11115","bakabaka");


-- 作業テーブル
create table register(
    userID, -- 登録ユーザ
    syainID --社員番号
    maillAddressID --メールアドレスID
    statusRegisterID --進行状況
    locationID -- 勤務地あて
    TIMESTAMP

)
