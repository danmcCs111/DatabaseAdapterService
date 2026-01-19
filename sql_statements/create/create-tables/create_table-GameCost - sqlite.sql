use gamedatabase;

CREATE TABLE gamedatabase.GameCost (
	CostEntryId_GameCost_GameDatabase INTEGER NOT NULL,
    GameTitle_GameCost_GameDatabase VARCHAR(300),
    GameBaseValue_GameCost_GameDatabase float,
    GameFinalValue_GameCost_GameDatabase float,
    InsertDate_GameCost_GameDatabase timestamp,
    PRIMARY KEY (CostEntryId_GameCost_GameDatabase)
);

commit;