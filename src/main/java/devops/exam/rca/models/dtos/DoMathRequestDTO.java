package devops.exam.rca.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DoMathRequestDTO {
    @JsonProperty
    @NotNull
    private Double operand1;
    @JsonProperty
    @NotNull
    private Double operand2;
    @JsonProperty
    @NotNull
    private String operation;
}
