#!/bin/bash
cd "$(dirname "$0")"
source ./echoArgs.sh
source ./java-class-path.sh

#mysql
#java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrl $user $pass $port

databases=(`ls ../SQLiteInstall/*.db`)
dbs=""
for d in ${databases[@]}
do
	dbs+=","`echo $d`
done
dbs=${dbs:1}

echo $dbs

java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrlPre $port $dbs

