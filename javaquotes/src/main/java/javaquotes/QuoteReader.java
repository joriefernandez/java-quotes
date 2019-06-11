package javaquotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class QuoteReader {

    //Quote file
    private static final String FILE = "src/main/resources/recentquotes.json";

    //list of quotes
    protected List<Quote> quotes;

    //quote from API
    protected QuoteAPI quoteAPI;

    //Random quote
    protected String quote;

    //Constructor
    public QuoteReader(){
        this.quote = readQuote();
    }

    //Read  quotes from file
    private void readQuoteFile(){
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(FILE));
            quotes = gson.fromJson(reader, new TypeToken<List<Quote>>(){}.getType());

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    //get quote from API
    private String readQuote(){
        //read quotes from file
        readQuoteFile();
        try {
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //check if getting data is successful
            if(con.getResponseCode() == 200){
                //init reader
                BufferedReader reader = new BufferedReader(new InputStreamReader((con.getInputStream())));

                // get json data in response
                // use gson
                Gson gson = new GsonBuilder().serializeNulls().create();
                //create a quoteAPI object
                quoteAPI = gson.fromJson(reader, QuoteAPI.class);
                //add to the list of quotes
                quotes.add(new Quote(quoteAPI.getQuoteAuthor(), quoteAPI.getQuoteText()));
                //set resulting quote
                quote = quoteAPI.toString() ;
                //write quotes to the file
                writeToFile();

            }

        } catch (IOException e) {
            //get random quote in the file
            quote = generateRandomQuote();
        }
        return quote;
    }

    //Generate random quote
    public String generateRandomQuote(){

        int index = new Random().nextInt(quotes.size());
        StringBuilder result = new StringBuilder();
        result.append(quotes.get(index).getText());
        result.append("\n- " + quotes.get(index).getAuthor());

        return result.toString();
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    //Return random quote
    public String getRandomQuote(){
        return quote;
    }

    //Write to file
    private void writeToFile(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(quotes);
        try {

            FileWriter writer = new FileWriter(FILE);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
