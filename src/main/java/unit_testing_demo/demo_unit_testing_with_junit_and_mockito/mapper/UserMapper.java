package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.mapper;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.UserRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.create.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;

import java.util.UUID;

public class UserMapper {

    public static User toNewUser(UserCreateRequestDTO userCreateRequestDTO) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setFirstName(userCreateRequestDTO.getFirstName());
        user.setLastName(userCreateRequestDTO.getLastName());
        user.setEmailAddress(userCreateRequestDTO.getEmailAddress());
        user.setPhoneNumber(userCreateRequestDTO.getPhoneNumber());
        user.setAge(userCreateRequestDTO.getAge());
        return user;
    }

    public static User toUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setId(userRequestDTO.getId());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmailAddress(userRequestDTO.getEmailAddress());
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setAge(userRequestDTO.getAge());
        return user;
    }

    public static UserRequestDTO toUserRequestDTO(User user) {
        return UserRequestDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .phoneNumber(user.getPhoneNumber())
                .age(user.getAge())
                .build();
    }

    public static UserResponseDTO toUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .age(user.getAge())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    private UserMapper() {}
}
