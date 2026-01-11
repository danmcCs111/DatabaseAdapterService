#!/bin/bash
cd "$(dirname "$0")"
source ./echoArgs.sh
source ./java-class-path.sh
java -cp "$java_database_cp" DriverAdapter.DriverAdapter $dbUrl $user $pass $port

