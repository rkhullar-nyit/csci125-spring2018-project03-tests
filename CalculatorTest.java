import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends MockIOTest
{

    @Test
    public void test_single_add_1()
    {
        set_mock_input("add 1 1", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "2";
        assertEquals(e, y);
    }

    @Test
    public void test_single_add_2()
    {
        set_mock_input("add 1 2", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "3";
        assertEquals(e, y);
    }

    @Test
    public void test_single_sub_1()
    {
        set_mock_input("sub 2 1", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "1";
        assertEquals(e, y);
    }

    @Test
    public void test_single_sub_2()
    {
        set_mock_input("sub 5 2", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "3";
        assertEquals(e, y);
    }

    @Test
    public void test_single_mul_1()
    {
        set_mock_input("mul 6 7", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "42";
        assertEquals(e, y);
    }

    @Test
    public void test_single_mul_2()
    {
        set_mock_input("mul 2 3", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "6";
        assertEquals(e, y);
    }

    @Test
    public void test_single_div_1()
    {
        set_mock_input("div 5 1", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "5";
        assertEquals(e, y);
    }

    @Test
    public void test_single_div_2()
    {
        set_mock_input("div 42 7", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "6";
        assertEquals(e, y);
    }

    @Test
    public void test_exit()
    {
        set_mock_input("exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = "";
        assertEquals(e, y);
    }

    @Test
    public void test_multi()
    {
        set_mock_input("add 5 10", "mul 5 10", "sub 50 10", "div 50 2", "exit");
        Calculator.main(new String[]{});
        String y = get_mock_output();
        String e = build_output("15", "50", "40", "25");
        assertEquals(e, y);
    }


}