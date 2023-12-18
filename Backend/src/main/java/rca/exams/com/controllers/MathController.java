package Backend.src.main.java.rca.exams.com.controllers;

import Backend.src.test.java.rca.exam.controller.MathControllerUnitTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.exams.com.dtos.DoMathRequestDto;
import rca.exams.com.exceptions.InvalidOperationException;
import rca.exams.com.serviceImpls.MathOperatorImpl;

@RestController
@RequestMapping("/api/com/doMath")
public class MathController<ApiResponse> {
    private final MathOperatorImpl mathOperatorImpl;

    public <MathOperatorImpl> MathController(MathOperatorImpl mathOperatorImpl) {
        this.mathOperatorImpl = mathOperatorImpl;
    }

    @PostMapping
    public <ResponseEntity> ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto dto) throws InvalidOperationException {
        Object ResponseEntity = new Object();
        return ResponseEntity.ok(ApiResponse.success(mathOperatorImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }

    public void doMath(MathControllerUnitTest.DoMathRequest request) {
    }
}
