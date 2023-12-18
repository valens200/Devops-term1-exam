package devops.exam.rca.controllers;
import devops.exam.rca.exceptions.InvalidOperationException;
import devops.exam.rca.models.dtos.CalcResponseDTO;
import devops.exam.rca.models.dtos.DoMathRequestDTO;
import devops.exam.rca.services.IMathOperator;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/math")
public class MathController {

    private IMathOperator mathOperator;

    @Autowired
    public MathController(IMathOperator mathOperator){
        this.mathOperator = mathOperator;
    }
    @PostMapping("do-math")
    public ResponseEntity<?> doMath(@RequestBody() @Valid DoMathRequestDTO dto ) {
        try{
            if(dto.getOperand1() == null || dto.getOperand2() == null ) throw  new BadRequestException("No one of operands should be null");
            Double result = this.mathOperator.doMath(dto.getOperand1(),dto.getOperand2(),dto.getOperation());
            CalcResponseDTO calcResponseDTO = new CalcResponseDTO(result);
            return ResponseEntity.ok(calcResponseDTO);
        }catch (BadRequestException badRequestException) {
            return ResponseEntity.badRequest().body(badRequestException.getMessage());
        }catch (InvalidOperationException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
