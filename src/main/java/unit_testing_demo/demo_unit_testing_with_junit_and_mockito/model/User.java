package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import static unit_testing_demo.demo_unit_testing_with_junit_and_mockito.constant.UserConstant.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Integer age;

    public void setId(String id) {
        if (StringUtils.isBlank(id)) throw new IllegalArgumentException(USER_ID_IS_BLANK);
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isBlank(firstName)) throw new IllegalArgumentException(USER_FIRST_NAME_IS_BLANK);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (StringUtils.isBlank(lastName)) throw new IllegalArgumentException(USER_LAST_NAME_IS_BLANK);
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        if (StringUtils.isBlank(emailAddress)) throw new IllegalArgumentException(USER_EMAIL_ADDRESS_IS_BLANK);
        this.emailAddress = emailAddress;
    }

    public void setAge(Integer age) {
        if (age == null || age < 0) throw new IllegalArgumentException(USER_AGE_IS_INVALID);
    }
}
