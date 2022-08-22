#!/usr/bin/env bash

list="elasticsearch.yml maven.yml mysql.yml node.js.yml"
for i in $list; do
  echo "$i" is start
  curl \
    -X POST \
    -H "Accept: application/vnd.github+json" \
    -H "Authorization: token $GITHUB_TOKEN" \
    https://api.github.com/repos/zhaoyiqing97/BigThree/actions/workflows/"$i"/dispatches \
    -d '{"ref":"main","inputs":{"version":"2.0.0"}}'
  echo "$i" is success
done

read -s -r -n1 -p " build success 按任意键推出... "
