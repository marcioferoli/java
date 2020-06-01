#!/bin/sh

NO_CLR='\033[0m'
CLRB_BLACK='\033[1;30m'
CLRB_GREEN='\033[1;32m'
CLRB_WHITE='\033[1;37m'

echo
echo "${CLRB_BLACK}##################${NO_CLR}"
echo "${CLRB_BLACK}## ${CLRB_WHITE}PRIVATE PULL${CLRB_BLACK} ##${NO_CLR}"
echo "${CLRB_BLACK}##################${NO_CLR}"

echo
echo "${CLRB_GREEN}➜ git pull origin master${NO_CLR}"
git pull origin master

#echo
