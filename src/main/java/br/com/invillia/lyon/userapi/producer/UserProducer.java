package br.com.invillia.lyon.userapi.producer;

import br.com.invillia.lyon.userapi.channel.UserChannel;
import br.com.invillia.lyon.userapi.events.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserProducer {

    private final UserChannel userChannel;

    public UserProducer(final UserChannel userChannel) {
        this.userChannel = userChannel;
    }

    public void sendUser(final String id) {
        final User user = User.newBuilder()
                .setId(id)
                .build();

        final MessageChannel messageChannel = userChannel.outboundUsers();
        messageChannel.send(MessageBuilder
                .withPayload(user)
                .build());

        log.info("M=sendUser, I=evento postado no tópico, id={}", user.getId());
    }
}
