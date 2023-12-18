package devops.exam.rca.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
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
