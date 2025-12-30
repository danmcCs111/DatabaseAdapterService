use videodatabase;
SET @video_id = (select count(*)+1 from videodatabase.Video);
commit;

insert into videodatabase.Video 
	(
    VideoName_Video_VideoDatabase,
    VideoUrl_Video_VideoDatabase,
    InsertDate_Video_VideoDatabase )
values (
    "test abc",
    "https://www.youtube.com/@ABCNews",
    (select current_timestamp())
);

select * from videodatabase.Video;

commit;


SHOW TABLES FROM videodatabase;

SHOW COLUMNS FROM videodatabase.Video;

CREATE TABLE videodatabase.Webservice (
    WebserviceId_Webservice_VideoDatabase int PRIMARY KEY,
    WebserviceName_Webservice_VideoDatabase VARCHAR(300),
    WebserviceQuery_Webservice_VideoDatabase VARCHAR(5000),
    WebserviceType_Webservice_VideoDatabase int,
    InsertDate_Webservice_VideoDatabase timestamp
);

insert into videodatabase.Webservice
	(
    WebserviceId_Webservice_VideoDatabase,
    WebserviceName_Webservice_VideoDatabase,
    WebserviceQuery_Webservice_VideoDatabase,
    WebserviceType_Webservice_VideoDatabase,
    InsertDate_Webservice_VideoDatabase
    )
values (
	1,
    "SelectAllVideos",
    "Select * from videoDatabase.Video",
    1,
    (select current_timestamp())
);

CREATE TABLE videodatabase.WebserviceType (
    WebserviceTypeId_Webservice_VideoDatabase int PRIMARY KEY,
    WebserviceTypeName_Webservice_VideoDatabase VARCHAR(300),
    InsertDate_Webservice_VideoDatabase timestamp
);

insert into videodatabase.WebserviceType
	(
	WebserviceTypeId_Webservice_VideoDatabase,
    WebserviceTypeName_Webservice_VideoDatabase,
    InsertDate_Webservice_VideoDatabase
    )
values (
	1,
    "User Query",
    (select current_timestamp())
);
