use WeatherDatabase;

create database WeatherDatabase;

CREATE TABLE WeatherDatabase.WeatherReading
(
        Date_WeatherReading_WeatherDatabase timestamp PRIMARY KEY,
        Temperature_WeatherReading_WeatherDatabase int,
        Rain_WeatherReading_WeatherDatabase int,
        Thunder_WeatherReading_WeatherDatabase int,
        PrecipitationPotential_WeatherReading_WeatherDatabase int,
        RelativeHumidity_WeatherReading_WeatherDatabase int,
        SkyCover_WeatherReading_WeatherDatabase int,
        HeatIndex_WeatherReading_WeatherDatabase int,
        Dewpoint_WeatherReading_WeatherDatabase int,
        InsertDate_WeatherReading_WeatherDatabase timestamp
);

select * from WeatherDatabase.WeatherReading;

commit;

SHOW TABLES FROM WeatherDatabase;

SHOW COLUMNS FROM WeatherDatabase.WeatherReading;
