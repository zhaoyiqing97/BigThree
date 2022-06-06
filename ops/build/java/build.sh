cp ../../dev/target ./target
mkdir target/extracted
java -Djarmode=layertools -jar target/*.jar extract --destination target/extracted