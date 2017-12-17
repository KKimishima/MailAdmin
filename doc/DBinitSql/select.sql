-- メールアドレスと社員情報
select "syainID","syainName","address","locationName",positionName
from "syainInfo"
inner join location
    on syainInfo.locationID = location."locationID"
inner join "maillAddress"
    on "syainInfo"."primariyAddressID" = "maillAddress"."primaryAddressID"
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

select *
from "maillAddress"
inner join register
    on "maillAddress"."registerID" = register."registerID"
--inner join "loginUser"
--    on "loginUser"."userID" = register."userID"
;
