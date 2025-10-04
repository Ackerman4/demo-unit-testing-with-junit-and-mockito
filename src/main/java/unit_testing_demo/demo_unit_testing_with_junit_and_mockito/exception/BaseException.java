package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception;

import lombok.Getter;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.ErrorType;

@Getter
public class BaseException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;
    private final Boolean status;

    public BaseException(ErrorType errorType) {
        errorCode = errorType.getErrorCode();
        errorMessage = errorType.getErrorMessage();
        status = errorType.getStatus();
    }
}
