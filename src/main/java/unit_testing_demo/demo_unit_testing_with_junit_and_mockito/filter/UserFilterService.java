package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.filter;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDto.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserAlreadyExistsException;

public interface UserFilterService {
    void filterForUserCreation(UserCreateRequestDTO userCreateRequestDTO);

    void isUserAlreadyExists(String id);

    void isEmailAlreadyExists(String emailAddress) throws UserAlreadyExistsException;

    void isPhoneNumberAlreadyExists(String phoneNumber) throws UserAlreadyExistsException;
}
