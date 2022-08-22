#!/usr/bin/env bash
cd ../../../backend || exit
mvn clean package -DskipTests
mkdir target/extracted
java -Djarmode=layertools -jar target/*.jar extract --destination target/extracted
read -s -r -n1 -p " build success 按任意键推出... "
