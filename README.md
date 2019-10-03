# Kamana Irankunda Eliane
# News_Portal
#### This is application that records users, departments and news posted, October 3,2019.
#### By **Kamana Irankunda Eliane**
## Description
In the news_portal application a user has the ability to create users, departments and post news regarding the whole company in general and also posts regarding a department specifically. users and departments have a one to many relationship.
## Setup/Installation Requirements
To clone this repository successfully one needs:
#### Dependencies/installations
* The project is based on Apache Spark 2.6.0.
* Installation of IntelliJ IDEA is needed.
* Installation of postgresql is needed.
#### DATABASE installation
**In PSQL**:
* CREATE DATABASE news_portal;
*  \c news_portal;
* CREATE TABLE users (id serial PRIMARY KEY, fName varchar, sName varchar, position varchar, department varchar);
* CREATE TABLE departments (id PRIMARY KEY, dName varchar, description varchar, employeeNo integer);
* CREATE TABLE news(id serial PRIMARY KEY,title varchar, content varchar, dName varchar, type varchar);
## Technologies Used
* HTML
* CSS
* Bootstrap
* JAVA
* Spark framework
## Support and contact details
May you encounter any issue or have any questions and suggestions please contact me at **irankundaeliane9@gmail.com**
### License
I hereby grant all access to everyone to view and use the code in this repository as they wish. 
Copyright (c) 2019 **Eliane**
