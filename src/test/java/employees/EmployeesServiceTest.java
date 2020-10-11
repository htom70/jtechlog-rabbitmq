package employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeesServiceTest {

    @Mock
    RabbitTemplate rabbitTemplate;

    @InjectMocks
    private EmployeesService employeesService;

    @Test
    void testSend() {
        employeesService.createEmployee(new CreateEmployeeCommand("John Doe"));

        verify(rabbitTemplate).convertAndSend(eq("employees.queue"), argThat((Object e) -> ((EmployeeHasCreatedEvent)e).getName().equals("John Doe")));
    }
}
