package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.testDataFactory.response.error;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.ErrorResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.ErrorType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.BusinessErrorType;

public class UserErrorResponseFactory {

    public static ErrorResponse createIdMustBeNullForUserErrorResponse() {
        return ErrorResponse.builder()
                .code(BusinessErrorType.BUSINESS_ERROR_INVALID_INPUT.getErrorCode())
                .message("TEST") // TODO: Change the message.
                .status(BusinessErrorType.BUSINESS_ERROR_INVALID_INPUT.getStatus())
                .build();
    }

    public static ErrorResponse createErrorResponse(ErrorType errorType) {
        return ErrorResponse.builder()
                .code(errorType.getErrorCode())
                .message(errorType.getErrorMessage())
                .status(errorType.getStatus())
                .build();
    }
}
