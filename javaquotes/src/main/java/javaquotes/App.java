/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaquotes;

public class App {

   //Program to get random quote
    public static void main(String[] args) {

       QuoteReader qReader = new QuoteReader();
       System.out.println(qReader.getRandomQuote());

    }


}
