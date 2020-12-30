package br.com.invillia.lyon.userapi.producer;

import br.com.invillia.lyon.userapi.channel.UserChannel;
import br.com.invillia.lyon.userapi.events.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    @Autowired
    private UserChannel userChannel;

    public Logger logger = LoggerFactory.getLogger(UserProducer.class);

    public void sendUser(String id) {

        User user = User.newBuilder()
                .setId(id)
                .build();

        postUserToKafka(user);

        logger.info("id: " + user.getId() + " sent");
    }

    public void postUserToKafka(User user) {
        MessageChannel messageChannel = userChannel.outboundUsers();
        messageChannel.send(MessageBuilder
                .withPayload(user)
                .build());
    }
}
