#!/bin/bash
source ./echoArgs.sh
java -jar DatabaseAdapterService.jar $dbUrl $user $pass $port
