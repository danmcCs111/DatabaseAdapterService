#!/bin/bash
cd "$(dirname "$0")"
./printDirectory.bat
db_file=`cat dirArg.txt | sed 's/ $//g'`"\\"
source ./echoArgs.sh
source ./java-class-path.sh

echo $db_file
#mysql
#java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrl $user $pass $port

databases=(`ls ../SQLiteInstall/*.db`)
dbs=""
for d in ${databases[@]}
do
	dbs+=":"`echo $d | sed 's/..\/SQLiteInstall\///g'`
done
dbs=${dbs:1}

echo $dbs

java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrlPre$db_file $port $arg2

