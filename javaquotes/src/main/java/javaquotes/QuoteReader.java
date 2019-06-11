package javaquotes;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;


public class QuoteReader {

    private static final String FILE = "src/main/resources/recentquotes.json";


    //quote
    protected Quote[] quotes;

    //quote
    protected QuoteAPI quoteAPI;

    protected String quote;
    //Constructor
    public QuoteReader(){
        this.quote = readQuote();

    }

    //Read and return quotes from file
    private String readQuoteFile(){
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(FILE));
            quotes = gson.fromJson(reader, Quote[].class);
            return generateRandomQuote();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return generateRandomQuote();

    }

    //get quote from API
    private String readQuote(){
        try {
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            //  &apiKey=" +System.getenv("YELP_API_KEY")
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if(con.getResponseCode() == 200){
                // this line of code actually goes to the internet!
                BufferedReader reader = new BufferedReader(new InputStreamReader((con.getInputStream())));

                // get json data in response
                // use Gson to parse json string into a number fact object
                Gson gson = new Gson();
                quoteAPI = gson.fromJson(reader, QuoteAPI.class);
                // access the text of the number fact
                // return that text so that it can be printed
                quote = quoteAPI.toString() ;

            }else{
               quote = readQuoteFile();

            }


        } catch (IOException e) {
            quote = readQuoteFile();

        }
        return quote;
    }

    //Generate random quote
    public String generateRandomQuote(){

        int index = new Random().nextInt(quotes.length);
        StringBuilder result = new StringBuilder();
        result.append(quotes[index].getText());
        result.append("\n- " + quotes[index].getAuthor());

        return result.toString();
    }

    public Quote[] getQuotes() {
        return quotes;
    }

    public String getRandomQuote(){
        return quote;
    }


}
