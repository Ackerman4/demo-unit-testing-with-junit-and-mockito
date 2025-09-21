package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.util;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.SuccessResponse;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.SuccessType;

public class SuccessResponseUtil {
    public static SuccessResponse buildSuccessResponse(SuccessType successType, Object data) {
        return SuccessResponse.builder()
                .code(successType.getSuccessCode())
                .message(successType.getSuccessMessage())
                .status(successType.getStatus())
                .data(data)
                .build();
    }

    public static SuccessResponse buildSuccessResponse(String successCode, String successMessage, Boolean status, Object data) {
        return SuccessResponse.builder()
                .code(successCode)
                .message(successMessage)
                .status(status)
                .data(data)
                .build();
    }

    private SuccessResponseUtil() {}
}
