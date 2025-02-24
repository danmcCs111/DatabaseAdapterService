drop database videodatabase;

commit;

create database videodatabase;

commit;

use videodatabase;
/**drop table videodatabase.Video;
commit;
**/
CREATE TABLE videodatabase.Video (
    Video_Id int PRIMARY KEY,
    Video_Name VARCHAR(300),
    Video_Path VARCHAR(500),
    Video_extension VARCHAR(10),
    Insert_Date timestamp
);

commit;

select * from videodatabase.Video;

