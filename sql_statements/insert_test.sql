use videodatabase;
SET @video_id = (select count(*)+1 from videodatabase.Video);
commit;

insert into videodatabase.Video 
	(VideoId_Video_VideoDatabase,
    VideoName_Video_VideoDatabase,
    VideoPath_Video_VideoDatabase,
    VideoExtension_Video_VideoDatabase,
    InsertDate_Video_VideoDatabase )
values (
	@video_id,
    "test",
    "C:\Users\danie\codebase\danmcCs111\DatabaseAdapterService",
    ".url",
    (select current_timestamp())
);

select * from videodatabase.Video;

commit;
