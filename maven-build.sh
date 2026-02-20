#!/bin/bash
orgDir=`pwd`
mvnDir=$1

cd "$(dirname "$0")"

$mvnDir clean install dependency:copy-dependencies

cd $orgDir
