# Back-crud-spring
API RESTful desenvolvida em java com springboot framework, Swagger para documentação e  Docker para conteinerização de contêineres. Tem como objetivo retornar uma lista de cursos de programação e 
posteriormente ela será consumida por uma aplicação front-end com Angular.
* <p align="left"><a href="https://github.com/claubermartins/front-crud-angular">Link da aplicação Front-End que irá consumir esta API</a></p>

## Requisitos
* JDK11
* Docker

## Stack e Tecnologias Utilizada
* Java 11
* SpringBoot
* MySql
* H2
* Swagger

## Preparando Ambiente de Produção
* ```mvn clean install -DskipTests=true```
* Gere a imagem do Docker ```docker build -t backCrudSpring.jar .```
* Organize a imagem ```docker tag código_da_imagem nome_do_repositório/projeto:versão```
* Suba a aplicação para o repositório remoto docker ```docker push código_da_imagem nome_do_repositório/projeto:versão```
* Execute a aplicação ```docker run código_da_imagem nome_do_repositório/projeto:versão```

## Instruções Iniciais para testar a api
* <p align="left">Após iniciar a aplicação, acesse o <a href="http://localhost:8080/swagger-ui.html">link da documentação</a> para testar a API com os métodos HTTP: GET, POST, PUT e DELETE.</p>

## Maiores Informações
* <p align="left"><a href="https://hub.docker.com/r/claubermartins/back-crud-spring">Link do repositório com a imagem Docker</a></p>
