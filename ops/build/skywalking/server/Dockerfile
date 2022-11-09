FROM apache/skywalking-oap-server:9.0.0

# settings timezone
ENV TZ Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

EXPOSE 12800

HEALTHCHECK --start-period=20s CMD /skywalking/bin/swctl ch

COPY application.yml /skywalking/config/application.yml