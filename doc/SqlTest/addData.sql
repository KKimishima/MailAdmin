-- 新規で追加
/*
    メインアドレス追加
    サブアドレスなし
    ユーザの追加
        メールアドレスの追加
            primaryAddressID    = 5
            secondaryAddressID  = 1(複数件を持たいない)
            address             = "tekoteo@tekoteko.com"
            registerID          = 6(必須_登録データに追加)
        登録データの追加
            registerID          = 6(必須_メールアドレスと結合)
            userID              = 1(loginuserのadmin)
            statusRegisterID    = 1(statusRegisterの"未登録")
            bikou               = "サブアドレスなし1"
            registerTime        = タイムスタンプ
        社員番号ユーザの追加
            syainID             = "11115"(新規番号)
            syainName           = "tekoteko"(新規名前)
            locationID          = 3(茨木)
            positionID          = 1(一般職)
            primaryAddressID)   = 5(必須_メールアドレスに追加)
*/

insert into maillAddress(primaryAddressID,secondaryAddressID,address,registerID) values(5,1,"tekoteko@tekoteko.com",6);
insert into register(registerID,userID,statusRegisterID,bikou,registerTime) values(6,1,1,"サブアドレスなし1",datetime('now', 'localtime'));
insert into syainInfo(syainID,syainName,locationID,positionID,primaryAddressID) values("11115","tekoteko",3,1,5);
/*
    メインアドレス追加
    サブアドレスあり
    ユーザの追加
        メールアドレスの追加
            メインアドレス
            primaryAddressID    = 6
            secondaryAddressID  = 1
            address             = "pokokoko@pokokoko.com"
            registerID          = 7(必須_登録データに追加)
            サブアドレス
            primaryAddressID    = 6
            secondaryAddressID  = 2(サブアドレスあり)
            address             = "pokokoko2@pokokoko.com"
            registerID          = 8(必須_登録データに追加)
        登録データの追加
            メインアドレス
            registerID          = 7(必須_メールアドレスと結合)
            userID              = 3(loginuserのadmin)
            statusRegisterID    = 1(statusRegisterの"未登録")
            bikou               = "サブアドレスあり1"
            registerTime        = タイムスタンプ
            サブアドレス
            registerID          = 8(必須_メールアドレスと結合)
            userID              = 3(loginuserのadmin)
            statusRegisterID    = 1(statusRegisterの"未登録")
            bikou               = "サブアドレスあり2"
            registerTime        = タイムスタンプ
        社員番号ユーザの追加
            syainID             = "11116"(新規番号)
            syainName           = "pokokoko"(新規名前)
            locationID          = 3(茨木)
            positionID          = 1(一般職)
            primaryAddressID)   = 6(必須_メールアドレスに追加)
*/
insert into maillAddress(primaryAddressID,secondaryAddressID,address,registerID) values(6,1,"pokokoko@pokokoko.com",7);
insert into maillAddress(primaryAddressID,secondaryAddressID,address,registerID) values(6,2,"pokokoko2@pokokoko.com",8);
insert into register(registerID,userID,statusRegisterID,bikou,registerTime) values(7,3,1,"サブアドレスなし1",datetime('now', 'localtime'));
insert into register(registerID,userID,statusRegisterID,bikou,registerTime) values(8,3,1,"サブアドレスなし2",datetime('now', 'localtime'));
insert into syainInfo(syainID,syainName,locationID,positionID,primaryAddressID) values("11116","pokokoko",3,1,6);
