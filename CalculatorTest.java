import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CalculatorTest
{

    private static final String line_ending = System.lineSeparator();
    private PrintStream std_out;
    private InputStream std_in;
    private ByteArrayOutputStream mock_out;
    private ByteArrayInputStream mock_in;

    private String build_output(String... array)
    {
        StringBuilder builder = new StringBuilder();
        for(String line: array)
        {
            builder.append(line);
            builder.append(line_ending);
        }
        return builder.toString();
    }

    private void set_mock_input(String... array)
    {
        byte[] buffer = build_output(array).getBytes();
        mock_in = new ByteArrayInputStream(buffer);
        System.setIn(mock_in);
    }

    @Before
    public void setUp()
    {
        std_out = System.out;
        std_in = System.in;
        mock_out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mock_out));
    }

    @After
    public void tearDown()
    {
        System.setOut(std_out);
        System.setIn(std_in);
    }

    @Test
    public void test_single_add_1()
    {
        set_mock_input("add 1 1");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "2";
        assertEquals(e, y);
    }

    @Test
    public void test_single_add_2()
    {
        set_mock_input("add 1 2");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "3";
        assertEquals(e, y);
    }

    @Test
    public void test_single_sub_1()
    {
        set_mock_input("sub 2 1");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "1";
        assertEquals(e, y);
    }

    @Test
    public void test_single_sub_2()
    {
        set_mock_input("sub 5 2");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "3";
        assertEquals(e, y);
    }

    @Test
    public void test_single_mul_1()
    {
        set_mock_input("mul 6 7");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "42";
        assertEquals(e, y);
    }

    @Test
    public void test_single_mul_2()
    {
        set_mock_input("mul 2 3");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "6";
        assertEquals(e, y);
    }

    @Test
    public void test_single_div_1()
    {
        set_mock_input("div 5 1");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "5";
        assertEquals(e, y);
    }

    @Test
    public void test_single_div_2()
    {
        set_mock_input("div 42 7");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "6";
        assertEquals(e, y);
    }

    @Test
    public void test_exit()
    {
        set_mock_input("exit");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = "";
        assertEquals(e, y);
    }

    @Test
    public void test_multi()
    {
        set_mock_input("add 5 10", "mul 5 10", "sub 50 10", "div 50 2");
        Calculator.main(new String[]{});
        String y = mock_out.toString().trim();
        String e = build_output("15", "50", "40", "25").trim();
        assertEquals(e, y);
    }


}