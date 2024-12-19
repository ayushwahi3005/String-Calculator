import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(4, calculator.add("1,3"));
    }
    @Test
    public void testMultipleNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.add("1,2,3,4"));
    }
    @Test
    public void testNewlineDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }
    @Test
    public void testCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("1,-2,3,-4"));
        assertEquals("negative numbers not allowed -2, -4", exception.getMessage());
    }


}
