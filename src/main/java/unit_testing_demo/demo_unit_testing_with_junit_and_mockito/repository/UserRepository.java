package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByPhoneNumber(String phoneNumber);

}
