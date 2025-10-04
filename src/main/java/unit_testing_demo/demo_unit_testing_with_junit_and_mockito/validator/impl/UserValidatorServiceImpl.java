package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDto.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.BusinessErrorType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserCreateFailedValidationException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.filter.UserFilterService;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.util.InputValidator;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator.UserValidatorService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserValidatorServiceImpl implements UserValidatorService {

    private final UserFilterService userFilterService;

    @Override
    public void validateForUserCreation(UserCreateRequestDTO userCreateRequestDTO) {
        log.info("UserValidatorService: Validating User Create Request for User Creation: {}", userCreateRequestDTO);
        boolean areFieldsValid = validateEmailAddress(userCreateRequestDTO.getEmailAddress()) && validatePhoneNumber(userCreateRequestDTO.getPhoneNumber());
        if (!areFieldsValid) {
            log.error("UserValidatorService::validateForUserCreation: Failed validations, {}", userCreateRequestDTO);
            throw new UserCreateFailedValidationException(BusinessErrorType.BUSINESS_ERROR_FAILED_VALIDATION_FOR_CREATION);
        }
        userFilterService.filterForUserCreation(userCreateRequestDTO);
    }

    @Override
    public Boolean validateEmailAddress(String emailAddress) {
        return InputValidator.validateEmailAddress(emailAddress);
    }

    @Override
    public Boolean validatePhoneNumber(String phoneNumber) {
        return InputValidator.validatePhoneNumber(phoneNumber);
    }
}
