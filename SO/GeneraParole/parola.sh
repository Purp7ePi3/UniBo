#!/bin/bash
word=""
for(( i=0; $i<4; i=$i+1 ));do
    word=$word`./lettera.sh`
done
echo -n $word