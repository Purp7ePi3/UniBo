#Padre chiama figlio 10 volte e controlla quanti sono in azione, quando non c'è più nessuno in esecuzione allora termina
#Figlio stampa il suo PID e in numero random

# Jobs | grep Running | wc -l 
jobs: Lists all the current background jobs in the shell session, showing their status (e.g., Running, Stopped, etc.).

grep Running: Filters the output of jobs to show only lines containing the word Running. These represent jobs that are actively executing in the background.


Jobs:
[1]+  Running                 ./figlio.sh &
[2]-  Running                 ./another_script.sh &
[3]   Stopped                 ./paused_script.sh

grep Running:

[1]+  Running                 ./figlio.sh &
[2]-  Running                 ./another_script.sh &