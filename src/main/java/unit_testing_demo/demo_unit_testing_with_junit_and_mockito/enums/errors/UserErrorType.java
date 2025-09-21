package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.ErrorType;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.UserConstant.*;

public enum UserErrorType implements ErrorType {

    UE_000("UE-000", USER_NOT_FOUND, false),
    UE_001("UE-001", USER_EMAIL_ADDRESS_ALREADY_EXISTS, false),
    UE_002("UE_002", USER_ALREADY_EXISTS, false);

    private String userErrorCode;
    private String userErrorMessage;
    private Boolean userErrorStatus;

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
