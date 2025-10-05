#!/bin/bash
job=0
for((i=0; i<10; i=$i+1)); do
    ./figlio.sh &
done
while true; do
    sleep 2
    job=`jobs | grep Running | wc -l`
    echo `jobs`
    echo $job
    if(( $job == 0 )); then exit 0; fi 
done
exit 0