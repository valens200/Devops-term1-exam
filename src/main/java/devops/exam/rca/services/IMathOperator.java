package devops.exam.rca.services;

import devops.exam.rca.exceptions.InvalidOperationException;

public interface IMathOperator {
    public Double doMath(Double operand1, Double operand2 , String operation) throws InvalidOperationException;
}
