create table moto(
    motoID integer primary key not null,
    sansyouID integer,
    motoName text not null,
    foreign key (sansyouID) references sansyou(sansyouID)
);

create table sansyou(
    sansyouID integer not null,
    sansyouID2 integer,
    sansyouName text not null,
    primary key (sansyouID,sansyouID2)
);

insert into moto("motoID","sansyouID",motoName) values(1,1,"元1さん");
insert into moto("motoID","sansyouID",motoName) values(2,2,"元2さん");
insert into moto("motoID","sansyouID",motoName) values(3,3,"元3さん");

insert into sansyou("sansyouID","sansyouID2","sansyouName") values(1,1,"hoge@hoge.com");
insert into sansyou("sansyouID","sansyouID2","sansyouName") values(1,2,"hoge2@hoge.com");
insert into sansyou("sansyouID","sansyouID2","sansyouName") values(2,1,"foo@foo.com");
insert into sansyou("sansyouID","sansyouID2","sansyouName") values(2,2,"foo2@foo.com");
insert into sansyou("sansyouID","sansyouID2","sansyouName") values(3,1,"bar@bar.com");


select motoName,"sansyouName" from moto
inner join sansyou
    on moto."sansyouID" = sansyou."sansyouID";

delete from moto
where
    motoName = "元さん";

drop table moto;
drop table sansyou;