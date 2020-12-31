package br.com.invillia.lyon.userapi.producer;

import br.com.invillia.lyon.userapi.channel.UserChannel;
import br.com.invillia.lyon.userapi.events.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserProducer {

    @Autowired
    private UserChannel userChannel;

    public void sendUser(String id) {

        User user = User.newBuilder()
                .setId(id)
                .build();

        MessageChannel messageChannel = userChannel.outboundUsers();
        messageChannel.send(MessageBuilder
                .withPayload(user)
                .build());

        log.info("id: " + user.getId() + " sent");
    }
}
