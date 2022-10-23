# Premier-Micro-service - Yassine Lambarki

Travail à faire :
1. Créer un projet Spring Boot avec les dépendances Web, Spring Data JPA, H2, Lombok
2. Créer l'entité JPA Compte
3. Créer l'interface CompteRepository basée sur Spring Data
4. Tester la couche DAO
5. Créer le Web service Restfull qui permet de gérer des comptes
6. Tester le web micro-service en utilisant un client REST comme Postman
7. Générer et tester le documentation Swagger de des API Rest du Web service
8. Exposer une API Restful en utilisant Spring Data Rest en exploitant des projections
9. Créer les DTOs et Mappers
10. Créer la couche Service (métier) et du micro service

### images
````
http://localhost:8080/h2
````
![H2](images/h2.png)


````
http://localhost:8080/bankAccounts
````
![bankaccounts](images/bankaccounts.png)


````
http://localhost:8080/bankAccounts/fc11d3dc-9560-40be-816f-e53f6ac715a7
````

![getbankAccountById](images/getbankaccount.png)


### Swagger

````
http://localhost:8080/swagger-ui/index.html
````

![swagger](images/swagger.png)


### Swagger /v3/api-docs

````
http://localhost:8080/v3/api-docs
````

![/v3/api-docs](images/postman.png)



### RepositoryRestResource

````
http://localhost:8080/bankAccounts/search/findByType?type=SAVING_ACCOUNT
http://localhost:8080/bankAccounts/search/findByType?type=CURRENT_ACCOUNT
````



