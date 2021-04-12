User Authentication & Authorization using Spring Boot, Security & Data JPA
--------

### Overview
This a demo project to authenticate and authorize user using spring security JPA.

#### Implementation

* There are 3 endpoints
    * `/`: No authentication needed and open for all.
    * `/user` : Authentication needed and only `SUPER_ADMIN` & `ADMIN` role users will able to access.
    * `/role` : Authentication needed and only `SUPER_ADMIN` role users will able to access.
    

#### Dependencies

* Spring Boot 2
* Spring Web
* Spring Data JPA
* Spring Security
* H2 in-memory database
* Lombok

#### Built tool
* Maven

#### Run inside Docker Container

Project include `dockerfile`. You can build the image using 

```

```