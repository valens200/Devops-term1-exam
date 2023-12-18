package devops.exam.rca.contollers;

import devops.exam.rca.exceptions.InvalidOperationException;
import devops.exam.rca.models.dtos.DoMathRequestDTO;
import devops.exam.rca.services.IMathOperator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MathControllerIntegrationTest {

    private IMathOperator mathOperatorService;
    private static RestTemplate restTemplate;

    @BeforeAll

    public static void initializeVariables(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void two_operands_when_added_return_sum() throws InvalidOperationException {
        DoMathRequestDTO mathRequestDTO = new DoMathRequestDTO(4.0,4.0,"/");
        ResponseEntity<?> response = restTemplate.exchange(
                "http://localhost:8080/api/v1/math/do-math",
                HttpMethod.POST,
                new HttpEntity<>(mathRequestDTO, null),
                DoMathRequestDTO.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
