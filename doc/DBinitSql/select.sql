-- 社員情報
select "syainID","syainName","locationName",positionName
from "syainInfo"
inner join location
    on syainInfo.locationID = location."locationID"
inner join position
    on "syainInfo"."positionID" = position."positionID";

-- 登録情報
select "registerID","userName","statusName",bikou,"registerTime"
from "register"
inner join "loginUser"
    on "loginUser".id = register."userID"
inner join "statusRegister"
    on register."statusRegisterID" = "statusRegister"."statusRegisterID"
;

-- 登録情報と社員情報とメールアドレスの結合
select address,"syainName","userName","statusName","registerTime",bikou
from "maillAddress"
inner join register
    on "maillAddress"."registerID" = register."registerID"
inner join "syainInfo"
    on  "maillAddress"."syainID" = "syainInfo"."syainID"
inner join "statusRegister"
    on register."statusRegisterID" = "statusRegister"."statusRegisterID"
inner join "loginUser"
    on register."userID" = "loginUser"."id"
;
