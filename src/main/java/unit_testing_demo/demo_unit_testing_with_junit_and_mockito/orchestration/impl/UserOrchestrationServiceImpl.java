package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.orchestration.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.Response;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors.SystemErrorType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.user.UserNotFoundException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.orchestration.UserOrchestrationService;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.service.UserService;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper.ErrorResponseMapper;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper.SuccessResponseMapper;

import java.util.Objects;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.success.UserSuccessType.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOrchestrationServiceImpl implements UserOrchestrationService {

    private final UserService userService;

    @Override
    public Response addUser(UserCreateRequestDTO userCreateRequestDTO) throws BaseException {
        log.info("UserOrchestrationService: Request received in addUser");
        UserResponseDTO userResponseDTO = userService.addUser(userCreateRequestDTO);
        return (Objects.nonNull(userResponseDTO)) ? SuccessResponseMapper.toSuccessResponse(ADD_USER_SUCCESS, userResponseDTO) :
                ErrorResponseMapper.toErrorResponse(SystemErrorType.SYSTEM_ERROR_INTERNAL_SERVER_ERROR);
    }

    @Override
    public Response getUserById(String id) throws UserNotFoundException {
        log.info("UserOrchestrationService: Request received in getUserById");
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return SuccessResponseMapper.toSuccessResponse(FETCH_USER_SUCCESS, userResponseDTO);
    }

    @Override
    public Response getUserByEmailAddress(String emailAddress) throws UserNotFoundException {
        log.info("UserOrchestrationService: Request received in getUserByEmailAddress");
        UserResponseDTO userResponseDTO = userService.getUserByEmailAddress(emailAddress);
        return SuccessResponseMapper.toSuccessResponse(FETCH_USER_SUCCESS, userResponseDTO);
    }
}
