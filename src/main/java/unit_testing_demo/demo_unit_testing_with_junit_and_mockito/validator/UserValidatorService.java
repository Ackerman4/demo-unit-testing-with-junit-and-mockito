package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO.UserCreateRequestDTO;

public interface UserValidatorService {
    Boolean userValidateForCreation(UserCreateRequestDTO userCreateRequestDTO);

    Boolean validateIfUserExists(String id);

    Boolean validateIfEmailAddressAlreadyExists(String emailAddress);
}
