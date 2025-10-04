package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.orchestration;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.Response;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDto.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserNotFoundException;

public interface UserOrchestrationService {
    Response addUser(UserCreateRequestDTO userCreateRequestDTO) throws BaseException;

    Response getUserById(String id) throws UserNotFoundException;

    Response getUserByEmailAddress(String emailAddress) throws UserNotFoundException;

    Response getUserByPhoneNumber(String phoneNumber) throws UserNotFoundException;
}
