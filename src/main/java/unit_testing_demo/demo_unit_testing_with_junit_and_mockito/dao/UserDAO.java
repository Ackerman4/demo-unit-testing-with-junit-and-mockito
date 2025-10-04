package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dao;

import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> getUserById(String id);

    Optional<User> getUserByEmailAddress(String emailAddress);

    Optional<User> getUserByPhoneNumber(String phoneNumber);
}
