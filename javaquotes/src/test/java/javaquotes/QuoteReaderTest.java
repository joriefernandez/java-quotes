package javaquotes;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
public class QuoteReaderTest {

    private static final String TESTFILE = "src/test/resources/test.json";

    @Test
    public void testRandomQuote(){
        QuoteReader test = new QuoteReader(TESTFILE);
        String expected = " “I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to " +
                "find someone to love.” " + "\n- Marilyn Monroe";
        assertEquals("Should contain quotes", expected, test.getRandomQuote());
    }
}