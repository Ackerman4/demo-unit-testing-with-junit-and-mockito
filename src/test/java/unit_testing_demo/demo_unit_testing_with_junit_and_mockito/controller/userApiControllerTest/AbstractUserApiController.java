package unit_testing_demo.demo_unit_testing_with_junit_and_mockito.controller.userApiControllerTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.controller.UserApiController;
import unit_testing_demo.demo_unit_testing_with_junit_and_mockito.orchestration.UserOrchestrationService;

@ExtendWith(MockitoExtension.class)
public abstract class AbstractUserApiController {

    @Mock
    protected UserOrchestrationService userOrchestrationServiceMock;

    @InjectMocks
    protected UserApiController userApiController;
}
