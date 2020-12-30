package br.com.invillia.lyon.userapi.factory;

import br.com.invillia.lyon.userapi.events.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    private final Faker faker;

    public UserFactory(final Faker faker) {
        this.faker = faker;
    }

    public User build() {
        return User.newBuilder()
                .setId(faker.toString())
                .build();
    }
}
