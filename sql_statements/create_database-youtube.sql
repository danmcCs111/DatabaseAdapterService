create database videodatabase;
commit;

use videodatabase;

CREATE TABLE videodatabase.videoYoutube (
	Id_VideoYoutube_VideoYoutubeDatabase int NOT NULL AUTO_INCREMENT,
    ParentID_VideoYoutube_VideoYoutubeDatabase int NOT NULL,
    Title_VideoYoutube_VideoYoutubeDatabase VARCHAR(300),
    Url_VideoYoutube_VideoYoutubeDatabase VARCHAR(500),
	PosterImageUrl_VideoYoutube_VideoYoutubeDatabase VARCHAR(500),
    PosterImage_VideoYoutube_VideoYoutubeDatabase BLOB,
	UploadDate_VideoYoutube_VideoYoutubeDatabase timestamp,
    InsertDate_VideoYoutube_VideoYoutubeDatabase timestamp,
    PRIMARY KEY (Id_VideoYoutube_VideoYoutubeDatabase)
);

commit;