### CRUD com Spring boot + Thymeleaf

---

#### Requisitos

- Java JDK 8+
- Maven
- Mysql (Nome do banco = bdTask)

---

#### Instruções 

1- Clone este projeto
```Shell
git clone https://github.com/gabriellima96/projeto-task.git
```

2- Adicione seu usuario e senha do MySQL no arquivo **application.properties** em:
```
projeto-task/src/main/resources/application.properties
```

3- Build - Dentro da pasta do projeto execute:
```Shell
mvn clean install
```

4- Run
```Shell
mvn exec:java -X -Dexec.mainClass="site.gabriellima.projetotask.ProjetoTaskApplication" -Ddetail=true
```

5- Acesse a página inicial em **http://localhost:8080/**

#### Screenshots

- Lista de Task
![Lista de Task](https://raw.githubusercontent.com/gabriellima96/projeto-task/master/Screenshots/Demonstracao3.png)

- Adicionando uma Task
![Adicionando uma Task](https://raw.githubusercontent.com/gabriellima96/projeto-task/master/Screenshots/Demonstracao2.png)

- Deletando uma Task
![Deletando uma Task](https://raw.githubusercontent.com/gabriellima96/projeto-task/master/Screenshots/Demonstracao1.png)
