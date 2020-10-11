package employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeesQueueListenerTest {

    @Mock
    EventsService eventsService;

    @InjectMocks
    EmployeesQueueListener listener;

    @Test
    void testReceiveEvent() {
        listener.receiveEvent(new EmployeeHasCreatedEvent("John Doe"));

        verify(eventsService).processEvent(argThat(e -> e.getName().equals("John Doe")));
    }
}
