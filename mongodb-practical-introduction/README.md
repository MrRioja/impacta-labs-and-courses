# MongoDB - Practical introduction

<p align="center">
  <a href="#sobre">Sobre</a> •
  <a href="#mongodb">MongoDB</a> •
  <a href="#tecnologias">Tecnologias</a> •
  <a href="#autor">Autor</a>  
</p>

## Sobre

O propósito desse projeto é conhecer o banco MongoDB e praticar os ensinamentos aprendidos durante o curso **MongoDB - Introdução Prática** realizado durante o meu MBA na Impacta.

## MongoDB

Aqui irei adicionar anotações feitas durante o curso prático de MongoDB afim de registrar meu aprendizado ao longo do estudo sobre essa tecnologia.

Como o proposito aqui é servir como anotação, não irei registrar como realizar conexão, configuração ou qualquer outro conteúdo mais técnico.

### Comandos CRUD

#### Create

- Inserir um documento em uma coleção:

```sh
$ db.collectionName.insert({ key: "value" })
```

> ℹ Caso a coleção não existe, por padrão, o Mongo irá cria-la e inserir o novo documento

#### Read

- Exibir o total de documentos de uma coleção:

```sh
$ db.collection.countDocuments()
```

- Listar todos os documentos de uma coleção:

```sh
$ db.collection.find()
```

> ℹ É possível adicionar `.pretty()` no final do comando acima para exibir o resultado de maneira mais legível.

- Listar um documento de uma coleção:

```sh
$ db.collection.findOne()
```

> ℹ Caso um filtro não seja inserido, por padrão, será exibido o documento por ordem de inserção.

#### Update

- Atualizar um documento:

```sh
$ db.collection.updateOne({ key: 'value' }, { $set: { key: 'value' } })
```

#### Delete

- Remover um documento:

```sh
$ db.collection.deleteOne({ key: 'value' })
```

### Comandos úteis

- Acessar o shell do mongo:

```sh
$ mongosh
```

- Criar uma nova coleção:

```sh
$ use databasename
```

- Criar usuário para acessar o banco:

```sh
$ db.createUser({ user: "admin", pwd: "password", roles: [{ role: "root", db: "admin" }]})
```

- Listar usuários:

```sh
$ db.getUsers()
```

- Remover usuário:

```sh
$ db.dropUser("userName")
```

- Criar coleção:

```sh
$ db.createCollection('collectionName')
```

- Listar coleções:

```sh
$ show collections
```

## Tecnologias

<img align="left" src="https://profilinator.rishav.dev/skills-assets/nodejs-original-wordmark.svg" alt="Node.js" height="75" />

<img align="left" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/MongoDB_Logo.svg/2560px-MongoDB_Logo.svg.png" alt="MongoDB" height="75"/>

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
