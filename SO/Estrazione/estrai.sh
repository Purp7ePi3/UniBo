#!/bin/bash
IFS=$',\n'
SOMMA=0
while read FIRST NUM LAST ; do
	((SOMMA = ${SOMMA} + ${NUM}))
	echo "${FIRST},${LAST}"
done < input1.txt
echo ${SOMMA}
exit 0
