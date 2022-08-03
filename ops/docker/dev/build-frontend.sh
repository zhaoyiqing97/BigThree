#!/usr/bin/env bash
cd ../../../frontend || exit
rm -rf ./dist
npm run build:prod
