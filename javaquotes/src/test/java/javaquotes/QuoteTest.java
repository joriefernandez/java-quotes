package javaquotes;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
public class QuoteTest {
    @Test
    public void testQuote(){
        List<String> sampleTag = new LinkedList<>();
        sampleTag.add("sample tag");
        Quote test = new Quote(sampleTag, "MarkTwain", "20 likes", "Random text" );
        assertEquals("Quote tag should be the same.", sampleTag, test.getTags());
        assertEquals("Quote author should be the same.", "MarkTwain", test.getAuthor());
        assertEquals("Quote likes should be the same.", "20 likes", test.getLikes());
        assertEquals("Quote text should be the same.", "Random text", test.getText());
    }
}
