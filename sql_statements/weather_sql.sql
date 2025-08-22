use WeatherDatabase;

create database WeatherDatabase;

CREATE TABLE WeatherDatabase.WeatherReading
(
        Date_WeatherReading_WeatherDatabase timestamp,
        Location_WeatherReading_WeatherDatabase varchar(12),
        Temperature_WeatherReading_WeatherDatabase int,
        Rain_WeatherReading_WeatherDatabase int,
        Thunder_WeatherReading_WeatherDatabase int,
        PrecipitationPotential_WeatherReading_WeatherDatabase int,
        RelativeHumidity_WeatherReading_WeatherDatabase int,
        SkyCover_WeatherReading_WeatherDatabase int,
        HeatIndex_WeatherReading_WeatherDatabase int,
        Dewpoint_WeatherReading_WeatherDatabase int,
        SurfaceWind_WeatherReading_WeatherDatabase varchar(255),
        InsertDate_WeatherReading_WeatherDatabase timestamp,
        PRIMARY KEY (Location_WeatherReading_WeatherDatabase, Date_WeatherReading_WeatherDatabase)
);

select * from WeatherDatabase.WeatherReading;

commit;

SHOW TABLES FROM WeatherDatabase;

SHOW COLUMNS FROM WeatherDatabase.WeatherReading;

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

