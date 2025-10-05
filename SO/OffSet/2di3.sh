#!/bin/bash

while read UNO DUE TRE; do
	if [[ $TRE != "" ]] ; then
		ris=${TRE:1:1}
		if [[ $ris != "" ]]; then
			echo $ris
		fi
	fi
done < /usr/include/stdio.h
