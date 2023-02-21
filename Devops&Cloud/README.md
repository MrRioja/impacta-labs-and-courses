# Lab DevOps & Cloud Computing

<p align="center">
  <img src="https://img.shields.io/static/v1?label=lab&message=devops/cloud&color=blueviolet&style=for-the-badge"/>
  <img src="https://img.shields.io/github/license/MrRioja/devopslab?color=blueviolet&logo=License&style=for-the-badge"/>
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/MrRioja/devopslab?color=blueviolet&logo=python&logoColor=white&style=for-the-badge">
  <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/MrRioja/devopslab?color=blueviolet&style=for-the-badge">
</p>

<p align="center">
  <a href="#sobre">Sobre</a> •
  <a href="#devops--cloud-computing">DevOps & Cloud Computing</a> •
  <a href="#instalação">Instalação</a> •
  <a href="#tecnologias">Tecnologias</a> •
  <a href="#autor">Autor</a>  
</p>

## Sobre

Repositório com a finalidade de registrar as implementações e anotações realizadas durante o Lab DevOps & Cloud Computing cursado durante o MBA da Impacta em FullStack developer.

## DevOps & Cloud Computing

Projeto desenvolvido durante o Lab DevOps&Cloud Computing cursado no MBA em Fullstack Developer da Faculdade Impacta.

A ideia do Lab é entender como funcionam os dois mundos de maneira pratica. Para isso passamos por uma experiencia hands-on explorando ferramentas, boas práticas, entre outras situações mais próximas possíveis da realidade.

Durante as aulas recebemos backlogs "fictícios" (mas com situações reais) para implementarmos soluções para atingir os resultados propostos. As atividades estão disponíveis nesse [board no Trello](https://trello.com/b/Lm30X87r/lab-devops-cloud-computing).

### Backlogs

#### 1. Code / Build 🏗

Nesse backlog fizemos as seguintes ações:

- Clone do repo template do lab.
- Merge da branch contendo a aplicação e os testes unitários.
- Ativação do GitHub Actions no repo.
- Criação da pipeline.
- Adição da etapa de execução de testes unitários na pipeline.
- Customização da mensagem de retorno da API do repo.
- Criação de bug para visualizar a pipeline falhando e logo após a realização da correção.

#### 2. Docker & Deploy 🚚

Nesse backlog fizemos as seguintes ações:

- Entendimento do que é o Docker, container e criação de uma conta no DockerHub.
- Acesso o Docker playground e estudo de alguns comandos básicos do Docker.
- Criação de uma nova branch para criar uma imagem da nossa aplicação e criação de containers a partir dela.
- Abertura de portas do container no Docker Playground para podermos chamar nossa API do mundo externo.

## Instalação

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com) e [Python](https://www.python.org/).
Além disso é bom ter um editor para trabalhar com o código como [VSCode](https://code.visualstudio.com/).

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone git@github.com:MrRioja/devopslab.git

# Acesse a pasta do projeto no terminal/cmd
$ cd devopslab

# Crie um ambiente virtual
$ python3 -m venv venv

# Ative o ambiente virtual
$ . venv/bin/activate

# Instale o Flask no ambiente virtual
$ pip install Flask

# Execute o projeto
$ flask run

# Rode os testes
$ python -m unittest -v test

# O servidor estará disponível na porta 5000 - Acesse <http://127.0.0.1:5000>
```

## Tecnologias

<img align="left" src="https://logos-world.net/wp-content/uploads/2021/10/Python-Logo.png" alt="Python" height="75" />

<img align="left" src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Flask_logo.svg/1280px-Flask_logo.svg.png" alt="Flask" height="75"/>

<br><br><br>

## Autor

<div align="center">
<img src="https://images.weserv.nl/?url=avatars.githubusercontent.com/u/55336456?v=4&h=100&w=100&fit=cover&mask=circle&maxage=7d" />
<h1>Luiz Rioja</h1>
<strong>Backend Developer</strong>
<br/>
<br/>

<a href="https://linkedin.com/in/luizrioja" target="_blank">
<img alt="LinkedIn" src="https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white"/>
</a>

<a href="https://github.com/mrrioja" target="_blank">
<img alt="GitHub" src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white"/>
</a>

<a href="mailto:lulyrioja@gmail.com?subject=Fala%20Dev" target="_blank">
<img alt="Gmail" src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" />
</a>

<a href="https://api.whatsapp.com/send?phone=5511933572652" target="_blank">
<img alt="WhatsApp" src="https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white"/>
</a>

<a href="https://join.skype.com/invite/tvBbOq03j5Uu" target="_blank">
<img alt="Skype" src="https://img.shields.io/badge/SKYPE-%2300AFF0.svg?style=for-the-badge&logo=Skype&logoColor=white"/>
</a>

<br/>
<br/>
</div>
