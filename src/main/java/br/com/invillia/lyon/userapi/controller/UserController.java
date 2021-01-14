package br.com.invillia.lyon.userapi.controller;

import br.com.invillia.lyon.userapi.producer.UserProducer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserProducer userProducer;

    public UserController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping("/{id}")
    public void receiveId(@PathVariable("id") String id) {
        userProducer.sendUser(id);
    }
}
