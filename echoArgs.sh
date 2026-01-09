#!/bin/bash
dbUrl=`egrep -o DB_URL.* config/db-config.txt | sed 's/DB_URL=//g'`
user=`egrep -o USER.* config/db-config.txt | sed 's/USER=//g'`
pass=`egrep -o PASS.* config/db-config.txt | sed 's/PASS=//g'`
port=`egrep -o PORT_NUMBER.* config/db-config.txt | sed 's/PORT_NUMBER=//g'`
