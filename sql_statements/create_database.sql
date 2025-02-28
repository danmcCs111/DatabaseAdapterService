create database videodatabase;

commit;

use videodatabase;
/**drop table videodatabase.Video;
commit;
**/
CREATE TABLE videodatabase.Video (
    Video_Id_Video_Video_Database int PRIMARY KEY,
    Video_Name_Video_Video_Database VARCHAR(300),
    Video_Path_Video_Video_Database VARCHAR(500),
    Video_extension_Video_Video_Database VARCHAR(10),
    Insert_Date_Video_Video_Database timestamp
);

commit;
