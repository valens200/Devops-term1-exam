package devops.exam.rca.services;

import devops.exam.rca.exceptions.InvalidOperationException;
import devops.exam.rca.services.serviceImpl.MathOperatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

@ExtendWith(MockitoExtension.class)
public class MathServiceTest {

    @InjectMocks
    private MathOperatorImpl mathOperatorService;

    private double operand1 = 4;
    private double operand2 = 9;
    private String operation = "+";

    @DataProvider

    @Test
    public void two_operands_when_added_return_sum() throws InvalidOperationException {
        double actualMathOperator = mathOperatorService.doMath(operand1, operand2, operation);
        Assert.assertEquals(actualMathOperator,13.0);
    }
    @Test
    public  void number_divided_with_zero_return_exception() throws InvalidOperationException {
        org.junit.Assert.assertThrows("You can't devide by zero ",InvalidOperationException.class,() -> mathOperatorService.doMath(4.0, 0.0, "/"));
    }

    @Test void two_numbers_multiplied_return_product() throws InvalidOperationException {
        Assert.assertEquals(mathOperatorService.doMath(4.0, 4.0, "*"),16.0);
    }

    @Test void two_numbers_added_return_sum() throws InvalidOperationException {
        Assert.assertEquals(mathOperatorService.doMath(4.0, 4.0, "+"),8.0);
    }
    @Test void two_numbers_devided_return_quotient() throws InvalidOperationException {
        Assert.assertEquals(mathOperatorService.doMath(4.0, 4.0, "/"),1.0);
    }
}
