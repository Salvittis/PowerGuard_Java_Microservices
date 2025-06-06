#!/bin/bash
echo "Iniciando todos os microserviços PowerGuard..."

gnome-terminal -- bash -c "cd ms-user && mvn spring-boot:run; exec bash" &
gnome-terminal -- bash -c "cd ms-event && mvn spring-boot:run; exec bash" &
gnome-terminal -- bash -c "cd ms-location && mvn spring-boot:run; exec bash" &
gnome-terminal -- bash -c "cd ms-impact && mvn spring-boot:run; exec bash" &
gnome-terminal -- bash -c "cd ms-recommendation && mvn spring-boot:run; exec bash" &
gnome-terminal -- bash -c "cd ms-admin && mvn spring-boot:run; exec bash" &

echo "Todos os serviços foram iniciados em terminais separados."
