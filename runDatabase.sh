#!/bin/bash

cd "$(dirname "$0")"
./runDatabase\ -\ debug.sh > /dev/null 2>&1
 
cd -

