#!/bin/bash

counter=0
while read {A..K}; do
        for word in {A..J} ; do
                if [[ -n ${!word} && ${!word} == "int" ]] ; then
                        (( counter=${counter}+1 ))
                fi
        done
done < ./prova.txt

echo contate $counter parole \"int\"

