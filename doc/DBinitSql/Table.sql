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

-- テストユーザ作成
insert into loginUser(userID,userName,pass) values("0000","admin","hogehoge");
insert into loginUser(userID,userName,pass) values("0001","user1","foofoo");
insert into loginUser(userID,userName,pass) values("0000","user2","barbar");
