#!/bin/bash

(( x=1+$RANDOM%10 ))
echo "numsec $x $$"
sleep $x
echo "numsec $x $$"
exit 0