package employees;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventsService {

    public void processEvent(EmployeeHasCreatedEvent event) {
        log.info("Got event: {}", event);
    }
}
