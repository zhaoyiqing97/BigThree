FROM openjdk:8-jre-alpine

RUN apk --update --no-cache add curl jq
HEALTHCHECK --start-period=20s CMD curl -s http://localhost:8080/backend/actuator/health | jq ".status" | grep UP || exit 1

# settings timezone
ENV TZ Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN addgroup -S spring && adduser -S spring -G spring
RUN mkdir /logs && chown spring:spring /logs
RUN mkdir /app && chown spring:spring /app
USER spring:spring

WORKDIR /app
COPY ./target/extracted/dependencies/ ./
COPY ./target/extracted/spring-boot-loader/ ./
COPY ./target/extracted/snapshot-dependencies/ ./
COPY ./target/extracted/application/ ./

ENV JAVA_OPTS="-Xmx128m -Xms128m -XX:+UseG1GC"

# JarLauncher是从 JAR 中提取到镜像中的，因此它可以用于启动应用程序，而无需对主应用程序类进行硬编码。
ENTRYPOINT ["sh", "-c","java ${JAVA_OPTS} org.springframework.boot.loader.JarLauncher"]
