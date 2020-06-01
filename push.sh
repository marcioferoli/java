#!/bin/sh

COMMIT_TIMESTAMP=`date +'%d/%m/%Y %H:%M:%S'`

NO_CLR='\033[0m'
CLRB_BLACK='\033[1;30m'
CLRB_GREEN='\033[1;32m'
CLRB_WHITE='\033[1;37m'

echo
echo "${CLRB_BLACK}##################${NO_CLR}"
echo "${CLRB_BLACK}## ${CLRB_WHITE}PRIVATE PUSH${CLRB_BLACK} ##${NO_CLR}"
echo "${CLRB_BLACK}##################${NO_CLR}"

echo
echo "${CLRB_GREEN}➜ git add --all${NO_CLR}"
git add --all

echo
echo "${CLRB_GREEN}➜ git status${NO_CLR}"
git status

echo
echo "${CLRB_GREEN}➜ git commit -m \"Automated commit on ${COMMIT_TIMESTAMP}\"${NO_CLR}"
git commit -m "Automated commit on ${COMMIT_TIMESTAMP}"

echo
echo "${CLRB_GREEN}➜ git push -u origin master${NO_CLR}"
git push -u origin master

#echo
