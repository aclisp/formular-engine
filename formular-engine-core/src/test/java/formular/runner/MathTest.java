package formular.runner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import formular.engine.Default;
import formular.engine.Environment;

public class MathTest {
    private Environment env;

    @BeforeEach
    public void setUp() {
        env = Default.environment();
    }

    @Test
    public void testAbs() throws Exception {
        assertEquals(3, Runner.execute("(abs 3)", env).getValue());
        assertEquals(3, Runner.execute("(abs -3)", env).getValue());
        assertEquals(1.3, Runner.execute("(abs 1.3)", env).getValue());
        assertEquals(3.1, Runner.execute("(abs -3.1)", env).getValue());
        assertEquals(3.141592653589793238462643383279502884197169399375105820974944592307816406286, Runner.execute("(abs -3.141592653589793238462643383279502884197169399375105820974944592307816406286)", env).getValue());
    }

    @Test
    public void testPow() throws Exception {
        assertEquals(343, Runner.execute("(pow 7 3)", env).getValue());
        assertEquals(256, Runner.execute("(pow 2 8)", env).getValue());
        try {
            assertEquals(2, Runner.execute("(pow 4 0.5)", env).getValue());
            fail("Rounding necessary");
        } catch (ArithmeticException ex) {
            // Should fail
        }
        try {
            assertEquals(1/49, Runner.execute("(pow 7 -2)", env).getValue());
            fail("Invalid operation");
        } catch (ArithmeticException ex) {
            // Should fail
        }
    }

    @Test
    public void testCeiling() throws Exception {
        assertEquals(3, Runner.execute("(ceiling 2.5)", env).getValue());
        assertEquals(-2, Runner.execute("(ceiling -2.5)", env).getValue());
    }

    @Test
    public void testFloor() throws Exception {
        assertEquals(2, Runner.execute("(floor 2.5)", env).getValue());
        assertEquals(-3, Runner.execute("(floor -2.5)", env).getValue());
    }

    @Test
    public void testMax() throws Exception {
        assertEquals(5, Runner.execute("(max 1 2 3 4 5)", env).getValue());
        assertEquals(5, Runner.execute("(max 1 2 5 4 3)", env).getValue());
    }

    @Test
    public void testMin() throws Exception {
        assertEquals(1, Runner.execute("(min 1 2 3 4 5)", env).getValue());
        assertEquals(2, Runner.execute("(min 6 2 5 4 3)", env).getValue());
    }

    @Test
    public void testRound() throws Exception {
        assertEquals(2, Runner.execute("(round 1.5 0)", env).getValue());
        assertEquals(1, Runner.execute("(round 1.2345 0)", env).getValue());
        assertEquals(1.23, Runner.execute("(round 1.2345 2)", env).getValue());
        assertEquals(1.235, Runner.execute("(round 1.2345 3)", env).getValue());
        assertEquals(1.2345, Runner.execute("(round 1.2345 4)", env).getValue());
        assertEquals(1.24, Runner.execute("(round 1.2355 2)", env).getValue());
        assertEquals(-2, Runner.execute("(round -1.5 0)", env).getValue());
        assertEquals(225.50, Runner.execute("(round 225.49823 2)", env).getValue());
    }
}
