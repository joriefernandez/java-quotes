# Java Quotes
Return a random quote from API: http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en or from the quotes file.

## To run the application, :
1. clone the repo
2. add dependency on build.gradle: `implementation 'com.google.code.gson:gson:2.8.5'`
3. go to the directory and run: `./gradlew run`

## Source Codes
* [App](https://github.com/joriefernandez/java-quotes/blob/master/javaquotes/src/main/java/javaquotes/App.java), [Quote](https://github.com/joriefernandez/java-quotes/blob/master/javaquotes/src/main/java/javaquotes/Quote.java), [QuoteAPI](https://github.com/joriefernandez/quotes/blob/master/javaquotes/src/main/java/javaquotes/QuoteAPI.java), and [QuoteReader](https://github.com/joriefernandez/java-quotes/blob/master/javaquotes/src/main/java/javaquotes/QuoteReader.java) classes are under src/main folders.
* To run [Test cases](https://github.com/joriefernandez/java-quotes/tree/master/javaquotes/src/test/java/javaquotes): `./gradlew test`

