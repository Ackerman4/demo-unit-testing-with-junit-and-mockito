package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.filter;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.create.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserAlreadyExistsException;

public interface UserFilterService {
    void filterForUserCreation(UserCreateRequestDTO userCreateRequestDTO);

    void checkIfUserAlreadyExists(String id);

    void checkIfEmailAddressAlreadyExists(String emailAddress) throws UserAlreadyExistsException;

    void checkIfPhoneNumberAlreadyExists(String phoneNumber) throws UserAlreadyExistsException;
}
