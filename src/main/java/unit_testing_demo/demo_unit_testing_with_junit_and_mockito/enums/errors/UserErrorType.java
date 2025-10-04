package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.ErrorType;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.UserConstant.*;

public enum UserErrorType implements ErrorType {

    USER_NOT_FOUND_ERROR("UE-000", USER_NOT_FOUND, false),
    USER_EMAIL_ADDRESS_ALREADY_EXISTS_ERROR("UE-001", USER_EMAIL_ADDRESS_ALREADY_EXISTS, false),
    USER_ALREADY_EXISTS_ERROR("UE_002", USER_ALREADY_EXISTS, false);

    private final String userErrorCode;
    private final String userErrorMessage;
    private final Boolean userErrorStatus;

    UserErrorType(String userErrorCode, String userErrorMessage, Boolean userErrorStatus) {
        this.userErrorCode = userErrorCode;
        this.userErrorMessage = userErrorMessage;
        this.userErrorStatus = userErrorStatus;
    }

    @Override
    public String getErrorCode() {
        return userErrorCode;
    }

    @Override
    public String getErrorMessage() {
        return userErrorMessage;
    }

    @Override
    public Boolean getStatus() {
        return userErrorStatus;
    }
}
