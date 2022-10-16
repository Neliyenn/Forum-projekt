# Forum o tematyce podróżniczej 

## O aplikacji

Aplikacja forum podróżniczego została stworzona na potrzeby przedmiotu Programowanie aplikacji back-endowych, aby pokazać praktyczne zastosowanie języka JAVA w połączeniu z dostępem i zarządzaniem bazą danych.   

Aplikacja została napisana z wykorzystaniem Spring Boot, Spring Security, Thymeleaf, Spring Data JPA oraz  Spring Data REST. Za szatę graficzną odpowiada Thymeleaf. Aplikacja zawiera funkcjonalności rejestracji i logowania. 


## Instrukcja uruchomienia 

### Pliki konfiguracyjne
Folder src/resources/ zawiera plik konfiguracyjny **application.properties** dla aplikacji. Można w nim zmienić port oraz login i hasło konta administratora.

### Instrukcja uruchomienia
Otwórz aplikację w programie IntelliJ. Znajdź plik „ForumApp” i otwórz go. Uruchom aplikację klikając zielony „trójkąt” w 7 linii.

![screen1](https://user-images.githubusercontent.com/65779777/196040341-af762052-6077-4f9c-8303-039b4f1f4bad.png)

Wpisz w przeglądarce adres ```http://localhost:port/home``` . W miejsce słowa ```port``` wstaw wartość umieszczoną w pliku **application.properties**.

![port](https://user-images.githubusercontent.com/65779777/196040511-00f94862-4a70-4ee3-a3eb-dd62c0cec1a9.png)

### Interfejs webowy bazy danych
W oknie przeglądarki wpisz adres ```http://localhost:port/h2-console```. W miejsce słowa ```port``` wstaw numer portu aplikacji. W pliku **application.properties** znajdują się dane dotyczące logowania do interfejsu bazy danych. 

![h2](https://user-images.githubusercontent.com/65779777/196040648-23efd929-fc54-4bff-9425-466cfb3e9e39.png)

W polu **JDBC URL** wstaw dane z linii 6. 
Zaloguj się i nawiąż połączenie:
Username: **sa**
Password: 
