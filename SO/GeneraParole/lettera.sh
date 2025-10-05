#!/bin/bash


(( x=$RANDOM%2))
if (( $x == 1 )); then echo -n a; else echo -n c; fi