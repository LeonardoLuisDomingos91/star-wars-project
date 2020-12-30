package br.com.invillia.lyon.userapi.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public interface UserChannel {

    String OUTPUT = "user-output";

    @Output(OUTPUT)
    MessageChannel outboundUsers();
}
