package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.repository.UserRepository;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.validator.UserValidatorService;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserValidatorServiceImpl implements UserValidatorService {

    private final UserRepository userRepository;

    @Override
    public Boolean userValidateForCreation(UserCreateRequestDTO userCreateRequestDTO) {
        log.info("UserValidatorService: Validating user resource in userValidationFacade");
        return validateIfEmailAddressAlreadyExists(userCreateRequestDTO.getEmailAddress());
    }

    @Override
    public Boolean validateIfUserExists(String id) {
        return userRepository.findById(id).isPresent();
    }

    @Override
    public Boolean validateIfEmailAddressAlreadyExists(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress).isPresent();
    }
}
