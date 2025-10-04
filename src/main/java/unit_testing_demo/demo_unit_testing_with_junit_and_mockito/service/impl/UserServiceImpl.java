package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.create.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserNotFoundException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper.UserMapper;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.repository.UserRepository;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.service.UserService;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.filter.UserFilterService;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator.UserValidatorService;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.UserErrorType.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserValidatorService userValidatorService;

    @Override
    public UserResponseDTO addUser(UserCreateRequestDTO userCreateRequestDTO) throws BaseException {
        log.info("UserService: Request received in addUser: {}", userCreateRequestDTO);
        userValidatorService.validateForUserCreation(userCreateRequestDTO);
        User addedUser = userRepository.save(UserMapper.toNewUser(userCreateRequestDTO));
        return UserMapper.toUserResponseDTO(addedUser);
    }

    @Override
    public UserResponseDTO getUserById(String id) throws UserNotFoundException {
        log.info("UserService: Request received in getUserById: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_ERROR));
        return UserMapper.toUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO getUserByEmailAddress(String emailAddress) throws UserNotFoundException {
        log.info("UserService: Request received in getUserByEmailAddress: {}", emailAddress);
        User user = userRepository.findByEmailAddress(emailAddress)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_ERROR));
        return UserMapper.toUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO getUserByPhoneNumber(String phoneNumber) throws UserNotFoundException {
        log.info("UserService: Request received in getUserByPhoneNumber: {}", phoneNumber);
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_ERROR));
        return UserMapper.toUserResponseDTO(user);
    }
}
