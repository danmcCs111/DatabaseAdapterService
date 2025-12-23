create database gamedatabase;
commit;

use gamedatabase;

CREATE TABLE gamedatabase.Game (
    GameId_Game_GameDatabase int NOT NULL AUTO_INCREMENT,
    GameTitle_Game_GameDatabase VARCHAR(300),
    GameUrl_Game_GameDatabase VARCHAR(500),
    GameBaseValue_Game_GameDatabase int,
    GameFinalValue_Game_GameDatabase int,
    GamePosterImage_Game_GameDatabase BLOB,
    InsertDate_Game_GameDatabase timestamp,
    PRIMARY KEY (GameId_Game_GameDatabase)
);

commit;