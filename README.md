# Water taxation application
## Spring Boot + MySQL + Docker + Kubernetes

Run this command to create jar artificats

```
mvn package
```
Build the docker image using the following command
```
docker build -t water-taxation:1.0 .
```

Use the following command to create a docker for the app : 

```
$ docker network create water-project
16fb34cc2bf202e427d7610f6e59294062c9fb990495e97c1c3f37c7f0002eca
```

Display docker networks : 

```
$ docker network ls
NETWORK ID     NAME            DRIVER    SCOPE
2150d5a84198   bridge          bridge    local
4ca452ff087f   host            host      local
579a19ad1643   none            null      local
16fb34cc2bf2   water-project   bridge    local
```

Create the database container

```
docker container run --name mysqldb --network water-project -e MYSQL_ROOT_PASSWORD=PasswordDatabse@2022 -e MYSQL_DATABASE=watertaxation -d mysql
```

Make sure the applicatioon.properties file contains the following :

```
# MySQL Configuration
spring.datasource.url=jdbc:mysql://${DB_HOST}:3306/watertaxation
spring.datasource.username=root
spring.datasource.password=PasswordDatabse@2022
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.properties.hibernate.globally_quoted_identifiers=true
```

Set the enviroment variable :

Under Windows

```powershell
set DB_HOST=localhost
```

Linux

```sh
export DB_HOST=localhost
```

Build the package :

```sh
mvn package
```

Build the docker image using the following command

```sh
docker build -t water-taxation:1.0 .
```

Finally, run the application container :

```
docker container run --network water-project --name water-taxation-app -p 8085:8080 -e DB_HOST=mysqldb -d water-taxation:1.0
```

By default, traffic from containers connected to the default bridge network is not forwarded to the outside world. To enable forwarding, you need to change two settings.

```sh
sudo sysctl net.ipv4.conf.all.forwarding=1
sudo iptables -P FORWARD ACCEPT
```
### docker compose

Run the following command

```sh
$ docker compose up -d
[+] Running 19/19
 ⠿ myapp-mysql 
 ⠿ myapp-main 
[+] Running 4/4
 ⠿ Network water_default          Created                                                                                                          0.4s
 ⠿ Volume "water_mysql-data"      Created                                                                                                          0.0s
 ⠿ Container water-myapp-mysql-1  Created                                                                                                          0.3s
 ⠿ Container water-myapp-main-1   Created                                                                                                          0.1s
```

Login using the following url: http://<ip/hostname/localhost>:8085/

```sh
$ docker ps
CONTAINER ID   IMAGE                                   COMMAND                  CREATED          STATUS          PORTS                                                  NAMES
87190bb110e1   younessberianebadi/water-taxation:1.0   "java -jar /app.jar"     10 minutes ago   Up 10 minutes   0.0.0.0:8085->8080/tcp, :::8085->8080/tcp              water-myapp-main-1
77d96a5438ea   mysql                                   "docker-entrypoint.s…"   10 minutes ago   Up 10 minutes   0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp   water-myapp-mysql-1

```