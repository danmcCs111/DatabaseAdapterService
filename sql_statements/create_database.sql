drop database videodatabase;

commit;

create database videodatabase;

commit;

use videodatabase;
/**drop table videodatabase.Video;
commit;
**/
CREATE TABLE videodatabase.Video (
    Video_Id-Video-Video_Database int PRIMARY KEY,
    Video_Name-Video-Video_Database VARCHAR(300),
    Video_Path-Video-Video_Database VARCHAR(500),
    Video_extension-Video-Video_Database VARCHAR(10),
    Insert_Date-Video-Video_Database timestamp
);

commit;

select * from videodatabase.Video;

