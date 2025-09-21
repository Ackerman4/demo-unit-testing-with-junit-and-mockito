package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.ErrorType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;

public class UserAlreadyExistsException extends BaseException {
    public UserAlreadyExistsException(ErrorType errorType) {
        super(errorType);
    }
}
