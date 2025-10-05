#!/bin/bash

./contaseparatamente.sh `ls -S1 /usr/include/*.h | head -7` 1>&2


if (( $? != 0 )); then
	echo "errore"
	exit 1;
fi

exit 0;
