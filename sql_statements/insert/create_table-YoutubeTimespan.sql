use videodatabase;

CREATE TABLE videodatabase.YoutubeTimespan (
    ParentID_YoutubeTimespan_VideoDatabase int NOT NULL,
	TimespanDefaultMillis_YoutubeTimespan_VideoDatabase long default (2629746000 * 6), #month 2629746000
	LookupCountPerDay_YoutubeTimespan_VideoDatabase int default (5), #default 5 per day
    InsertDate_YoutubeTimespan_VideoDatabase timestamp,
    PRIMARY KEY (ParentID_YoutubeTimespan_VideoDatabase)
);

commit;