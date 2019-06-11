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

    private static final String FILE = "src/main/resources/recentquotes.json";


    //quote
    protected List<Quote> quotes;

    //quote
    protected QuoteAPI quoteAPI;

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
        readQuoteFile();
        try {
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            //  &apiKey=" +System.getenv("YELP_API_KEY")
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if(con.getResponseCode() == 200){
                // this line of code actually goes to the internet!
                BufferedReader reader = new BufferedReader(new InputStreamReader((con.getInputStream())));

                // get json data in response
                // use Gson to parse json string into a number fact object
                Gson gson = new GsonBuilder().serializeNulls().create();

                quoteAPI = gson.fromJson(reader, QuoteAPI.class);
                quotes.add(new Quote(quoteAPI.getQuoteAuthor(), quoteAPI.getQuoteText()));

                quote = quoteAPI.toString() ;
                writeToFile();

            }

        } catch (IOException e) {
//            readQuoteFile();
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

    public String getRandomQuote(){
        return quote;
    }

    private void writeToFile(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(quotes);
        try {
            System.out.println("Writing to file...");
            FileWriter writer = new FileWriter(FILE);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
