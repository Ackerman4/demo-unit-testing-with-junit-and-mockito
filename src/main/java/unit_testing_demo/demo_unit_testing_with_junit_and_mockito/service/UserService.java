package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.service;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDto.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserNotFoundException;

public interface UserService {
    UserResponseDTO addUser(UserCreateRequestDTO userCreateRequestDTO) throws BaseException;

    UserResponseDTO getUserById(String id) throws UserNotFoundException;

    UserResponseDTO getUserByEmailAddress(String emailAddress) throws UserNotFoundException;

    UserResponseDTO getUserByPhoneNumber(String phoneNumber) throws UserNotFoundException;
}
