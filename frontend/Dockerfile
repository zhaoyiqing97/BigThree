FROM nginx:1.20-alpine

# settings timezone
ENV TZ Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY nginx /etc/nginx


WORKDIR app
COPY dist ./
