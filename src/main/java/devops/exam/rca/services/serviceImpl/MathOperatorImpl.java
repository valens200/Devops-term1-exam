package devops.exam.rca.services.serviceImpl;

import devops.exam.rca.exceptions.InvalidOperationException;
import devops.exam.rca.services.IMathOperator;
import org.springframework.stereotype.Service;

@Service
public class MathOperatorImpl implements IMathOperator {


    @Override
    public Double doMath(Double operand1, Double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }
        switch (operation){
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            default:
                throw new RuntimeException("Unknown operation");
        }
    }
}
