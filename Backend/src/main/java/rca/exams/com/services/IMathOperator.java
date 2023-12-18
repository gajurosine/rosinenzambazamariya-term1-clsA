package Backend.src.main.java.rca.exams.com.services;

import Backend.src.main.java.rca.exams.com.serviceImpls.InvalidOperationException;

public interface IMathOperator {

    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException, InvalidOperationException;
}
