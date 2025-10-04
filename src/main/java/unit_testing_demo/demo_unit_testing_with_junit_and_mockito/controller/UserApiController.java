package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.Response;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDto.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserNotFoundException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.orchestration.UserOrchestrationService;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserApiController {

    private final UserOrchestrationService userOrchestrationService;

    @PostMapping("/")
    public ResponseEntity<Response> addUser(@Valid @RequestBody UserCreateRequestDTO userCreateRequestDTO) throws BaseException {
        log.info("UserApiController: Request Received for addUser: {}", userCreateRequestDTO);
        return ResponseEntity.ok()
                .body(userOrchestrationService.addUser(userCreateRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getUserById(@PathVariable String id) throws UserNotFoundException {
        log.info("UserApiController: Request Received for getUserById: {}", id);
        return ResponseEntity.ok()
                .body(userOrchestrationService.getUserById(id));
    }

    @GetMapping("/user-email-address/")
    public ResponseEntity<Response> getUserByEmailAddress(@RequestParam String emailAddress) throws UserNotFoundException {
        log.info("UserApiController: Request Received for getUserByEmailAddress: {}", emailAddress);
        return ResponseEntity.ok()
                .body(userOrchestrationService.getUserByEmailAddress(emailAddress));
    }

    @GetMapping("/user-phone-number/")
    public ResponseEntity<Response> getUserByPhoneNumber(@RequestParam String phoneNumber) throws UserNotFoundException {
        log.info("UserApiController: Request Received for getUserByPhoneNumber: {}", phoneNumber);
        return ResponseEntity.ok()
                .body(userOrchestrationService.getUserByEmailAddress(phoneNumber));
    }
}
