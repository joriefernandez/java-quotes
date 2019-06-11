package javaquotes;

import org.junit.Test;


import static org.junit.Assert.*;
public class QuoteAPITest {
    @Test
    public void testQuote(){

        QuoteAPI test = new QuoteAPI("Random text", "random author" );
        assertEquals("Quote author should be the same.", "random author", test.getQuoteAuthor());
        assertEquals("Quote text should be the same.", "Random text", test.getQuoteText());
    }

    @Test
    public void testQuoteToString(){

        QuoteAPI test = new QuoteAPI("Random text", "random author" );
        String expected = "Random text\n- random author";
        assertEquals("Quote text should be the same.", expected, test.toString());
    }
}