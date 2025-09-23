package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.UserConstant.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDTO {

    @Null(message = USER_ID_MUST_BE_BLANK)
    private String id;

    @NotNull(message = USER_FIRST_NAME_IS_BLANK)
    private String firstName;

    @NotNull(message = USER_LAST_NAME_IS_BLANK)
    private String lastName;

    @NotNull(message = USER_EMAIL_ADDRESS_IS_INVALID)
    private String emailAddress;

    @NotNull(message = USER_PHONE_NUMBER_IS_INVALID)
    private String phoneNumber;

    @NotNull(message = USER_AGE_IS_INVALID)
    private Integer age;
}
