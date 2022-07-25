Set-Location -Path ../../../frontend
Remove-Item ./dist -Force -Recurse
npm run build:prod
