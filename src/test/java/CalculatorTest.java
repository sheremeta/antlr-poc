import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    @Test
    public void eval() {
        double result = Calculator.eval("(1 + 5) / 2 + (2 * (3 + 2))");

        assertThat(result, is(13.0));
    }
}