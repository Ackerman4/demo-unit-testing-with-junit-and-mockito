package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Response {
    private String code;
    private String message;
    private Boolean status;
}
