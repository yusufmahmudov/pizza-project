package pizza.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private String message;
    private Integer code;
    private Boolean success;
    private T data;
    private List<ValidatorDto> error;

}
