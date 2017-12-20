-- ユーザ系
-- 社員情報まとめ
select *
from "syainInfo";
-- 勤務地
select *
from location;
-- 役職
select *
from position;

-- 登録情報系
-- 登録情報まとめ
select *
from register;
-- 登録ステータス
select *
from statusRegister;
-- ログインユーザ
select *
from loginUser;

-- メインテーブル
-- メールアドレス
select *
from "maillAddress";

-- 社員情報と密接なテーブ情報
select "syainID","syainName","locationName",positionName
from "syainInfo"
inner join location
    on syainInfo.locationID = location."locationID"
inner join position
    on "syainInfo"."positionID" = position."positionID";

-- 登録情報と密接な情報
select "registerID","userName",passWord,"statusName",bikou,"registerTime"
from "register"
inner join "loginUser"
    on "loginUser".id = register."userID"
inner join "statusRegister"
    on register."statusRegisterID" = "statusRegister"."statusRegisterID"
;

-- メールアドレスのみの情報
select "address"
from "maillAddress";

-- syainInfoを中心に統合情報
select
    -- syainInfoテーブル
    syainID,
    syainName,
    -- locationテーブル
    "locationName",
    -- positionテーブル
    positionName,
    -- maillAdressテーブル
    address,
    -- register"テーブル
    registerTime,
    bikou,
    -- statusRegisterテーブル
    "statusName",
    -- loginUserテーブル
    userName,
    passWord,
    loginUser.userID
    --userID
--select *
from "syainInfo"
-- 緊密テーブル
inner join  location
    on location."locationID" = "syainInfo".locationID
inner join position
    on "syainInfo"."positionID" = position."positionID"
-- 中密テーブル
inner join "maillAddress"
    on "syainInfo".primaryAddressID ="maillAddress"."primaryAddressID"
-- 疎密テーブル
inner join register
    on  register.registerID = "maillAddress"."registerID"
-- 最遠部テーブル
inner join "loginUser"
    on "loginUser"."id" = register.userID
inner join "statusRegister"
    on register."statusRegisterID" = "statusRegister"."statusRegisterID"
;