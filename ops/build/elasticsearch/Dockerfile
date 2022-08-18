FROM elasticsearch:7.14.0

RUN sed -i -e "s|mirrorlist=|#mirrorlist=|g" /etc/yum.repos.d/CentOS-*
RUN sed -i -e "s|#baseurl=https://mirror.centos.org|baseurl=https://vault.centos.org|g" /etc/yum.repos.d/CentOS-*
RUN yum install -y jq
HEALTHCHECK --start-period=20s CMD curl -s http://localhost:9200/_cluster/health | jq ".status" | grep green || exit 1

# settings  timezone
ENV TZ Asiza/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY conf /usr/share/elasticsearch/config/
COPY plugins  /usr/share/elasticsearch/plugins/