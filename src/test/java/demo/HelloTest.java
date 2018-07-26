package demo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        throw new IllegalArgumentException("testing");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWithMessageAndCause() {
        assertThatThrownBy(() -> hello())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("testing")
                .hasCause(new NullPointerException("testing-null"));
    }

    private void hello() {
        throw new IllegalArgumentException("testing", new NullPointerException("testing-null"));
    }

}
