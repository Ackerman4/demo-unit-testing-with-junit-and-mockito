package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.SuccessResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.SuccessType;

public class SuccessResponseMapper {
    public static <T> SuccessResponse<T> toSuccessResponse(SuccessType successType, T data) {
        return SuccessResponse.<T>builder()
                .code(successType.getSuccessCode())
                .message(successType.getSuccessMessage())
                .status(successType.getStatus())
                .data(data)
                .build();
    }

    public static <T> SuccessResponse<T> toSuccessResponse(String successCode, String successMessage, Boolean status, T data) {
        return SuccessResponse.<T>builder()
                .code(successCode)
                .message(successMessage)
                .status(status)
                .data(data)
                .build();
    }

    private SuccessResponseMapper() {}
}
