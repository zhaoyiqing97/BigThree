FROM elasticsearch:7.14.0

# todo jq
HEALTHCHECK --start-period=20s CMD curl -s http://localhost:9200/_cluster/health | grep green || exit 1

# settings  timezone
ENV TZ Asiza/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY conf /usr/share/elasticsearch/config/
COPY plugins  /usr/share/elasticsearch/plugins/