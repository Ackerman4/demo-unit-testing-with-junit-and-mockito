package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.ErrorResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.BusinessErrorType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper.ErrorResponseMapper;

import java.util.stream.Collectors;

@ControllerAdvice
public class InputValidationExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException exception) {
        ErrorResponse errorResponse = ErrorResponseMapper.toErrorResponse(
                BusinessErrorType.BUSINESS_ERROR_INVALID_INPUT.getErrorCode(),
                exception.getMessage(),
                BusinessErrorType.BUSINESS_ERROR_INVALID_INPUT.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String errorsMessage = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(field -> field.getField() + ": " + field.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorResponse errorResponse = ErrorResponseMapper.toErrorResponse(
                BusinessErrorType.BUSINESS_ERROR_MISSING_PARAMETER.getErrorCode(),
                errorsMessage,
                BusinessErrorType.BUSINESS_ERROR_MISSING_PARAMETER.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
