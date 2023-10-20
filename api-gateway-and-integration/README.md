# API Gateway and Integration - homework

<p align="center">
  <img src="https://img.shields.io/static/v1?label=homework&message=api&color=blueviolet&style=for-the-badge"/>
  <img src="https://img.shields.io/github/license/MrRioja/api-gateway-and-integration?color=blueviolet&logo=License&style=for-the-badge"/>
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/MrRioja/api-gateway-and-integration?color=blueviolet&logo=TypeScript&logoColor=white&style=for-the-badge">
  <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/MrRioja/api-gateway-and-integration?color=blueviolet&style=for-the-badge">
</p>

<p align="center">
  <a href="#sobre">Sobre</a> •
  <a href="#api">API</a> •
  <a href="#instalação">Instalação</a> •
  <a href="#tecnologias">Tecnologias</a> •
  <a href="#autor">Autor</a>  
</p>

## Sobre

Projeto de avaliação da disciplina **API Gateway and Integration** cursada durante o MBA em FullStack Developer da Impacta.

## API

A ideia do trabalho é construir uma API com os seguintes modelos e endpoints:

![Alt text](<.github/model and endpoints.png>)

A solução foi implementada utilizando NodeJS com Typescript, Prisma ORM e banco de dados Postgres, conforme as techs disponíveis na sessão [tecnologias](#tecnologias).

Além do uso de banco de dados com o intuito de cumprir com o requisito do ponto extra, também foi implementada a paginação nas rotas:

<details>
  <summary>GET - <code>/api/v1/cliente/</code></summary>
  <br/>
  <p>
    Nesse endpoint a pagina é de 5 itens por pagina e a página é definida através do query param <code>page</code>.
  </p>
</details>

<details>
  <summary>GET - <code>/api/v1/cliente/endereco</code></summary>
  <br/>
  <p>
    Nesse endpoint a pagina é de 10 itens por pagina e a página é definida através do query param <code>page</code>.
  </p>
</details>

A coleção de requisições para testar a API está disponível abaixo e pode ser importada facilmente no Insomnia e, pode ser que seja possível, no Postman. Clique no botão abaixo para visualizar o JSON para importação no seu cliente HTTP preferido.

[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://github.com/MrRioja/api-gateway-and-integration/blob/main/.github/Insomnia_2023-06-25.json)

No guia de instalação existe um comando opcional para popular o banco de dados para realizar as requisições.
Ele cria 10 clientes e para cada um deles cria 5 endereços com as cidades e estados abaixo:

```js
const places = [
  {
    city: "São Paulo",
    state: "São Paulo",
  },
  {
    city: "Rio de Janeiro",
    state: "Rio de Janeiro",
  },
  {
    city: "Belo Horizonte",
    state: "Minas Gerais",
  },
  {
    city: "Porto Alegre",
    state: "Rio Grande do Sul",
  },
  {
    city: "Curitiba",
    state: "Paraná",
  },
];
```

Os detalhes dessa criação podem ser visto no arquivo de seed do banco disponível [nesse arquivo](prisma/seed.ts).

## Instalação

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Node.js](https://nodejs.org/en/) e uma instância do [Postgres](https://www.postgresql.org/) rodando na máquina.
Além disso é bom ter um editor para trabalhar com o código como [VSCode](https://code.visualstudio.com/).

> ⚠ Após o clone do repositório é necessário alterar a variável de ambiente DATABASE_URL apontando para a sua instância do Postgres.

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone git@github.com:MrRioja/api-gateway-and-integration.git

# Acesse a pasta do projeto no terminal/cmd
$ cd api-gateway-and-integration

# Instale as dependências
$ npm install
# Caso prefira usar o Yarn execute o comando abaixo
$ yarn

# Execute as migrations para criar o banco de dados corretamente
$ yarn prisma db push

# Execute o arquivo de seed para popular as tabelas do banco (OPCIONAL)
$ yarn prisma db seed

# Execute a aplicação em modo de desenvolvimento
$ npm run dev
# Caso prefira usar o Yarn execute o comando abaixo
$ yarn dev

# O servidor iniciará na porta 3333 ou na porta definida no arquivo .env na variável PORT - acesse <http://localhost:3333>
```

## Tecnologias

[![My Skills](https://skillicons.dev/icons?i=nodejs,express,postgres,prisma,docker,ts&perline=10&theme=dark)](https://skillicons.dev)

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
