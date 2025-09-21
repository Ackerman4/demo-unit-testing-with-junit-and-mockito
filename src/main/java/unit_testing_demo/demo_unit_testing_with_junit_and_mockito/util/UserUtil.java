package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.util;

import org.apache.commons.lang3.StringUtils;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.UserRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.request.createRequestDTO.UserCreateRequestDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dto.response.UserResponseDTO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;

import java.util.UUID;

public class UserUtil {

    public static User buildNewUser(UserCreateRequestDTO userCreateRequestDTO) {
        return User.builder()
                .id(UUID.randomUUID().toString())
                .firstName(userCreateRequestDTO.getFirstName())
                .lastName(userCreateRequestDTO.getLastName())
                .emailAddress(userCreateRequestDTO.getEmailAddress())
                .age(userCreateRequestDTO.getAge())
                .build();
    }

    public static User buildUser(UserCreateRequestDTO userCreateRequestDTO) {
        String id = StringUtils.isBlank(userCreateRequestDTO.getId()) ? UUID.randomUUID().toString() : userCreateRequestDTO.getId();
        return User.builder()
                .id(id)
                .firstName(userCreateRequestDTO.getFirstName())
                .lastName(userCreateRequestDTO.getLastName())
                .emailAddress(userCreateRequestDTO.getEmailAddress())
                .age(userCreateRequestDTO.getAge())
                .build();
    }

    public static UserRequestDTO buildUserRequestDTO(User user) {
        return UserRequestDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .age(user.getAge())
                .build();
    }

    public static UserResponseDTO buildUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailAddress(user.getEmailAddress())
                .age(user.getAge())
                .build();
    }

    private UserUtil() {}
}
