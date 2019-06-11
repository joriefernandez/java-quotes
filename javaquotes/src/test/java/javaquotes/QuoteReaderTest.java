package javaquotes;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
public class QuoteReaderTest {


    @Test
    public void testRandomQuote(){
        QuoteReader test = new QuoteReader();
        assertNotNull("Should contain quotes", test.getRandomQuote());
    }
}