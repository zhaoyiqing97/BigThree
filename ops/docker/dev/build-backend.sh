#!/usr/bin/env bash
cd ../../../backend || exit
mvn clean package
mkdir target/extracted
java -Djarmode=layertools -jar target/big-three-1.0-SNAPSHOT.jar extract --destination target/extracted
