#!/bin/bash

intCounter=0
while read line; do
    c=0
    for word in $line; do 
        #echo $word:$c
        (( c=$c+1))
        if [[ $word == "int" ]] && (( c<10 )); then
            (( intCounter=$intCounter+1 )) 
        fi
    done
done < prova.txt
echo $intCounter
exit 0