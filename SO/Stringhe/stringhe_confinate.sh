#!/bin/bash

while read line ; do
	last=${line#\"*\"*\"*\"*\"}	#Cancella dall'inzio
	res=${last%\"*\"*\"*}			#Cancella dalla fine
	num=`grep "$res" stringhe.txt | wc -l`
	echo $res $num
done < stringhe.txt | sort | uniq 


