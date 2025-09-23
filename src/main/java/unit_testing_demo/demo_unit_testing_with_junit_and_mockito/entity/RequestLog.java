package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class RequestLog {
    @Id
    private String id;
    private String requestType;
    private String requestDescription;
    private LocalDateTime requestDateTime;
    private LocalDateTime completionDateTime;
    private String requestStatus;

}
