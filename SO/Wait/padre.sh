#!/bin/bash

for ((i=1; i<=4; i++)); do
    echo "Avvio figlio $i"
    sleep $((i * 2)) &  # Simula processi figli con durata diversa
done

# Monitora i figli in esecuzione
while jobs | grep -q "Running"; do
    echo "Ci sono ancora figli in esecuzione..."
    sleep 1
done

echo "Tutti i figli sono terminati!"
