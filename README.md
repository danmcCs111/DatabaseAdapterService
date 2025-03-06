# DatabaseAdapterService

create an executable service where the database uses:

                    "["set|get" "\<columnname\>" "\<tablename\>" "\<database\>" ]" naming convension.


ORM queries named as \<servicename\> 

Webservice contains a codetable for synchronization rules 
Database adapter uses database and table defintions staticly loaded to handle query parsing and to keep rules dependent on defined columns in the database
queries use metadata to determine their meta data from the apps gather table information.
