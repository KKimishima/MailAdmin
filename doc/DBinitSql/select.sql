
-- テーブル全体表示
select * from syainInfo ;

-- テーブルのカラム選択
select syainID,syainID from syainInfo;

-- テーブルの内部結合
-- (検索条件に該当するものだけ)
select * from syainInfo
    inner join location
    on syainInfo.locationID = location."locationID";

-- テーブルの外部結合のlett
-- (検索条件に合わなく,nullにして無理やり出す)
-- (leftの場合,fromを変えている方が基準)
select  * from "syainInfo"
    left outer join location
    on  "syainInfo"."locationID" = location."locationID"

-- テーブルの外部結合のright
-- (検索条件合わなくても、nullにして無理やり返す)
-- (rightの場合、joinで選択した方)
select  * from "syainInfo"
    right outer join location
    on  "syainInfo"."locationID" = location."locationID";

-- 複数のテーブルを内部結合
select "syainID","syianName","address","locationName",positionName
from "syainInfo"
inner join location
on syainInfo.locationID = location."locationID"
inner join "maillAddress"
on "syainInfo"."primariAddressID" = "maillAddress"."maillAddressID"
inner join position
on "syainInfo"."positionID" = position."positionID";

-- 一必要な情報取得
select "syainID","syainName","address","locationName",positionName
-- select *
from "syainInfo"
inner join location
    on syainInfo.locationID = location."locationID"
inner join "maillAddress"
    on "syainInfo"."primariyAddressID" = "maillAddress"."primaryAddressID"
inner join position
    on "syainInfo"."positionID" = position."positionID";
