### CRUD com Spring boot + Thymeleaf

---

#### Requisitos

- Java JDK 14+
- Maven
- Mysql (Nome do banco = dbTask)
- Docker (Opcional)

---

#### Instruções 

1- Clone este projeto
```console
git clone https://github.com/gabriellima96/projeto-task.git
```

2- Adicione seu usuario e senha do MySQL no arquivo **application.properties** em:
```console
projeto-task/src/main/resources/application.properties
```

3- Acesse a pasta do projeto
```console
cd projeto-task
```

4- Build - Construa o projeto
```console
mvn package
```

4- Run - Rode o projeto
```console
java -jar target/projeto-task-0.0.1-SNAPSHOT.jar
```

5- Acesse a página inicial em **http://localhost:8080/**

### Docker
1 - Build - Construa o projeto com o docker-compose
```console
docker-compose up --build
```

2- Acesse a página inicial em **http://localhost:8080/**

#### Screenshots

- Lista de Task
![Lista de Task](https://raw.githubusercontent.com/gabriellima96/projeto-task/master/Screenshots/Demonstracao3.png)

- Adicionando uma Task
![Adicionando uma Task](https://raw.githubusercontent.com/gabriellima96/projeto-task/master/Screenshots/Demonstracao2.png)

- Deletando uma Task
![Deletando uma Task](https://raw.githubusercontent.com/gabriellima96/projeto-task/master/Screenshots/Demonstracao1.png)
