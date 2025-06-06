@echo off
echo Iniciando todos os microserviços PowerGuard...

start cmd /k "cd ms-user && mvn spring-boot:run"
start cmd /k "cd ms-event && mvn spring-boot:run"
start cmd /k "cd ms-location && mvn spring-boot:run"
start cmd /k "cd ms-impact && mvn spring-boot:run"
start cmd /k "cd ms-recommendation && mvn spring-boot:run"
start cmd /k "cd ms-admin && mvn spring-boot:run"

echo Todos os serviços foram iniciados em janelas separadas.
