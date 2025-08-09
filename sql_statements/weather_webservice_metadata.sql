CREATE TABLE WeatherDatabase.Webservice 
(
	WebserviceId_Webservice_WeatherDatabase int PRIMARY KEY,
	WebserviceName_Webservice_WeatherDatabase VARCHAR(300),
	WebserviceQuery_Webservice_WeatherDatabase VARCHAR(5000),
	WebserviceType_Webservice_WeatherDatabase int,
	InsertDate_Webservice_WeatherDatabase timestamp
);

insert into WeatherDatabase.Webservice
(
	WebserviceId_Webservice_WeatherDatabase,
	WebserviceName_Webservice_WeatherDatabase,
	WebserviceQuery_Webservice_WeatherDatabase,
	WebserviceType_Webservice_WeatherDatabase,
	InsertDate_Webservice_WeatherDatabase
)
values 
(
	1,
	"SelectAllWeatherReadings",
	"Select * from WeatherDatabase.WeatherReading",
	1,
	(select current_timestamp())
);

CREATE TABLE WeatherDatabase.WebserviceType 
(
	WebserviceTypeId_Webservice_WeatherDatabase int PRIMARY KEY,
	WebserviceTypeName_Webservice_WeatherDatabase VARCHAR(300),
	InsertDate_Webservice_WeatherDatabase timestamp
);

insert into WeatherDatabase.WebserviceType
(
	WebserviceTypeId_Webservice_WeatherDatabase,
	WebserviceTypeName_Webservice_WeatherDatabase,
	InsertDate_Webservice_WeatherDatabase
)
values 
(
	1,
	"User Query",
	(select current_timestamp())
);

