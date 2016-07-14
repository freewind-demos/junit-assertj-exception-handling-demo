package demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloTest {

    private Hello hello;

    @Before
    public void setUp() throws Exception {
        hello = new Hello();
    }

    @Test
    public void shouldGreetingWithPassingName() throws Exception {
        assertEquals(hello.greeting("Freewind"), "Hello, Freewind!");
    }

}
