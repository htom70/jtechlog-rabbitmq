package employees;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeesQueueListener {

    private final EventsService eventsService;

    @RabbitListener(queues = "employees.queue")
    public void receiveEvent(EmployeeHasCreatedEvent event) {
        eventsService.processEvent(event);
    }
}
