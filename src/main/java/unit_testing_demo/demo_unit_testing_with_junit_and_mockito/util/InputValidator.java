package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String LOCAL_PHONE_NUMBER_REGEX = "^09\\d{9}$";
    private static final String ISO_PHONE_NUMBER_REGEX = "^\\+639\\d{9}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern LOCAL_PHONE_NUMBER_PATTERN = Pattern.compile(LOCAL_PHONE_NUMBER_REGEX);
    private static final Pattern ISO_PHONE_NUMBER_PATTERN = Pattern.compile(ISO_PHONE_NUMBER_REGEX);

    public static Boolean validateEmailAddress(String emailAddress) {
        return EMAIL_PATTERN.matcher(emailAddress).matches();
    }

    public static Boolean validatePhoneNumber(String phoneNumber) {
        return LOCAL_PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches() || ISO_PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }

    private InputValidator() {}
}
