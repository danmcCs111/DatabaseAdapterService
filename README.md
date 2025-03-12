# DatabaseAdapterService

* Add Soap Service to take requests on database.

create an executable service where the database uses:

                    "["set|get" "\<columnname\>" "\<tablename\>" "\<database\>" ]" naming convension.


ORM queries named as \<servicename\> 

Webservice contains a codetable for synchronization rules 
Database adapter uses database and table defintions staticly loaded to handle query parsing and to keep rules dependent on defined columns in the database
queries use metadata to determine their meta data from the apps gather table information.


![image](https://github.com/user-attachments/assets/c759a4b2-8b21-40a7-8d23-ffa5389a6183)


![test_server_request_response](https://github.com/user-attachments/assets/0b08eff9-f52c-478c-8664-2fb529ea16ac)
