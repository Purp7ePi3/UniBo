#!/bin/bash

while read nome cognome multa data; do
    out=`grep $multa multe.txt | wc -l`
    if [[ $out != "" ]]; then echo $multa $out; fi
done < multe.txt | uniq