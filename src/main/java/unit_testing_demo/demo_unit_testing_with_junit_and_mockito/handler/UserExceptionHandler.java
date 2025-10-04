package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.ErrorResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserAlreadyExistsException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserCreateFailedValidationException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserNotFoundException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper.ErrorResponseMapper;

@ControllerAdvice
@RequiredArgsConstructor
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponseMapper.toErrorResponse(exception);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        ErrorResponse errorResponse = ErrorResponseMapper.toErrorResponse(exception);
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserCreateFailedValidationException.class)
    public ResponseEntity<ErrorResponse> handleUserCreateFailedValidationException(UserCreateFailedValidationException exception) {
        ErrorResponse errorResponse = ErrorResponseMapper.toErrorResponse(exception);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
