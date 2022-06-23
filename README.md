[![Build Status](https://app.travis-ci.com/bespalov0928/work_car_accident.svg?branch=main)](https://app.travis-ci.com/bespalov0928/work_car_accident)
## Описание

### О проекте
Проект - Автонарушители
В системе существуют две роли (пользователь, автоинспектор).
Пользователь создает заявление правонарушения.
В заявлении указывает: адрес, номер машины, описание нарушения.

### Стек технологий
* Java 17
* Spring Security
* Spring Data JPA
* PostgreSQL
* Liquibase
* JSP
* JSTL
* jacoco
* travic


### Сборка и запуск
Сборка
```
mvn install
```
запуск
```
копирование файла из target\work_car_accident.war в папку apache-tomcat-9.0.44\webapps
запуск tomcat - apache-tomcat-9.0.44\bin\startup.bat
```

### Как использовать
Регистрация нового пользователя
![ScreenShot](images/req.png)

авторизация пользователя
![ScreenShot](images/login.png)

главная страница
![ScreenShot](images/index.png)

добавление инцидента
![ScreenShot](images/create.png)

редактировние инцидента
![ScreenShot](images/update.png)


### Контакты
Skype: bespalov0928


