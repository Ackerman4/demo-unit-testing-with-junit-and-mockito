package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.filter.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDto.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserAlreadyExistsException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.filter.UserFilterService;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.repository.UserRepository;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.UserErrorType.*;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserFilterServiceImpl implements UserFilterService {

    private final UserRepository userRepository;

    @Override
    public void filterForUserCreation(UserCreateRequestDTO userCreateRequestDTO) {
        log.info("UserValidatorService: Filtering user resource in filterForUserCreation: {}", userCreateRequestDTO);
        isEmailAlreadyExists(userCreateRequestDTO.getEmailAddress());
        isPhoneNumberAlreadyExists(userCreateRequestDTO.getPhoneNumber());
    }

    @Override
    public void isUserAlreadyExists(String id) {
        boolean isUserAlreadyExists = userRepository.findById(id).isPresent();
        if (isUserAlreadyExists) {
            log.error("UserFilterService::isUserAlreadyExists: User already exists, {}", id);
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public void isEmailAlreadyExists(String emailAddress) throws UserAlreadyExistsException {
        boolean isEmailAlreadyExists = userRepository.findByEmailAddress(emailAddress).isPresent();
        if (isEmailAlreadyExists) {
            log.error("UserFilterService::isEmailAlreadyExists: User already exists, {}", emailAddress);
            throw new UserAlreadyExistsException(USER_EMAIL_ADDRESS_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public void isPhoneNumberAlreadyExists(String phoneNumber) throws UserAlreadyExistsException {
        boolean isPhoneNumberAlreadyExists = userRepository.findByPhoneNumber(phoneNumber).isPresent();
        if (isPhoneNumberAlreadyExists) {
            log.error("UserFilterService::isPhoneNumberAlreadyExists: User already exists, {}", phoneNumber);
            throw new UserAlreadyExistsException(USER_PHONE_NUMBER_ALREADY_EXISTS_ERROR);
        }
    }
}
