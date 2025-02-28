create database videodatabase;

commit;

use videodatabase;
/**drop table videodatabase.Video;
commit;
**/
CREATE TABLE videodatabase.Video (
    VideoId_Video_VideoDatabase int PRIMARY KEY,
    VideoName_Video_VideoDatabase VARCHAR(300),
    VideoPath_Video_VideoDatabase VARCHAR(500),
    VideoExtension_Video_VideoDatabase VARCHAR(10),
    InsertDate_Video_VideoDatabase timestamp
);

commit;
