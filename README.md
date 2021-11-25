# :plate_with_cutlery: Автотесты для сайта restoclub.ru

<img src="images/01.png" width="600" height="400"> 

## :stethoscope: Стек:
| GitHub | IDEA | Java | Junit5 | Gradle | Selenide | Selenoid | Allure Report | Allure TO | Jenkins | Jira |
|:--------:|:-------------:|:---------:|:-------:|:----:|:------:|:----:|:----:|:------:|:------:|:--------:|
| <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Allure TestOps.svg" width="40" height="40"> | <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Jira.svg" width="40" height="40"> |
___

## Для запуска тестов используются команды:

Если файл local.properties заполнен, то для запуска тестов необходимо выполнить команду:
```bash
gradle clean test
```
Если файл local.properties не заполнен, то для запуска тестов необходимо выполнить команду:
```bash
gradle clean test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://user1:1234@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/ -Dthreads=${THREADS}
```

Генерация отчета:
```bash
allure serve build/allure-results
```
___

## Запуск тестов происходит в CI [Jenkins](https://jenkins.autotests.cloud/job/restoclub-tests/)

<img src="images/jenkinsreport.png" width="800" height="600"> 

## Уведомления о прохождение тестов отправляются в Telegram

<img src="images/telegramreport.png" width="800" height="600"> 

## Видеотчет теста "Успешная авторизация"

<img src="images/videotest.gif" width="1000" height="600"> 