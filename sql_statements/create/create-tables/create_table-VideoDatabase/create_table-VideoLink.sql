use videodatabase;

CREATE TABLE videodatabase.Video (
    VideoId_Video_VideoDatabase int NOT NULL AUTO_INCREMENT,
    VideoName_Video_VideoDatabase VARCHAR(300),
    VideoUrl_Video_VideoDatabase VARCHAR(500),
    InsertDate_Video_VideoDatabase timestamp,
	PRIMARY KEY (VideoId_Video_VideoDatabase)
);

commit;
