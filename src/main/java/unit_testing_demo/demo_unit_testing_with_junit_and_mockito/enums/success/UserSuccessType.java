package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.success;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.enums.SuccessType;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.UserConstant.USER_ADDED_SUCCESSFULLY;
import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.UserConstant.USER_FETCHED_SUCCESSFULLY;

public enum UserSuccessType implements SuccessType {

    US_000("US-000", USER_ADDED_SUCCESSFULLY, true),
    US_001("US-001", USER_FETCHED_SUCCESSFULLY, true);

    private String userSuccessCode;
    private String userSuccessMessage;
    private Boolean userSuccessStatus;

    UserSuccessType(String userSuccessCode, String userSuccessMessage, Boolean userSuccessStatus) {
        this.userSuccessCode = userSuccessCode;
        this.userSuccessMessage = userSuccessMessage;
        this.userSuccessStatus = userSuccessStatus;
    }

    @Override
    public String getSuccessCode() {
        return userSuccessCode;
    }

    @Override
    public String getSuccessMessage() {
        return userSuccessMessage;
    }

    @Override
    public Boolean getStatus() {
        return userSuccessStatus;
    }
}
