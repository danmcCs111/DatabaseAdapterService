#!/bin/bash
cd "$(dirname "$0")"
db_file="$1"
source ./echoArgs.sh
source ./java-class-path.sh

#mysql
#java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrl $user $pass $port

java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrlPre$db_file$dbUrlPost $port

