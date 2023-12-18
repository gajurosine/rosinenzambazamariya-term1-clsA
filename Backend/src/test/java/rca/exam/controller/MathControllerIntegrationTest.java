package Backend.src.test.java.rca.exam.controller;

import org.example.dto.DoMathRequest;
import org.example.service.MathOperator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class MathControllerIntegrationTest<DoMathRequest> {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MathOperator mathOperator;

    @Test
    void testDoMath_endpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(6, 5, "*");
        when(mathOperator.doMath(5, 4, "*")).thenReturn(90.0);

        Object MediaType ;
        mockMvc.perform(MockMvcRequestBuilders.post("/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"operand1\": 4, \"operand2\": 1, \"operation\": \"*\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.calcResponse").value(90.0));
    }

    // Add more test cases for other scenarios
}
