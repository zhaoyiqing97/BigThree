#!/usr/bin/env bash
cd ../../../frontend || exit
rm -rf ./dist
npm run build:prod
read -s -r -n1 -p " build success 按任意键推出... "