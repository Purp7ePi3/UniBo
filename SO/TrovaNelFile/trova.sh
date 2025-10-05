#!/bin/bash

if (( $# != 2 )); then exit 1; fi

while read nome lar alt prof; do
    if (( $lar >= $1 )); then 
        if (( $alt <= $2 )); then 
            echo "$nome $lar $alt $prof "
        fi
    fi
done < divani.txt
exit 0