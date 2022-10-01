package pizza.project.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValidatorDto {

    private String field;
    private String message;
}
