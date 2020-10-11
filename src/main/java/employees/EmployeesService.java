package employees;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeesService {

    private final RabbitTemplate rabbitTemplate;

    public void createEmployee(CreateEmployeeCommand command) {
        rabbitTemplate.convertAndSend("employees.queue", new EmployeeHasCreatedEvent(command.getName()));
    }
}
