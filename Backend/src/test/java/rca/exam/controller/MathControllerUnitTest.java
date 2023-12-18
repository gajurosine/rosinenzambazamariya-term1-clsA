package Backend.src.test.java.rca.exam.controller;

import Backend.src.main.java.rca.exams.com.controllers.MathController;
import org.example.dto.DoMathRequest;
import org.example.exception.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class MathControllerUnitTest {

    @Mock
    private MathOperator mathOperator;

    @InjectMocks
    private MathController mathController;

    @Test
    void testDoMath() throws InvalidOperationException {
        DoMathRequest request = new DoMathRequest(5, 4, "*");
        when(mathOperator.doMath(5, 4, "*")).thenReturn(20.0);

        ApiResponse response = mathController.doMath(request);

        assertEquals(20.0, response.getCalcResponse());
        verify(mathOperator, times(1)).doMath(5, 4, "*");
    }

    private class MathOperator {
    }

    private class InvalidOperationException extends Exception {
    }

    private class DoMathRequest {
        public DoMathRequest(int i, int i1, String s) {
        }
    }

    // Add more test cases for other scenarios
}
