package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.SuccessResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.SuccessType;

public class SuccessResponseMapper {
    public static SuccessResponse toSuccessResponse(SuccessType successType, Object data) {
        return SuccessResponse.builder()
                .code(successType.getSuccessCode())
                .message(successType.getSuccessMessage())
                .status(successType.getStatus())
                .data(data)
                .build();
    }

    public static SuccessResponse toSuccessResponse(String successCode, String successMessage, Boolean status, Object data) {
        return SuccessResponse.builder()
                .code(successCode)
                .message(successMessage)
                .status(status)
                .data(data)
                .build();
    }

    private SuccessResponseMapper() {}
}
