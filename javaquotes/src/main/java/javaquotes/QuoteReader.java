package javaquotes;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;


public class QuoteReader {

    //quote
    private Quote[] quotes;

    //Read and return quotes
    public Quote[] readQuote(String theFile){
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(theFile));
            quotes = gson.fromJson(reader, Quote[].class);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return quotes;
    }

}
