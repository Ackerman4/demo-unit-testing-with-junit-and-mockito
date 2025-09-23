package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO.UserCreateRequestDTO;

public interface UserValidatorService {
    Boolean validateUserDetailsForCreation(UserCreateRequestDTO userCreateRequestDTO);

    Boolean isUserAlreadyExists(String id);

    Boolean isEmailAlreadyExists(String emailAddress);

    Boolean hasValidEmailAddress(String emailAddress);

    Boolean hasValidPhoneNumber(String phoneNumber);
}
