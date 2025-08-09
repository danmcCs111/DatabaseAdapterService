use WeatherDatabase;

create database WeatherDatabase;

CREATE TABLE WeatherDatabase.WeatherReading
(
        WeatherDate_WeatherReading_WeatherDatabase timestamp PRIMARY KEY,
        WeatherTemperature_WeatherReading_WeatherDatabase int,
        WeatherRain_WeatherReading_WeatherDatabase int,
        WeatherThunder_WeatherReading_WeatherDatabase int,
        WeatherPrecipitationPotential_WeatherReading_WeatherDatabase int,
        WeatherRelativeHumidity_WeatherReading_WeatherDatabase int,
        WeatherSkyCover_WeatherReading_WeatherDatabase int,
        WeatherHeatIndex_WeatherReading_WeatherDatabase int,
        WeatherDewpoint_WeatherReading_WeatherDatabase int,
        InsertDate_WeatherReading_WeatherDatabase timestamp
);

select * from WeatherDatabase.WeatherReading;

commit;


SHOW TABLES FROM WeatherDatabase;

SHOW COLUMNS FROM WeatherDatabase.WeatherReading;
