package javaquotes;

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
