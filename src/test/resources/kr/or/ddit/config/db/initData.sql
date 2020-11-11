SELECT * FROM NOT_EXISTS_IN_PRD;

/*delete users;*/
TRUNCATE TABLE users;

Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('cony','코니','conyPass',to_date('2020-10-21','YYYY-MM-DD'),'토끼',null,null,null,'D:\profile\cony.png','D:\profile\cony.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sally','샐리','sallyPass',to_date('2020-10-21','YYYY-MM-DD'),'병아리',null,null,null,'D:\profile\sally.png','D:\profile\sally.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('james','제임스','jamesPass',to_date('2020-10-21','YYYY-MM-DD'),'사람',null,null,null,'D:\profile\james.png','D:\profile\james.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('moon','문','moonPass',to_date('2020-10-21','YYYY-MM-DD'),'달',null,null,null,'D:\profile\moon.png','D:\profile\moon.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('leonard','레너드','leonardPass',to_date('2020-10-15','YYYY-MM-DD'),'개구리',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('edward','에드워드','edwardPass',to_date('2020-10-15','YYYY-MM-DD'),'애벌레',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('jessica','제시카','jessicaPass',to_date('2020-10-15','YYYY-MM-DD'),'고양이',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('boss','보스','bossPass',to_date('2020-11-05','YYYY-MM-DD'),'사람',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('choco','초코','chocoPass',to_date('2020-10-15','YYYY-MM-DD'),'곰2',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pangyo','팡요','pangyoPass',to_date('2020-10-15','YYYY-MM-DD'),'판다',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('muzi','무지','muziPass',to_date('2020-10-15','YYYY-MM-DD'),'토끼',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('con','콘','conPass',to_date('2020-10-15','YYYY-MM-DD'),'악어',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('apeach','어피치','apeachPass',to_date('2020-11-05','YYYY-MM-DD'),'복숭아',null,null,null,'D:\profile\a9bf7510-32e2-4faf-b786-512810f52670.png','cony (1).png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ryan','라이언 ','ryanPass',to_date('2020-10-15','YYYY-MM-DD'),'사자',null,null,null,'D:\profile\ryan.png','D:\profile\ryan.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('qweczczcx','dfafasdfa','casdf',to_date('2020-11-05','YYYY-MM-DD'),'csdf',null,'asfasfdsfdc',null,'D:\profile\a70be9de-7a26-4c79-b9d9-aace89d32702.png','ryan (1) (1).png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('brown','브라운','brownPass',to_date('2020-11-05','YYYY-MM-DD'),'곰',null,null,null,'D:\profile\9be284a7-f070-4761-98d5-697a45289d00.png','brown.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ddit','대덕','dditpass',to_date('2020-11-11','YYYY-MM-DD'),'404',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('park','밥쟁이2','1234',to_date('2020-11-05','YYYY-MM-DD'),'밥2','대전시','우리집','1234','D:\profile\9d525dff-ec54-4737-a81d-24e4f80dff3a.png','ryan.png');

COMMIT;
