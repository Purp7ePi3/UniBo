#!/bin/bash

# analizzare il contenuto del file di cui e' passato il percorso come argomento
# e generare una sequenza di righe del tipo:    numero parola
# che dice quali parole sono contenute nel file
# e quante volte sono ripetute.
# Ad esempio, se il file contenesse le righe:
#
#  alfa beta gamma gatto
#  gatto cane pesce gatto
#  beta gatto
#
#  beta gatto
#
# allora l'output dovrebbe essere:
#
#  alfa 1
#  beta 2
#  gamma 1
#  gatto 4
#  cane 1
#  pesce 1
#
#  eventualmente con le righe elencate in un ordine diverso.


# Suggerimenti:
# 1) usare sed per spezzare le righe del file in tante righe quante sono le parole
#    sostituendo gli spazi e i tab con delle andate a capo. In tal modo ciascuna
#    nuova riga conterra' solo una parola oppure sara' una riga vuota.
# 2) eliminare le righe vuote.
# 3) ordinare le righe cosi' ottenute in modo che le righe uguali siano
#    raggruppate. usare sort
# 4) usare uniq per contare le righe uguali
# 5) invertire la prima e la seconda parola dell'output per mettere
#    per prima la parola e per seconda il numero di volte che la parola compare.

# sed 's/ /\n/g' ./prova.txt | sed 's/\t/\n/g' | .......


#MOLTO LENTO PER FILE DI GRANDI DIMENSIONI
# Usa il comando time per misurare il tempo di esecuzione
time (
    while IFS= read -r line; do
        for word in $line; do
            out=$(grep -o "\b$word\b" "$1" | wc -l)
            #echo "$word $out"
        done
    done < "$1" | sort -k2,2nr | uniq
)

#MOLTO PIù OTTIMIZZATO
time(
sed 's/ /\n/g' $1  | sed 's/\t/\n/g' |
   while read RIGA ; do if [[ -n "${RIGA}" ]] ; then echo "${RIGA}" ; fi ; done |
   sort | uniq -c |
	 while read NUM PAROLA ALTRO ; do echo echo "$PAROLA $NUM" ; done 
)