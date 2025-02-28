use videodatabase;
SET @video_id = (select count(*)+1 from videodatabase.Video);
commit;

insert into videodatabase.Video 
	(Video_Id_Video_Video_Database,
    Video_Name_Video_Video_Database,
    Video_Path_Video_Video_Database,
    Video_extension_Video_Video_Database,
    Insert_Date_Video_Video_Database )
values (
	@video_id,
    "test",
    "C:\Users\danie\codebase\danmcCs111\DatabaseAdapterService",
    ".url",
    (select current_timestamp())
);

select * from videodatabase.Video;

commit;