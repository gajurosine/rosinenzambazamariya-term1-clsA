package Backend.src.test.java.rca.exam.controller;

import org.example.dto.DoMathRequest;
import org.example.service.MathOperator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MathControllerEndToEndTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private MathOperator mathOperator;

    @Test
    void testDoMath_endpoint() throws Exception {
        DoMathRequest request = new DoMathRequest(5, 4, "*");
        when(mathOperator.doMath(5, 4, "*")).thenReturn(20.0);

        webTestClient.post()
                .uri("/doMath")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
    }
