package javaquotes;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Random;


public class QuoteReader {

    //quote
    protected Quote[] quotes;

    public QuoteReader(String theFile){
        this.quotes = readQuote(theFile);
    }

    //Read and return quotes
    private Quote[] readQuote(String theFile){
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(theFile));
            quotes = gson.fromJson(reader, Quote[].class);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return quotes;
    }

    //Generate random quote
    public String getRandomQuote(){
        int index = new Random().nextInt(quotes.length);
        StringBuilder result = new StringBuilder();
        result.append(quotes[index].getText());
        result.append("\n- " + quotes[index].getAuthor());

        return result.toString();
    }

    public Quote[] getQuotes() {
        return quotes;
    }
}
