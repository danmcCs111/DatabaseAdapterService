use videodatabase;
SET @video_id = (select count(*)+1 from videodatabase.Video);

insert into videodatabase.Video 
	(Video_Id-Video-Video_Database,
    Video_Name-Video-Video_Database,
    Video_Path-Video-Video_Database,
    Video_extension-Video-Video_Database,
    Insert_Date-Video-Video_Database )
values (
	video_id,
    "test",
    "C:\Users\danie\codebase\danmcCs111\DatabaseAdapterService",
    ".url",
    (select current_timestamp())
);

commit;

select * from videodatabase.Video;


