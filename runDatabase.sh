#!/bin/bash
cd "$(dirname "$0")"
./printDirectory.bat
db_file=`cat dirArg.txt | sed 's/ $//g'`"\\"
source ./echoArgs.sh
source ./java-class-path.sh

echo $db_file
#mysql
#java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrl $user $pass $port

java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrlPre$db_file$dbUrlPost $port

