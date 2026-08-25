#!/bin/bash
typeOs=`uname`

cd "$(dirname "$0")"
source ./echoArgs.sh

if [[ "$typeOs" == "Linux" ]]
then
	
	source ./java-class-path-linux.sh
else
	source ./java-class-path.sh
fi

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
echo "$java_database_cp"

java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrlPre $port $dbs

