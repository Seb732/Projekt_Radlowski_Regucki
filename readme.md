# System wypożyczalni samochodów - Jakub Radłowski, Sebastian Regucki


Projekt korzysta z:
* Java
* Maven
* Junit 5
* Spring boot
* Spring security
* Thymleaf
* MySQL


# Wskazówki
* Aby uruchomić projekt w terminalu należy wpisać komendę `mvn spring-boot:run` a następnie w przeglądarce wejść pod adres `localhost:8080`.
* Strona dostępna jest również pod publicznym adresem `https://rentaly-backend.oa.r.appspot.com` dzięki App Engine w usłudze Google Cloud Platform

* Możesz uruchomić `mvn test` na terminalu, aby uruchomić testy przy uzyciu Maven


# Klasy
* Address: id, city, postalCode, street, buildingNumb, localNumb
* User: id, firstName, lastName, teleNumb, email, role, password
* abstract Client: id, Address, teleNumb, email
* PersonalClient (Client): firstName, lastName, idCard, pesel
* CompanyClient (Client): name, nip, regon 
* Car: id, brand, model, prodYear, vin, registNumb, priceRate (/day), status
* RentOrder: id, Client, Car, rentStartDate, rentEndDate, status, totalCost, List<Damage>
* Damage: id, description, Car, date, price
