# System wypożyczalni samochodów

Szablonowy projekt do użycia w środowisku IntelliJ.

Projekt korzysta z:
* IntelliJ
* Java
* Junit 5
* Travis CI
* Gradle
* The Gradle wrapper (gradlew)
* [TestFX](https://github.com/TestFX/TestFX) do użycia komponentów JavaFX w testach
* JaCoCo do generowania raportów dla testów pokryciowych
* Coveralls aby wyświetlić więcej statystyk testów pokryciowych

# Wskazówki
* Możesz szybko zaimportować projekt do IntelliJ, importując plik `build.gradle`.

* Możesz uruchomić `gradlew test` na terminalu, aby uruchomić testy za pomocą gradle z opakowaniem gradle (więc nie musisz ręcznie instalować gradle - lokalnie).

* Jeśli wszystkie słowa kluczowe Gradle są wyszarzone, możesz połączyć projekt Gradle w IntelliJ, jeśli nie widzisz wyskakującego okienka z prośbą o przejście do modułów - zaimportuj moduł i wybierz swój build.gradle.
