CREATE TABLE VideoDatabase.Webservice 
(
	WebserviceId_Webservice_VideoDatabase int NOT NULL AUTO_INCREMENT,
	WebserviceName_Webservice_VideoDatabase VARCHAR(300),
	WebserviceQuery_Webservice_VideoDatabase VARCHAR(5000),
	WebserviceType_Webservice_VideoDatabase int,
	InsertDate_Webservice_VideoDatabase timestamp,
	PRIMARY KEY (WebserviceId_Webservice_VideoDatabase)
);
