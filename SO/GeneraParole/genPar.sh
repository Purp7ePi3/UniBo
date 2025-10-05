#!/bin/bash
word=""
c=0
while true; do 
    (( c=$c+1 ))
    word=`./parola.sh`
    if [[ $word == "cacc" ]]; then echo "$c tenativi per $word"; break; fi
done
exit 0