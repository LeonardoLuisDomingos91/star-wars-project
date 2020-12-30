package br.com.invillia.lyon.userapi.testexecution;

import br.com.invillia.lyon.userapi.events.User;
import br.com.invillia.lyon.userapi.factory.UserFactory;
import br.com.invillia.lyon.userapi.producer.UserProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class UserProducerTest {

    private final UserFactory userfactory;

    private final UserProducer userProducer = spy(UserProducer.class);

    @Mock
    private Logger logger;

    @BeforeEach
    public void setup() {
        userProducer.logger = logger;
    }

    @Autowired
    public UserProducerTest(UserFactory userfactory) {
        this.userfactory = userfactory;
    }

    @Test
    void shouldTransportWithSuccess() {
        String id = userfactory.build().getId();
        doNothing().when(userProducer).postUserToKafka(any(User.class));
        userProducer.sendUser(id);

        verify(userProducer, times(1)).postUserToKafka(any(User.class));
        verify(logger, times(1)).info("id: " + id + " received");
        verify(logger, times(1)).info("id: " + id + " sent");

    }
}
