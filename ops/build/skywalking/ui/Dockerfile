FROM apache/skywalking-ui:9.0.0
# settings timezone
ENV TZ Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

HEALTHCHECK CMD curl -fs http://localhost:8080 || exit 1

