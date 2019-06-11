package javaquotes;

import java.util.ArrayList;
import java.util.List;

public class Quote {
    //tags
    private List<String> tags;
    //author
    private String author;
    //likes
    private  String likes;
    //text
    private String text;

    //Constructor
    public Quote(List<String> tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    //Constructor
    public Quote(String author, String text) {
        this.tags = new ArrayList<>();
        this.author = author;
        this.text = text;
        this.likes = "0 likes";
    }


    //Getters
    public List<String> getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }

    public String getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }
}
