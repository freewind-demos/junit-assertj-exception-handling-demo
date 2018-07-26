package demo;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.startsWith;

public class HelloTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        throw new IllegalArgumentException("testing");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithMessage() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("testing");
        throw new IllegalArgumentException("testing");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionAndCheckMessagePattern() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage(startsWith("testing"));
        throw new IllegalArgumentException("testing 23423!");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionAndCheckMessageWithCustomPattern() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage(new BaseMatcher<String>() {
            public boolean matches(Object item) {
                String message = ((String) item);
                return message.startsWith("testing ") && message.endsWith("!");
            }
            public void describeTo(Description description) {
            }
        });
        throw new IllegalArgumentException("testing 23423!");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithCause() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectCause(new BaseMatcher<NullPointerException>() {
            public void describeTo(Description description) {
            }
            public boolean matches(Object item) {
                if (item instanceof NullPointerException) {
                    NullPointerException cause = (NullPointerException) item;
                    return cause.getMessage().equals("testing-null");
                } else {
                    return false;
                }
            }
        });
        throw new IllegalArgumentException("testing", new NullPointerException("testing-null"));
    }

}
