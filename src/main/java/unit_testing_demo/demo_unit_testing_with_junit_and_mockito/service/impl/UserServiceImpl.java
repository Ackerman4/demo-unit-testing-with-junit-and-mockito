package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserAlreadyExistsException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserNotFoundException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper.UserMapper;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.repository.UserRepository;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.service.UserService;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator.UserValidatorService;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.UserConstant.*;
import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.UserErrorType.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserValidatorService userValidatorService;

    @Override
    public UserResponseDTO addUser(UserCreateRequestDTO userCreateRequestDTO) throws BaseException {
        log.info("UserService: Request received in addUser");
        this.filterFields(userCreateRequestDTO);
        User addedUser = userRepository.save(UserMapper.toNewUser(userCreateRequestDTO));
        return UserMapper.toUserResponseDTO(addedUser);
    }

    @Override
    public UserResponseDTO getUserById(String id) throws UserNotFoundException {
        log.info("UserService: Request received in getUserById");
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(UE_000));
        return UserMapper.toUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO getUserByEmailAddress(String emailAddress) throws UserNotFoundException {
        log.info("UserService: Request received in getUserByEmailAddress");
        User user = userRepository.findByEmailAddress(emailAddress).orElseThrow(() -> new UserNotFoundException(UE_000));
        return UserMapper.toUserResponseDTO(user);
    }

    private void filterFields(UserCreateRequestDTO userCreateRequestDTO) throws BaseException {
        boolean isUserAlreadyExists = Boolean.TRUE.equals(userValidatorService.validateUserDetailsForCreation(userCreateRequestDTO));
        if (isUserAlreadyExists) throw new UserAlreadyExistsException(UE_002);
        boolean isEmailAddressValid = userValidatorService.hasValidEmailAddress(userCreateRequestDTO.getEmailAddress());
        if (!isEmailAddressValid) throw new IllegalArgumentException(USER_EMAIL_ADDRESS_IS_INVALID);
        boolean isPhoneNumberValid = userValidatorService.hasValidPhoneNumber(userCreateRequestDTO.getPhoneNumber());
        if (!isPhoneNumberValid) throw new IllegalArgumentException(USER_PHONE_NUMBER_IS_INVALID);
    }
}
