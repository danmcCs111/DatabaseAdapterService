CREATE TABLE VideoYoutube (
	Id_VideoYoutube_VideoYoutubeDatabase VARCHAR(15),
    ParentID_VideoYoutube_VideoYoutubeDatabase INTEGER NOT NULL,
    Title_VideoYoutube_VideoYoutubeDatabase VARCHAR(300),
    Url_VideoYoutube_VideoYoutubeDatabase VARCHAR(500),
	PosterImageUrl_VideoYoutube_VideoYoutubeDatabase VARCHAR(500),
	UploadDate_VideoYoutube_VideoYoutubeDatabase timestamp,
    InsertDate_VideoYoutube_VideoYoutubeDatabase timestamp,
    PRIMARY KEY (Id_VideoYoutube_VideoYoutubeDatabase)
);
