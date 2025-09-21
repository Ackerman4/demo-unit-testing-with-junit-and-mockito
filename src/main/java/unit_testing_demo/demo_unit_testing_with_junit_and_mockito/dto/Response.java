package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto;

public interface Response {
    String getCode();
    String getMessage();
    Boolean getStatus();

    void setCode(String code);
    void setMessage(String message);
    void setStatus(Boolean status);
}
