#!/bin/bash

echo $start
if (( $start < $stop)); then
	(( start=$start +1 ))
	./figlio.sh
fi

exit 0
