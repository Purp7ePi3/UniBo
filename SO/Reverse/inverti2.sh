#!/bin/bash
time(
if (( $# != 1 )) ; then echo "serve un argomento"; exit 0; fi
if [[ ! -e $1 ]] ; then echo "il file $1 non esiste"; fi

NUMRIGHE=`wc -l $1`
echo $NUMRIGHE
read NUMRIGHE NOMEFILE <<< ${NUMRIGHE}
for (( indice=1; $indice<=${NUMRIGHE}; indice=$indice+1 )) ; do
	: #tail -n $indice $1 | head -n 1
done > /dev/null


)