use videodatabase;
SET @video_id = (select count(*)+1 from videodatabase.Video);

insert into videodatabase.Video 
	(Video_Id,
    Video_Name,
    Video_Path,
    Video_extension,
    Insert_Date )
values (
	video_id,
    "test",
    "C:\Users\danie\codebase\danmcCs111\DatabaseAdapterService",
    ".url",
    (select current_timestamp())
);

commit;

select * from videodatabase.Video;


