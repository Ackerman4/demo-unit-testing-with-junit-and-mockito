package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.testDataFactory.response.success;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.SuccessResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.SuccessType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.success.UserSuccessType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.testDataFactory.user.UserTestDataFactory;

public class UserSuccessResponseFactory {

    public static SuccessResponse createAddUserSuccessResponse() {
        UserResponseDTO userResponseDTO = UserTestDataFactory.createTestUserResponseDTO();
        return toUserSuccessResponse(UserSuccessType.ADD_USER_SUCCESS, userResponseDTO);
    }

    public static SuccessResponse createGetUserSuccessResponse() {
        UserResponseDTO userResponseDTO = UserTestDataFactory.createTestUserResponseDTO();
        return toUserSuccessResponse(UserSuccessType.FETCH_USER_SUCCESS, userResponseDTO);
    }

    public static SuccessResponse toUserSuccessResponse(SuccessType successType, Object data) {
        return SuccessResponse.builder()
                .code(successType.getSuccessCode())
                .message(successType.getSuccessMessage())
                .status(successType.getStatus())
                .data(data)
                .build();
    }
}
