package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserAlreadyExistsException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserNotFoundException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.repository.UserRepository;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.service.UserService;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.util.UserUtil;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator.UserValidatorService;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.UserErrorType.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserValidatorService userValidatorService;

    @Override
    public UserResponseDTO addUser(UserCreateRequestDTO userCreateRequestDTO) throws UserAlreadyExistsException {
        log.info("UserService: Request received in addUser");
        if (Boolean.TRUE.equals(userValidatorService.userValidateForCreation(userCreateRequestDTO)))
            throw new UserAlreadyExistsException(UE_002);
        User addedUser = userRepository.save(UserUtil.buildNewUser(userCreateRequestDTO));
        return UserUtil.buildUserResponseDTO(addedUser);
    }

    @Override
    public UserResponseDTO getUserById(String id) throws UserNotFoundException {
        log.info("UserService: Request received in getUserById");
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(UE_000));
        return UserUtil.buildUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO getUserByEmailAddress(String emailAddress) throws UserNotFoundException {
        log.info("UserService: Request received in getUserByEmailAddress");
        User user = userRepository.findByEmailAddress(emailAddress).orElseThrow(() -> new UserNotFoundException(UE_000));
        return UserUtil.buildUserResponseDTO(user);
    }
}
