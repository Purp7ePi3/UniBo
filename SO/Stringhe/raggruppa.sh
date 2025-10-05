#!/bin/bash

while read anno luogo motivo danno; do
	NUM=`grep $motivo cadutevic.txt | wc -l`
	echo "${motivo} ${NUM}"
done < cadutevic.txt | sort -k2 -n -r | uniq
exit 0
