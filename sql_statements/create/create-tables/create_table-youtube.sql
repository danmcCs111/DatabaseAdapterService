
use videodatabase;

CREATE TABLE videodatabase.videoYoutube (
	Id_VideoYoutube_VideoYoutubeDatabase VARCHAR(15),
    ParentID_VideoYoutube_VideoYoutubeDatabase int NOT NULL,
    Title_VideoYoutube_VideoYoutubeDatabase VARCHAR(300),
    Url_VideoYoutube_VideoYoutubeDatabase VARCHAR(500),
	PosterImageUrl_VideoYoutube_VideoYoutubeDatabase VARCHAR(500),
	UploadDate_VideoYoutube_VideoYoutubeDatabase timestamp,
    InsertDate_VideoYoutube_VideoYoutubeDatabase timestamp,
    PRIMARY KEY (Id_VideoYoutube_VideoYoutubeDatabase)
);

commit;