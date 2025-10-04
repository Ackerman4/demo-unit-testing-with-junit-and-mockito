package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.filter.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dao.UserDAO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.create.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserAlreadyExistsException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.filter.UserFilterService;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.UserErrorType.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserFilterServiceImpl implements UserFilterService {

    private final UserDAO userDAO;

    @Override
    public void filterForUserCreation(UserCreateRequestDTO userCreateRequestDTO) {
        log.info("UserValidatorService: Filtering user resource in filterForUserCreation: {}", userCreateRequestDTO);
        checkIfEmailAddressAlreadyExists(userCreateRequestDTO.getEmailAddress());
        checkIfPhoneNumberAlreadyExists(userCreateRequestDTO.getPhoneNumber());
    }

    @Override
    public void checkIfUserAlreadyExists(String id) {
        boolean isUserAlreadyExists = userDAO.getUserById(id).isPresent();
        if (isUserAlreadyExists) {
            log.error("UserFilterService::isUserAlreadyExists: User already exists, {}", id);
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public void checkIfEmailAddressAlreadyExists(String emailAddress) throws UserAlreadyExistsException {
        boolean isEmailAlreadyExists = userDAO.getUserByEmailAddress(emailAddress).isPresent();
        if (isEmailAlreadyExists) {
            log.error("UserFilterService::isEmailAlreadyExists: User already exists, {}", emailAddress);
            throw new UserAlreadyExistsException(USER_EMAIL_ADDRESS_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public void checkIfPhoneNumberAlreadyExists(String phoneNumber) throws UserAlreadyExistsException {
        boolean isPhoneNumberAlreadyExists = userDAO.getUserByPhoneNumber(phoneNumber).isPresent();
        if (isPhoneNumberAlreadyExists) {
            log.error("UserFilterService::isPhoneNumberAlreadyExists: User already exists, {}", phoneNumber);
            throw new UserAlreadyExistsException(USER_PHONE_NUMBER_ALREADY_EXISTS_ERROR);
        }
    }
}
