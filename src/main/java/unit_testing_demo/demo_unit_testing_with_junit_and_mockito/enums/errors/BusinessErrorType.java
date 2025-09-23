package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.errors;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.BusinessLogicConstant;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.ErrorType;

public enum BusinessErrorType implements ErrorType {

    BE_000("BE-000", BusinessLogicConstant.MISSING_PARAMETERS, false),
    BE_001("BE-001", BusinessLogicConstant.INVALID_INPUT, false);

    private final String businessErrorCode;
    private final String businessErrorMessage;
    private final Boolean businessErrorStatus;

    private BusinessErrorType(String businessErrorCode, String businessErrorMessage, Boolean businessErrorStatus) {
        this.businessErrorCode = businessErrorCode;
        this.businessErrorMessage = businessErrorMessage;
        this.businessErrorStatus = businessErrorStatus;
    }

    @Override
    public String getErrorCode() {
        return businessErrorCode;
    }

    @Override
    public String getErrorMessage() {
        return businessErrorMessage;
    }

    @Override
    public Boolean getStatus() {
        return businessErrorStatus;
    }
}
