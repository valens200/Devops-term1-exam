package devops.exam.rca.contollers;


import com.fasterxml.jackson.databind.ObjectMapper;
import devops.exam.rca.controllers.MathController;
import devops.exam.rca.exceptions.InvalidOperationException;
import devops.exam.rca.models.dtos.CalcResponseDTO;
import devops.exam.rca.models.dtos.DoMathRequestDTO;
import devops.exam.rca.services.IMathOperator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(MathController.class)
public class MathCoontrollerEndToEndTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private IMathOperator mathService;

    @Test
    public void doMath() throws Exception {
        ResponseEntity<?> response = ResponseEntity.ok().body(new CalcResponseDTO(1.0));

        DoMathRequestDTO dto = new DoMathRequestDTO(4.0,4.0,"/");
        when(mathService.doMath(dto.getOperand1(),dto.getOperand2(),dto.getOperation())).thenReturn(1.0);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/api/v1/math/do-math")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto));
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }
}
