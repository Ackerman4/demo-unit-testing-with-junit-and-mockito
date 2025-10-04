package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDto.UserCreateRequestDTO;

public interface UserValidatorService {
    void validateForUserCreation(UserCreateRequestDTO userCreateRequestDTO);

    Boolean validateEmailAddress(String emailAddress);

    Boolean validatePhoneNumber(String phoneNumber);
}
