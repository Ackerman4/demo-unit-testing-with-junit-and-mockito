package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.SystemConstant;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.ErrorType;

public enum SystemErrorType implements ErrorType {

    SE_000("SE-000", SystemConstant.INTERNAL_SERVER_ERROR, false);

    private final String systemErrorCode;
    private final String systemErrorMessage;
    private final Boolean systemErrorStatus;

    SystemErrorType(String systemErrorCode, String systemErrorMessage, Boolean systemErrorStatus) {
        this.systemErrorCode = systemErrorCode;
        this.systemErrorMessage = systemErrorMessage;
        this.systemErrorStatus = systemErrorStatus;
    }

    @Override
    public String getErrorCode() {
        return systemErrorCode;
    }

    @Override
    public String getErrorMessage() {
        return systemErrorMessage;
    }

    @Override
    public Boolean getStatus() {
        return systemErrorStatus;
    }
}
