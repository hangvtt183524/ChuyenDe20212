# CHUYEN DE 2021.2 - SUBJECT PROJECT - Group 2
## Hanoi University of Science and Technology
***

**Setup Project**

1. Frontend:

***Technology: Vuejs***

>cd ./PetCare-Portal

>npm install

To run the project:

>npm start

**To run ADMIN portal and DOCTOR portal: Do the same as PetCare-Portal**

2. Backend:

***Technology: Spring Boot and Nodejs***
***Databse: MYSQL***

Needed tools

* [Java 11 JDK](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [Intellif](https://www.jetbrains.com/idea/download/#section=windows)
* [Nodejs](https://nodejs.org/en/)
* [Docker](https://www.docker.com/)

Run Backend:

* Build docker container:
>cd ./PetCare-Server

>cd ./PetCare-DriverService

>docker-compose up -docker

* Run all services in order: 

        ** DiscoveryService
        
        ** GatewayService
        
        ** InfotypeService
        
        ** DriverService
        
## Thank all!