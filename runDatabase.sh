#!/bin/bash
cd "$(dirname "$0")"
source ./echoArgs.sh
java -jar DatabaseAdapterService.jar $dbUrl $user $pass $port
