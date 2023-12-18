package devops.exam.rca.services;

import devops.exam.rca.exceptions.InvalidOperationException;
import devops.exam.rca.services.serviceImpl.MathOperatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.Assert;

@ExtendWith(MockitoExtension.class)
public class MathServiceTest {

    @InjectMocks
    private MathOperatorImpl mathOperatorService;

    @Test
    public void two_operands_when_added_return_sum() throws InvalidOperationException {
        double operand1 = 4;
        double operand2 = 9;
        String operation = "+";
//        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(mathOperation);
        double actualMathOperator = mathOperatorService.doMath(operand1, operand2, operation);

        Assert.assertEquals(actualMathOperator,13.0);

    }
}
