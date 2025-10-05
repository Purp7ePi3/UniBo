#!/bin/bash

NA=0;NB=0;

if (( $# != 1 )) ; then echo "Inserisci una stringa di A e B in input"; exit 1; fi

word=$1
wordlen=${#word}
nread=0
midlen=$((wordlen/2))

while (( $nread < $wordlen )) ; do
	car=${word:nread:1}
	(( nread++ ))
	if [[ $car == "A" ]] ; then (( NA++)) ; exit 1 fi
done


if (( NA > midlen || NA < midlen )) ; then echo "Errore"; exit 1; fi

nread=0
while (( $nread < $wordlen )) ; do
        car=${word:nread:1}
        (( nread++ ))
        if [[ $car == "B" ]] ; then (( NB++)) ; fi
done

if(( NA == NB )) ; then echo "perfetto" ;exit 0; else echo "errore1"; exit 1; fi

exit 0
