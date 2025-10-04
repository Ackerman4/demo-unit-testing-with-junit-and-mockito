package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.controller.userApiControllerTest;

import org.junit.jupiter.api.Test;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.SuccessResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDto.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.exception.BaseException;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.testDataFactory.response.success.UserSuccessResponseFactory;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.testDataFactory.user.UserTestDataFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AddUserTest extends AbstractUserApiController {

    @Test
    void whenSuccess() throws BaseException {
        UserCreateRequestDTO userCreateRequestDTO = UserTestDataFactory.createTestUserCreateRequestDTOWithoutId();
        UserResponseDTO expectedUserResponseDTO = UserTestDataFactory.createTestUserResponseDTO();
        SuccessResponse<UserResponseDTO> expectedSuccessResponse = UserSuccessResponseFactory.createAddUserSuccessResponse();
        when(userOrchestrationServiceMock.addUser(userCreateRequestDTO)).thenReturn(expectedSuccessResponse);
        SuccessResponse<UserResponseDTO> actualSuccessResponse = (SuccessResponse<UserResponseDTO>)userApiController.addUser(userCreateRequestDTO).getBody();
        assertNotNull(actualSuccessResponse);
        assertEquals(expectedSuccessResponse.getCode(), actualSuccessResponse.getCode());
        assertEquals(expectedSuccessResponse.getMessage(), actualSuccessResponse.getMessage());
        assertTrue(actualSuccessResponse.getStatus());
        assertNotNull(actualSuccessResponse.getData());
        UserResponseDTO actualUserResponseDTO = (UserResponseDTO) actualSuccessResponse.getData();
        assertObjectData(expectedUserResponseDTO, actualUserResponseDTO);
    }

    private void assertObjectData(UserResponseDTO expectedUserResponseDTO, UserResponseDTO actualUserResponseDTO) {
        assertEquals(expectedUserResponseDTO.getId(), actualUserResponseDTO.getId());
        assertEquals(expectedUserResponseDTO.getFirstName(), actualUserResponseDTO.getFirstName());
        assertEquals(expectedUserResponseDTO.getLastName(), actualUserResponseDTO.getLastName());
        assertEquals(expectedUserResponseDTO.getEmailAddress(), actualUserResponseDTO.getEmailAddress());
        assertEquals(expectedUserResponseDTO.getPhoneNumber(), actualUserResponseDTO.getPhoneNumber());
        assertEquals(expectedUserResponseDTO.getAge(), actualUserResponseDTO.getAge());
    }
}
