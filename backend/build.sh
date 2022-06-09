mkdir target/extracted
java -Djarmode=layertools -jar target/*.jar extract --destination target/extracted
docker build -t big_three/backend .
