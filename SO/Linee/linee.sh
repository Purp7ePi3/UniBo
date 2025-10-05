#!/bin/bash

for name in /usr/include/* /etc/* ; do
	if [[ -f ${name} && -r ${name} ]] ; then 
		cat ${name}
	fi
done | wc -l 

