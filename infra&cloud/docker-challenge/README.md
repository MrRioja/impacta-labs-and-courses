# Infrastructure and Cloud Computing

Desafio proposto durante a disciplina **Infrastructure and Cloud Computing** cujo objetivo foi:

- [x] Criar dois containers docker:
  - [x] Nginx.
  - [x] MySQL.
- [x] Garantir que o container Nginx esteja acessível na porta 80 do host.
- [x] Garantir que o container Nginx consiga se comunicar com o container de MySQL.

## Criando o ambiente da solução

Após clonar esse repositório e acessa-lo no terminal, executando os comandos abaixo, criaremos o ambiente e iremos validar a comunicação entre os containers. Após o ultimo comando, se as tabelas default do MySQL forem exibidas, tudo ocorreu como o esperado.

```sh
# Criação do ambiente baseado no docker-compose.yml
docker-compose up -d

# Acesso ao container Nginx para validar comunicação com o container MySQL
docker exec -ti nginx sh

# Logando no MySQL
mysql -u root -p -h mysql

# Listando tabelas default do MySQL para validar sucesso do ambiente
show databases;
```

## Integrantes do grupo

Fabrício Diniz Batista

Ivo Byung Chul Kim

Luiz Lélis Rioja Silva

Rafael Duram Santos

Sergio Antonio Silva Junior
