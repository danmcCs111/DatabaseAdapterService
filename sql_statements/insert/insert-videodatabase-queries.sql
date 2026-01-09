insert into VideoDatabase.Webservice
(
	WebserviceName_Webservice_VideoDatabase,
	WebserviceQuery_Webservice_VideoDatabase,
	WebserviceType_Webservice_VideoDatabase,
	InsertDate_Webservice_VideoDatabase
)
values 
(
	"SelectAllVideoLinks", 
	"Select * from videoDatabase.Video",
	"1",
	(select current_timestamp())
);
insert into VideoDatabase.Webservice
(
	WebserviceName_Webservice_VideoDatabase,
	WebserviceQuery_Webservice_VideoDatabase,
	WebserviceType_Webservice_VideoDatabase,
	InsertDate_Webservice_VideoDatabase
)
values 
(
	"SelectAllYoutubeChannelVideos", 
	"Select * from videoDatabase.VideoYoutube",
	"1",
	(select current_timestamp())
);
