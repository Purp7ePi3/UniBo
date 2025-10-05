#!/bin/bash

if (( "$#" == "0" )) ; then
	echo "pochi argomenti"
	exit 1
fi
if (( "$#" > "9" )) ; then
	echo "troppi argomenti"
	exit 1
fi

num=1
pari=0
dispari=0

while (( "${num}" <= "$#" )); do
	rows=`wc -l < ${!num}`
	if(( ${num}%2 == 0 )); then
		(( pari=${pari}+${rows} ))
	else
		(( dispari=$dispari+$rows ))
	fi
	(( num=${num}+1 ))
done

echo $pari
echo $dispari 1>&2

exit 0
