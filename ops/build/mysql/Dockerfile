FROM mysql:8.0.28

# settings timezone
ENV TZ Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# copy init sql
COPY sql/init-database.sql /docker-entrypoint-initdb.d/1.sql
COPY sql/init-table.sql /docker-entrypoint-initdb.d/2.sql
COPY sql/init-table-data.sql /docker-entrypoint-initdb.d/3.sql