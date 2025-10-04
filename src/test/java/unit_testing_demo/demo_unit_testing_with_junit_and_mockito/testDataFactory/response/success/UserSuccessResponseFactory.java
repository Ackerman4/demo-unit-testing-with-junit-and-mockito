package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.testDataFactory.response.success;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.SuccessResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.SuccessType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.success.UserSuccessType;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.testDataFactory.user.UserTestDataFactory;

public class UserSuccessResponseFactory {

    public static SuccessResponse<UserResponseDTO> createAddUserSuccessResponse() {
        UserResponseDTO userResponseDTO = UserTestDataFactory.createTestUserResponseDTO();
        return toUserSuccessResponse(UserSuccessType.ADD_USER_SUCCESS, userResponseDTO);
    }

    public static SuccessResponse<UserResponseDTO> createGetUserSuccessResponse() {
        UserResponseDTO userResponseDTO = UserTestDataFactory.createTestUserResponseDTO();
        return toUserSuccessResponse(UserSuccessType.FETCH_USER_SUCCESS, userResponseDTO);
    }

    public static <T> SuccessResponse<T> toUserSuccessResponse(SuccessType successType, T data) {
        return SuccessResponse.<T>builder()
                .code(successType.getSuccessCode())
                .message(successType.getSuccessMessage())
                .status(successType.getStatus())
                .data(data)
                .build();
    }
}
