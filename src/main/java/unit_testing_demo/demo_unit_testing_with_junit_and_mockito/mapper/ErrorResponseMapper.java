package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper;

import org.springframework.stereotype.Component;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.ErrorResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.ErrorType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;

@Component
public class ErrorResponseMapper {
    public static ErrorResponse toErrorResponse(BaseException exception) {
        return ErrorResponse.builder()
                .code(exception.getErrorCode())
                .message(exception.getErrorMessage())
                .status(exception.getStatus())
                .build();
    }

    public static ErrorResponse toErrorResponse(ErrorType errorType) {
        return ErrorResponse.builder()
                .code(errorType.getErrorCode())
                .message(errorType.getErrorMessage())
                .status(errorType.getStatus())
                .build();
    }

    public static ErrorResponse toErrorResponse(String errorCode, String errorMessage, Boolean status) {
        return ErrorResponse.builder()
                .code(errorCode)
                .message(errorMessage)
                .status(status)
                .build();
    }

    private ErrorResponseMapper() {}
}
