# Back-crud-spring
API RESTful desenvolvida em java com springboot framework, Docker para conteinerização de contêineres. Tem como objetivo retornar uma lista de cursos de programação e 
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

## Preparando Ambiente de Produção
* ```mvn clean install -DskipTests=true```
* Gere a imagem do Docker ```docker build -t backCrudSpring.jar .```
* Organize a imagem ```docker tag código_da_imagem nome_do_repositório/projeto:versão```
* Suba a aplicação para o repositório remoto docker ```docker push código_da_imagem nome_do_repositório/projeto:versão```
* Execute a aplicação ```docker run código_da_imagem nome_do_repositório/projeto:versão````

## Instruções Iniciais para testar a api
* Utilize o Postman criando um request para testar o funcionamento da api utilizando os métodos HTTP: GET, POST, PUT e DELETE.

## Maiores Informações
* <p align="left"><a href="">Link do repositório com a imagem Docker</a></p>
