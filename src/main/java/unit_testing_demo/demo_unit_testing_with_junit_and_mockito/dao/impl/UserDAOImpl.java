package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dao.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.dao.UserDAO;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.repository.UserRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);

    }

    @Override
    public Optional<User> getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }
}
