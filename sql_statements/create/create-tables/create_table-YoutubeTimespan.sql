use videodatabase;

CREATE TABLE videodatabase.YoutubeTimespan (
    ParentID_VideoYoutube_YoutubeTimespan int NOT NULL,
	TimespanDefaultMillis_VideoYoutube_YoutubeTimespan long default (2629746000 * 6), #month 2629746000
	LookupCountPerDay_VideoYoutube_YoutubeTimespan int default (5), #default 5 per day
    InsertDate_VideoYoutube_YoutubeTimespan timestamp,
    PRIMARY KEY (ParentID_VideoYoutube_YoutubeTimespan)
);

commit;