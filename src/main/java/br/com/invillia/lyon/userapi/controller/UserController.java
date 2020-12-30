package br.com.invillia.lyon.userapi.controller;

import br.com.invillia.lyon.userapi.producer.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserProducer userProducer;

    @PostMapping("/{id}")
    public HttpStatus create(@PathVariable("id") String id) {
        userProducer.sendUser(id);
        return HttpStatus.OK;
    }
}
