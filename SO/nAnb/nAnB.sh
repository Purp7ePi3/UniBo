#!/bin/bash
if (( $# != 1 )) ; then echo "manca l' argomento a riga di comando"; exit 1; fi
NA=0; NB=0; ris=0;
WORD=$1
LENWORD=${#WORD}
NLETTI=0
# cerco le A e la prima B dopo quaFlche A
while (( ${NLETTI} < ${LENWORD} )) ; do # ci sono altri letteraatteri da leggere
    # prendo il letteraattere in posizione NLETTI (all'inizio NLETTI 0)
    lettera=${WORD:${NLETTI}:1}
    (( NLETTI=${NLETTI}+1 ))
    if [[ ${lettera} == "A" ]] ; then
        ((NA=$NA+1)) ;
    else
        if [[ ${lettera} == "B" && ${NA} -gt 0 ]] ; then
            NB=1
            break;
        fi
        echo falso caso 1
        exit 1
    fi
done
while (( ${NLETTI} < ${LENWORD} )) ; do 
    lettera=${WORD:${NLETTI}:1}
    (( NLETTI=${NLETTI}+1 ))
    if [[ ${lettera} == "B" ]] ; then
        ((NB=$NB+1)) ;
    else
        echo falso caso 2
        exit 2
    fi
done
if [[ $NA -gt 0 && $NA == $NB ]] ; then echo vero N=$NA; exit 0
else echo falso caso 3: exit 3; fi
