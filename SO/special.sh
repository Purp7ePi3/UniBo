echo $$ # PID del progamma
echo $PPID # PPID del padre
echo $_ # Restituisce l'ultimo argomento dell'ultimo comando eseguito.
(( x=$RANDOM%10 )) #Random
echo $x

echo $@ # Mi stampa tutti gli argomenti passati in input
echo $* # Simile a quello sopra ma li tratta tutti come una stringa unica
echo $# # Mi stampa quanti argomenti ci sono
echo $? # Restituisce il codice di uscita dell'ultimo comando eseguito.
echo $0 # Restituisce il nome dello script o comando corrente
echo $1 $2
echo $USER #Mostra il nome dell'utente corrente.
echo $PWD # Restituisce il percorso della directory di lavoro corrente.


IFS=,\". # Permette di cambiare i speratore nelle parole in comandi shell tipo read e for

# Variabile con valori separati da virgola
stringa="apple,banana\"cherry.apriot"

# Legge la stringa in un array usando la virgola come delimitatore
for frutto in $stringa; do
  echo "$frutto"
done