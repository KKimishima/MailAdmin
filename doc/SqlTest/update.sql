-- 登録情報の変更
-- 変更方針

/*

    社員情報変更系
        勤務地と役職を変更
            syainID             = "11111"       変更禁止
            syainName           =  "hogehoge"   変更禁止
            locationID          = 3(茨木)       変更OK
            positionID          = 2(一般職)     変更OK
            primaryAddressID   = 5(必須_メールアドレスに追加) 基本,変更禁止
                メールアドレスの追加
*/

-- 変更可能な勤務地と役職の変更
update syainInfo
set locationID = 3,
    positionID = 2,
    "primaryAddressID" = 1
where syainID="11111"
/*
    登録情報系
        追加,変更時は常にレコードを追加
        登録データの追加
            registerID          = 自動採番
            userID              = 2(loginuserのadmin)
            statusRegisterID    = 2(statusRegisterの"未登録")
            bikou               = "変更"
            registerTime        = タイムスタンプ
*/

insert into register(userID,statusRegisterID,bikou,registerTime) values(2,2,"変更テスト",datetime('now', 'localtime'));
/*

    メールアドレス系
        メインメールアドレスとサブアドレスの変更
            primaryAddressID    = 5                     変更禁止
            secondaryAddressID  = 1(複数件を持たいない)  変更禁止
            address             = "tekoteo@tekoteko.com" 変更OK
            registerID          = 6(必須_登録データに追加) 常に新しい番号を取得
*/
update "maillAddress"
set address = "henkou2@henkou.com",
 "registerID" =
(select MAX("registerID") from register)
where primaryAddressID =5 and secondaryAddressID =1


