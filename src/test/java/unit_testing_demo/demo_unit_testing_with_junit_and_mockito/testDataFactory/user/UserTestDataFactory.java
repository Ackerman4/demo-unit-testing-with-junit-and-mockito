package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.testDataFactory.user;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.UserRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper.UserMapper;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;

public class UserTestDataFactory {

    public static final String ID_MOCK = "ID123";
    public static final String FIRST_NAME = "FirstName123";
    public static final String LAST_NAME = "LastName123";
    public static final String EMAIL_ADDRESS = "test@email.com";
    public static final String PHONE_NUMBER = "09123456789";
    public static final Integer AGE = 25;

    public static User createTestUserFromUserRequestDTO() {
        UserRequestDTO userRequestDTO = createTestUserRequestDTO();
        return UserMapper.toUser(userRequestDTO);
    }

    public static User createTestUserFromUserCreateRequestDTO() {
        UserCreateRequestDTO userCreateRequestDTO = createTestUserCreateRequestDTOWithId();
        return UserMapper.toNewUser(userCreateRequestDTO);
    }

    public static UserRequestDTO createTestUserRequestDTO() {
        return UserRequestDTO.builder()
                .id(ID_MOCK)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .emailAddress(EMAIL_ADDRESS)
                .phoneNumber(PHONE_NUMBER)
                .age(AGE)
                .build();
    }

    public static UserCreateRequestDTO createTestUserCreateRequestDTOWithId() {
        return UserCreateRequestDTO.builder()
                .id(ID_MOCK)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .emailAddress(EMAIL_ADDRESS)
                .phoneNumber(PHONE_NUMBER)
                .age(AGE)
                .build();
    }

    public static UserCreateRequestDTO createTestUserCreateRequestDTOWithoutId() {
        return UserCreateRequestDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .emailAddress(EMAIL_ADDRESS)
                .phoneNumber(PHONE_NUMBER)
                .age(AGE)
                .build();
    }

    public static UserResponseDTO createTestUserResponseDTO() {
        return UserResponseDTO.builder()
                .id(ID_MOCK)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .emailAddress(EMAIL_ADDRESS)
                .phoneNumber(PHONE_NUMBER)
                .age(AGE)
                .build();
    }
}
