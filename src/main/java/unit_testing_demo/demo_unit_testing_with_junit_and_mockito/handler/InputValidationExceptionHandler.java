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
                BusinessErrorType.BE_001.getErrorCode(),
                exception.getMessage(),
                BusinessErrorType.BE_001.getStatus());
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
                BusinessErrorType.BE_000.getErrorCode(),
                errorsMessage,
                BusinessErrorType.BE_000.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
