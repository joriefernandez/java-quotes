package javaquotes;

public class QuoteAPI {
    //quote text
    private String quoteText;
    //author
    private String quoteAuthor;

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public QuoteAPI(String quoteText, String quoteAuthor){
        this.quoteAuthor = quoteAuthor;
        this.quoteText = quoteText;
    }

    //to string
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(quoteText);
        result.append("\n- " + quoteAuthor);

        return result.toString();
    }


}
