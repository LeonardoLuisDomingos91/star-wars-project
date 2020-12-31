package br.com.invillia.lyon.userapi.testexecution;

import br.com.invillia.lyon.userapi.producer.UserProducer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class UserProducerTest {

    @Test
    void sendIdWithSuccess() {
        Random random = new Random();

        Integer randomNumberId = random.nextInt(10);
        String id = Integer.toString(randomNumberId);

        UserProducer userProducer = Mockito.mock(UserProducer.class);

        userProducer.sendUser(id);

        Mockito.verify(userProducer, Mockito.times(1)).sendUser(id);

    }
}
