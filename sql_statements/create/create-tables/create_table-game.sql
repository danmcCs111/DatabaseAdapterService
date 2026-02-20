use gamedatabase;

CREATE TABLE gamedatabase.Game (
    GameTitle_Game_GameDatabase VARCHAR(300),
    GameUrl_Game_GameDatabase VARCHAR(500),
    GameBaseValue_Game_GameDatabase float,
    GameFinalValue_Game_GameDatabase float,
    InsertDate_Game_GameDatabase timestamp,
    PRIMARY KEY (GameTitle_Game_GameDatabase)
);

commit;