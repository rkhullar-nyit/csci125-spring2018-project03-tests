import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;

class TestRunner
{

    private static final int max = 20, min = 2;
    private static final HashMap<String, Integer> penalties = new HashMap<>();

    static
    {
        penalties.put("test_single_add_1", 2);
        penalties.put("test_single_add_2", 2);
        penalties.put("test_single_sub_1", 2);
        penalties.put("test_single_sub_2", 2);
        penalties.put("test_single_mul_1", 2);
        penalties.put("test_single_mul_2", 2);
        penalties.put("test_single_div_1", 2);
        penalties.put("test_single_div_2", 2);
        penalties.put("test_exit", 5);
        penalties.put("test_multi", 5);
    }

    public static void main(String[] args)
    {
        Result calculator_result = JUnitCore.runClasses(CalculatorTest.class);
        Result[] results = new Result[]{calculator_result};

        int grade = max;

        for(Result result: results)
        {
            for (Failure failure : result.getFailures())
            {
                String name = failure.getTestHeader().split("[(]")[0];
                System.err.printf("failed test: %s\n", name);
                grade -= penalties.get(name);
            }
        }

        if(grade < min)
            grade = min;

        System.out.println(grade);
    }
}
