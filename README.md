# scrumtool.com

Scrumtool is a website for managing Scrum projects.

### Introduction

***Scrumtool.com*** is a...

### Environment setup

* Download and install MySQL Server and MySQL Workbench (the later is optional, but recommended if you don't have experience with MySQL).

* You must have [Java Version 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed and the JAVA_HOME & JAVA_PATH environment variables set properly.

* [Maven 3](https://maven.apache.org/download.cgi) or higher is required.

### How to run the project
* Clone/Download the project from this repository.
* Create a MySQL user with username "root" and password "mydbpass" (these values can be changed in application.properties)
* Create a new DB Connection listening on localhost and port 3306 (can also be changed in application.properties)
* Export the ScrumTool.sql file either with MySQL Workbench or from the command line.
* Run the `mvn spring-boot:run` from the root directory of the project.
* The application should be available at url `localhost:8080`
